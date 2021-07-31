package com.alexandertutoriales.service.ecommerce.service;

import com.alexandertutoriales.service.ecommerce.entity.DetallePedido;
import com.alexandertutoriales.service.ecommerce.repository.DetallePedidoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DetallePedidoService {
    private DetallePedidoRepository repository;

    public DetallePedidoService(DetallePedidoRepository repository) {
        this.repository = repository;
    }
    //Método para guardar detalles del pedido
    public void guardarDetalles(Iterable<DetallePedido> detalles){
        this.repository.saveAll(detalles);
    }
}
