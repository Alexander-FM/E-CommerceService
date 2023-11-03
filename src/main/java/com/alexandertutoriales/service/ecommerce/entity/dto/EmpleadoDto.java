package com.alexandertutoriales.service.ecommerce.entity.dto;

public class EmpleadoDto {

  private Long id;

  private String nombre;

  private String apellidos;

  private boolean vigencia;

  private RolDto rol;

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

  public RolDto getRol() {
    return rol;
  }

  public void setRol(RolDto rol) {
    this.rol = rol;
  }

  public String getVigenciaString() {
    return vigenciaString;
  }

  public void setVigenciaString(String vigenciaString) {
    this.vigenciaString = vigenciaString;
  }
}
