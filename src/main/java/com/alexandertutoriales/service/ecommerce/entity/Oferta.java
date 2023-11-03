package com.alexandertutoriales.service.ecommerce.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Oferta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  @Temporal(TemporalType.DATE)
  @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
  private Date fechaInicio;

  @Column
  @Temporal(TemporalType.DATE)
  @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
  private Date fechaFin;

  @Column
  private String nombreOferta;

  @Column
  private String descripcionOferta;

  @Column
  private boolean vigencia;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public Date getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(Date fechaFin) {
    this.fechaFin = fechaFin;
  }

  public String getNombreOferta() {
    return nombreOferta;
  }

  public void setNombreOferta(String nombreOferta) {
    this.nombreOferta = nombreOferta;
  }

  public String getDescripcionOferta() {
    return descripcionOferta;
  }

  public void setDescripcionOferta(String descripcionOferta) {
    this.descripcionOferta = descripcionOferta;
  }

  public boolean isVigencia() {
    return vigencia;
  }

  public void setVigencia(boolean vigencia) {
    this.vigencia = vigencia;
  }

}
