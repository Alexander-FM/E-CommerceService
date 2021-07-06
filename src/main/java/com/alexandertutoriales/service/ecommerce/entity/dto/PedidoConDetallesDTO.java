package com.alexandertutoriales.service.ecommerce.entity.dto;

import com.alexandertutoriales.service.ecommerce.entity.DetallePedido;
import com.alexandertutoriales.service.ecommerce.entity.Pedido;
import com.alexandertutoriales.service.ecommerce.repository.PedidoRepository;

import java.util.ArrayList;
import java.util.List;

public class PedidoConDetallesDTO {
    private Pedido pedido;
    private Iterable<DetallePedido> detallePedidos;

    public PedidoConDetallesDTO() {
        this.pedido = new Pedido();
        this.detallePedidos = new ArrayList<>();
    }

    public PedidoConDetallesDTO(Pedido pedido, Iterable<DetallePedido> detallePedidos) {
        this.pedido = pedido;
        this.detallePedidos = detallePedidos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Iterable<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(Iterable<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }
}
