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

  @Column(length = 3)
  private String tipo_documento;

  @Column(length = 11)
  private String numero_documento;

  @Column(length = 50)
  private String username;

  @Column(length = 10)
  private String password;

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

  public String getTipo_documento() {
    return tipo_documento;
  }

  public void setTipo_documento(String tipo_documento) {
    this.tipo_documento = tipo_documento;
  }

  public String getNumero_documento() {
    return numero_documento;
  }

  public void setNumero_documento(String numero_documento) {
    this.numero_documento = numero_documento;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
