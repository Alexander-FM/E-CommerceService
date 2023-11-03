package com.alexandertutoriales.service.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DetallePedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private int cantidad;

  @Column
  private Double precio;

  @ManyToOne
  private Platillo platillo;//Muchos platillos pueden estar en un detallePedido (Hace referencia a la clase actual).

  @ManyToOne
  private Pedido pedido;//Muchos Detalles pueden estar en un pedido

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public Double getPrecio() {
    return precio;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public Platillo getPlatillo() {
    return platillo;
  }

  public void setPlatillo(Platillo platillo) {
    this.platillo = platillo;
  }

  public String getNombre() {
    return this.platillo != null ? this.platillo.getNombre() : "---";
  }

  public Double getSubTotal() {
    return this.cantidad * this.precio;
  }

}
