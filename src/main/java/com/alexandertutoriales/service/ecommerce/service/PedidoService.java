package com.alexandertutoriales.service.ecommerce.service;

import com.alexandertutoriales.service.ecommerce.entity.DetallePedido;
import com.alexandertutoriales.service.ecommerce.entity.Pedido;
import com.alexandertutoriales.service.ecommerce.entity.dto.GenerarPedidoDTO;
import com.alexandertutoriales.service.ecommerce.entity.dto.PedidoConDetallesDTO;
import com.alexandertutoriales.service.ecommerce.repository.DetallePedidoRepository;
import com.alexandertutoriales.service.ecommerce.repository.PedidoRepository;
import com.alexandertutoriales.service.ecommerce.repository.PlatilloRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import static com.alexandertutoriales.service.ecommerce.utils.Global.*;

@Service
@Transactional
public class PedidoService {
    private final PedidoRepository repository;
    private final DetallePedidoRepository detallePedidoRepository;
    private final DetallePedidoService dpService;
    private final PlatilloRepository pRepository;

    public PedidoService(PedidoRepository repository, DetallePedidoRepository detallePedidoRepository, DetallePedidoService dpService, PlatilloRepository pRepository) {
        this.repository = repository;
        this.detallePedidoRepository = detallePedidoRepository;
        this.dpService = dpService;
        this.pRepository = pRepository;
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
            this.pRepository.descontarStock(dp.getCantidad(), dp.getPlatillo().getId());
        }
        //Llamamos al servicio de Detalle Venta para guardar los respectivos detalles del pedido.
        this.dpService.guardarDetalles(dto.getDetallePedido());
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
            pRepository.aumentarStock(dp.getCantidad(), dp.getPlatillo().getId());
        }
    }
}
