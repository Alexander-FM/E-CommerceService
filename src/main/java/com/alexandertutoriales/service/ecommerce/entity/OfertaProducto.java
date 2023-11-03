package com.alexandertutoriales.service.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OfertaProducto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  private Oferta idOferta;

  @ManyToOne
  private Platillo idPlatillo;

  @Column(length = 3)
  private int descuento;

  @Column
  private Double precioAhora;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Oferta getIdOferta() {
    return idOferta;
  }

  public void setIdOferta(Oferta idOferta) {
    this.idOferta = idOferta;
  }

  public Platillo getIdPlatillo() {
    return idPlatillo;
  }

  public void setIdPlatillo(Platillo idPlatillo) {
    this.idPlatillo = idPlatillo;
  }

  public int getDescuento() {
    return descuento;
  }

  public void setDescuento(int descuento) {
    this.descuento = descuento;
  }

  public Double getPrecioAhora() {
    return precioAhora;
  }

  public void setPrecioAhora(Double precioAhora) {
    this.precioAhora = precioAhora;
  }
}
