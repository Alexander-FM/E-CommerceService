package com.alexandertutoriales.service.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
  private Date fechaCompra;

  @ManyToOne//Muchos Registros de Pedido puede contener un solo cliente
  private Cliente cliente;

  @Column
  private Double monto;

  @Column
  private boolean anularPedido;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getFechaCompra() {
    return fechaCompra;
  }

  public void setFechaCompra(Date fechaCompra) {
    this.fechaCompra = fechaCompra;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Double getMonto() {
    return monto;
  }

  public void setMonto(Double monto) {
    this.monto = monto;
  }

  public boolean isAnularPedido() {
    return anularPedido;
  }

  public void setAnularPedido(boolean anularPedido) {
    this.anularPedido = anularPedido;
  }

}
