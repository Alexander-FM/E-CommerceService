package com.alexandertutoriales.service.ecommerce.entity.dto;

import java.io.Serializable;

import com.alexandertutoriales.service.ecommerce.entity.DetallePedido;
import com.alexandertutoriales.service.ecommerce.entity.Pedido;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerarPedidoDTO implements Serializable {

  private Pedido pedido;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Iterable<DetallePedido> detallePedido;

  public GenerarPedidoDTO() {
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public Iterable<DetallePedido> getDetallePedido() {
    return detallePedido;
  }

  public void setDetallePedido(Iterable<DetallePedido> detallePedido) {
    this.detallePedido = detallePedido;
  }
}
