package com.alexandertutoriales.service.ecommerce.service;

import static com.alexandertutoriales.service.ecommerce.utils.Global.OPERACION_CORRECTA;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_OK;
import static com.alexandertutoriales.service.ecommerce.utils.Global.TIPO_DATA;

import java.io.ByteArrayOutputStream;
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
import java.util.Objects;
import java.util.Optional;

import com.alexandertutoriales.service.ecommerce.entity.DetallePedido;
import com.alexandertutoriales.service.ecommerce.entity.Pedido;
import com.alexandertutoriales.service.ecommerce.entity.Usuario;
import com.alexandertutoriales.service.ecommerce.entity.dto.GenerarPedidoDTO;
import com.alexandertutoriales.service.ecommerce.entity.dto.PedidoConDetallesDTO;
import com.alexandertutoriales.service.ecommerce.publisher.Publisher;
import com.alexandertutoriales.service.ecommerce.repository.DetallePedidoRepository;
import com.alexandertutoriales.service.ecommerce.repository.PedidoRepository;
import com.alexandertutoriales.service.ecommerce.repository.PlatilloRepository;
import com.alexandertutoriales.service.ecommerce.repository.UsuarioRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.util.StreamUtils;

/**
 * The type Pedido service.
 */
@Slf4j
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

  private final Publisher publisher;

  /**
   * Instantiates a new Pedido service.
   *
   * @param repository the repository.
   * @param detallePedidoRepository the detalle pedido repository.
   * @param dpService the dp service.
   * @param platilloRepository the platillo repository.
   * @param template the template.
   * @param javaMailSender the java mail sender.
   * @param usuarioRepository the usuario repository.
   * @param publisher the publisher.
   */
  public PedidoService(PedidoRepository repository, DetallePedidoRepository detallePedidoRepository, DetallePedidoService dpService,
      PlatilloRepository platilloRepository, SimpMessagingTemplate template, JavaMailSender javaMailSender,
      UsuarioRepository usuarioRepository, Publisher publisher) {
    this.repository = repository;
    this.detallePedidoRepository = detallePedidoRepository;
    this.dpService = dpService;
    this.platilloRepository = platilloRepository;
    this.template = template;
    this.javaMailSender = javaMailSender;
    this.usuarioRepository = usuarioRepository;
    this.publisher = publisher;
  }

  /**
   * Devolver mis compras.
   *
   * @param idCli the id cli
   * @return the generic response
   */
  public GenericResponse<List<PedidoConDetallesDTO>> devolverMisCompras(int idCli) {
    final List<PedidoConDetallesDTO> dtos = new ArrayList<>();
    final Iterable<Pedido> pedidos = repository.devolverMisCompras(idCli);
    pedidos.forEach(p -> {
      dtos.add(new PedidoConDetallesDTO(p, detallePedidoRepository.findByPedido(p.getId())));
    });
    return new GenericResponse(OPERACION_CORRECTA, RPTA_OK, "Petición encontrada", dtos);
  }

  /**
   * Guardar pedido.
   *
   * @param dto the dto
   * @return the generic response
   */
  public GenericResponse guardarPedido(GenerarPedidoDTO dto) {
    Date date = new Date();
    dto.getPedido().setFechaCompra(new java.sql.Date(date.getTime()));
    dto.getPedido().setAnularPedido(false);
    dto.getPedido().setMonto(dto.getPedido().getMonto());
    dto.getPedido().setCliente(dto.getCliente());
    //log.info("Message '{}' will be send ... ", dto);
    System.out.println("Message '{}' will be send" + dto);
    this.publisher.send(dto);
    final Pedido pedidoGuardado = this.repository.save(dto.getPedido());
    for (DetallePedido dp : dto.getDetallePedido()) {
      dp.setPedido(dto.getPedido());
      this.platilloRepository.descontarStock(dp.getCantidad(), dp.getPlatillo().getId());
    }
    this.dpService.guardarDetalles(dto.getDetallePedido());
    this.template.convertAndSend("/topic/pedido-notification", dto);
    ResponseEntity<Resource> reporte = exportInvoice(pedidoGuardado.getCliente().getId(), pedidoGuardado.getId());
    sendInvoiceByEmail(pedidoGuardado, reporte);
    return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, dto);
  }

  /**
   * Anular pedido.
   *
   * @param id the id
   * @return the generic response
   */
  public GenericResponse anular(int id) {
    Pedido p = this.repository.findById(id).orElse(new Pedido());
    if (p.getId() != 0) {
      p.setAnularPedido(true);
      this.restablecerStock(id);
      this.repository.save(p);
      return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, p);
    } else {
      return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, "El pedido que desea anular no es válido");
    }
  }

  /**
   * Restablecer stock.
   *
   * @param pedidoId the pedido.
   */
  private void restablecerStock(final int pedidoId) {
    Iterable<DetallePedido> detalles = this.detallePedidoRepository.findByPedido(pedidoId);
    for (DetallePedido dp : detalles) {
      platilloRepository.aumentarStock(dp.getCantidad(), dp.getPlatillo().getId());
    }
  }

  /**
   * Exportar reporte.
   *
   * @param idCli the id cli
   * @param idOrden the id orden
   * @return the response entity
   */
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
            .filename(var1.append(pedido.getId()).append("generatedate:").append(sdf).append(".pdf").toString()).build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(contentDisposition);
        return ResponseEntity.ok().contentLength((long) reporte.length).contentType(MediaType.APPLICATION_PDF).headers(headers)
            .body(new ByteArrayResource(reporte));
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      return ResponseEntity.noContent().build(); //No se encontró el contenido
    }
    return ResponseEntity.noContent().build();
  }

  /**
   * Calcular porcentaje.
   *
   * @param precio the precio
   * @param porcentaje the porcentaje
   * @return the double
   */
  public static Double calcularPorcentaje(final Double precio, final Integer porcentaje) {
    return (precio * porcentaje) / 100.0;
  }

  /**
   * Enviar reporte por correo.
   *
   * @param pedido the pedido
   * @param facturaPDF the factura pdf
   */
  private void sendInvoiceByEmail(Pedido pedido, ResponseEntity<Resource> facturaPDF) {
    try {
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);

      Optional<Usuario> usuario = usuarioRepository.findUsuarioByClienteId(pedido.getCliente().getId());
      if (usuario.isPresent()) {
        helper.setTo(usuario.get().getEmail());
        helper.setSubject("Factura de compra");
        String mensaje = "Hola, " + pedido.getCliente().getNombreCompletoCliente()
            + "\nGracias por su compra."
            + "\nAdjuntamos la factura correspondiente."
            + "\nPor tu seguridad, el PDF de tu factura está encriptado, al momento de abrirlo introduce tu número de documento de "
            + "identidad con el que te registraste.";
        helper.setText(mensaje);
        byte[] pdfBytes = StreamUtils.copyToByteArray(Objects.requireNonNull(facturaPDF.getBody()).getInputStream());
        String dni = pedido.getCliente().getNumDoc();
        String nombreArchivo = buildCustomFileName(pedido);
        helper.addAttachment(nombreArchivo, new ByteArrayResource(encryptPdf(pdfBytes, dni)));
      }
      javaMailSender.send(message);
    } catch (Exception e) {
      e.printStackTrace();
      // Manejar la excepción de envío de correo electrónico según tus necesidades
    }
  }

  /**
   * Encriptar el PDF.
   *
   * @param pdfBytes the pedido
   * @param password the factura pdf
   */
  private byte[] encryptPdf(byte[] pdfBytes, String password) throws Exception {
    PdfReader reader = new PdfReader(pdfBytes);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PdfStamper stamper = new PdfStamper(reader, baos);
    stamper.setEncryption(password.getBytes(), password.getBytes(),
        PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
    stamper.close();
    reader.close();
    return baos.toByteArray();
  }

  /**
   * Construye un nombre personalizado para el reporte.
   *
   * @param pedido the pedido
   */
  private String buildCustomFileName(Pedido pedido) {
    String idCompra = "C" + String.format("%04d", pedido.getId()); // Formato CXXX (donde XXX es el id de la compra)

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
    String fechaCompra = dateFormat.format(pedido.getFechaCompra());

    // Construir el nombre del archivo PDF
    return "factura" + idCompra + "_" + fechaCompra + ".pdf";
  }
}
