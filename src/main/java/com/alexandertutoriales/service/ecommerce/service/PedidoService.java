package com.alexandertutoriales.service.ecommerce.service;

import static com.alexandertutoriales.service.ecommerce.utils.Global.OPERACION_CORRECTA;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_OK;
import static com.alexandertutoriales.service.ecommerce.utils.Global.TIPO_DATA;

import java.io.File;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import com.alexandertutoriales.service.ecommerce.entity.DetallePedido;
import com.alexandertutoriales.service.ecommerce.entity.Pedido;
import com.alexandertutoriales.service.ecommerce.entity.Usuario;
import com.alexandertutoriales.service.ecommerce.entity.dto.GenerarPedidoDTO;
import com.alexandertutoriales.service.ecommerce.entity.dto.PedidoConDetallesDTO;
import com.alexandertutoriales.service.ecommerce.repository.DetallePedidoRepository;
import com.alexandertutoriales.service.ecommerce.repository.PedidoRepository;
import com.alexandertutoriales.service.ecommerce.repository.PlatilloRepository;
import com.alexandertutoriales.service.ecommerce.repository.UsuarioRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
@Transactional
public class PedidoService {

  private final PedidoRepository repository;

  private final DetallePedidoRepository detallePedidoRepository;

  private final DetallePedidoService dpService;

  private final PlatilloRepository platilloRepository;

  private final SimpMessagingTemplate template;

  private final JavaMailSender javaMailSender;

  private final UsuarioRepository usuarioRepository;

  public PedidoService(PedidoRepository repository, DetallePedidoRepository detallePedidoRepository, DetallePedidoService dpService,
      PlatilloRepository platilloRepository, SimpMessagingTemplate template, JavaMailSender javaMailSender,
      UsuarioRepository usuarioRepository) {
    this.repository = repository;
    this.detallePedidoRepository = detallePedidoRepository;
    this.dpService = dpService;
    this.platilloRepository = platilloRepository;
    this.template = template;
    this.javaMailSender = javaMailSender;
    this.usuarioRepository = usuarioRepository;
  }

  //Método para devolver los pedidos con detalles
  public GenericResponse<List<PedidoConDetallesDTO>> devolverMisCompras(int idCli) {
    final List<PedidoConDetallesDTO> dtos = new ArrayList<>();
    final Iterable<Pedido> pedidos = repository.devolverMisCompras(idCli);
    pedidos.forEach(p -> {
      dtos.add(new PedidoConDetallesDTO(p, detallePedidoRepository.findByPedido(p.getId())));
    });
    return new GenericResponse(OPERACION_CORRECTA, RPTA_OK, "Petición encontrada", dtos);
  }

  //Método para guardar el pedido.
  public GenericResponse guardarPedido(GenerarPedidoDTO dto) {
    Date date = new Date();
    dto.getPedido().setFechaCompra(new java.sql.Date(date.getTime()));
    dto.getPedido().setAnularPedido(false);
    dto.getPedido().setMonto(dto.getPedido().getMonto());
    dto.getPedido().setCliente(dto.getCliente());
    this.repository.save(dto.getPedido());
    for (DetallePedido dp : dto.getDetallePedido()) {
      dp.setPedido(dto.getPedido());
      this.platilloRepository.descontarStock(dp.getCantidad(), dp.getPlatillo().getId());
    }
    this.dpService.guardarDetalles(dto.getDetallePedido());
    this.template.convertAndSend("/topic/pedido-notification", dto);
    return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, dto);
  }

  //Otra manera de hacer el guardarPedido con la instancia de la clase pedido
  public GenericResponse guardarPedido2(GenerarPedidoDTO dto) {
    Date date = new Date();
    Pedido p = new Pedido();
    p.setFechaCompra(new java.sql.Date(date.getTime()));
    p.setAnularPedido(false);
    p.setMonto(dto.getPedido().getMonto());
    p.setCliente(dto.getCliente());
    p = this.repository.save(p); //Guarda los datos de la venta en la tabla de bd
    for (DetallePedido dp :
        dto.getDetallePedido()) {
      dp.setPedido(p);
    }
    this.dpService.guardarDetalles(dto.getDetallePedido());
    return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, dto);
  }

  //Método para anular el pedido
  public GenericResponse anular(int id) {
    Pedido p = this.repository.findById(id).orElse(new Pedido());
    if (p.getId() != 0) {
      p.setAnularPedido(true);
      this.restablecerStock(id);
      this.repository.save(p);
      return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, p);
    } else {
      return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA,
          "El pedido que desea anular no es válido");
    }
  }

  private void restablecerStock(final int pedidoId) {
    Iterable<DetallePedido> detalles = this.detallePedidoRepository.findByPedido(pedidoId);
    for (DetallePedido dp : detalles) {
      platilloRepository.aumentarStock(dp.getCantidad(), dp.getPlatillo().getId());
    }
  }

  @NotNull
  public ResponseEntity<Resource> exportInvoice(int idCli, int idOrden) {
    Optional<Pedido> optPedido = this.repository.findByIdAndClienteId(idCli, idOrden);
    Double total = this.detallePedidoRepository.totalByIdCustomer(idCli, idOrden);
    Double igv = calcularPorcentaje(total, 18);
    if (optPedido.isPresent()) {
      try {
        final Pedido pedido = optPedido.get();
        final File file = ResourceUtils.getFile("classpath:exportInvoice.jasper");
        final File imgLogo = ResourceUtils.getFile("classpath:images/logoBisuteria.png");
        final JasperReport report = (JasperReport) JRLoader.loadObject(file);

        Locale locale = new Locale("es", "PE"); // Especifica el idioma y país según tu preferencia
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String formattedTotal = currencyFormatter.format(total);
        String formattedIGV = currencyFormatter.format(igv);
        final HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("nombreCliente", pedido.getCliente().getNombreCompletoCliente());
        parameters.put("imgLogo", new FileInputStream(imgLogo));
        parameters.put("total", formattedTotal);
        parameters.put("igv", formattedIGV);
        parameters.put("dsInvoice", new JRBeanCollectionDataSource((Collection<?>) this.detallePedidoRepository.findByPedido(idOrden)));

        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
        byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);
        String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
        StringBuilder var1 = new StringBuilder().append("invoicePDF:");
        ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
            .filename(var1.append(pedido.getId())
                .append("generatedate:")
                .append(sdf).append(".pdf")
                .toString()).build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(contentDisposition);
        sendInvoiceByEmail(pedido, reporte);
        return ResponseEntity.ok().contentLength((long) reporte.length)
            .contentType(MediaType.APPLICATION_PDF)
            .headers(headers).body(new ByteArrayResource(reporte));
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      return ResponseEntity.noContent().build();//No se encontro el contenido
    }
    return null;
  }

  public static Double calcularPorcentaje(final Double precio, final Integer porcentaje) {
    return (precio * porcentaje) / 100.0;
  }

  private void sendInvoiceByEmail(Pedido pedido, byte[] reporte) {
    try {
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);

      Optional<Usuario> usuario = usuarioRepository.findUsuarioByClienteId(pedido.getCliente().getId());
      if (usuario.isPresent()) {
        helper.setTo(usuario.get().getEmail());
      } else {
        helper.setTo("correoinvalid@gmail.com");
      }
      helper.setSubject("Factura de compra");
      // Puedes agregar el cuerpo del correo electrónico si es necesario
      helper.setText("Gracias por su compra. Adjuntamos la factura correspondiente.");
      // Adjunta el informe PDF
      helper.addAttachment("invoice.pdf", new ByteArrayResource(reporte));

      javaMailSender.send(message);
    } catch (Exception e) {
      e.printStackTrace();
      // Manejar la excepción de envío de correo electrónico según tus necesidades
    }
  }
}
