package com.alexandertutoriales.service.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Empleado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 100)
  private String nombre;
  @Column(length = 100)
  private String apellidos;
  @Column
  private boolean vigencia;
  @OneToOne
  private Rol rol;
  @Transient
  private String vigenciaString;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public boolean isVigencia() {
    return vigencia;
  }

  public void setVigencia(boolean vigencia) {
    this.vigencia = vigencia;
  }

  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }

  public String getVigenciaString() {
    return vigenciaString;
  }

  public void setVigenciaString(String vigenciaString) {
    this.vigenciaString = vigenciaString;
  }
}
