package com.alexandertutoriales.service.ecommerce.service;

import com.alexandertutoriales.service.ecommerce.entity.Pedido;
import com.alexandertutoriales.service.ecommerce.entity.dto.PedidoConDetallesDTO;
import com.alexandertutoriales.service.ecommerce.repository.ClienteRepository;
import com.alexandertutoriales.service.ecommerce.repository.DetallePedidoRepository;
import com.alexandertutoriales.service.ecommerce.repository.PedidoRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static com.alexandertutoriales.service.ecommerce.utils.Global.*;

@Service
@Transactional
public class PedidoService {
    private final PedidoRepository repository;
    private final DetallePedidoRepository detallePedidoRepository;

    public PedidoService(PedidoRepository repository, DetallePedidoRepository detallePedidoRepository) {
        this.repository = repository;
        this.detallePedidoRepository = detallePedidoRepository;
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
}
