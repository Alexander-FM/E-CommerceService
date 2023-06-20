package com.alexandertutoriales.service.ecommerce.entity.dto;

import com.alexandertutoriales.service.ecommerce.entity.DocumentoAlmacenado;

public class CategoriaDto {
  private Integer id;
  private String nombre;
  private boolean vigencia;
  private String vigenciaString;
  //Consideramos como una excepción ya que haríamos diversos cambios aquí.
  private DocumentoAlmacenado foto;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public DocumentoAlmacenado getFoto() {
    return foto;
  }

  public void setFoto(DocumentoAlmacenado foto) {
    this.foto = foto;
  }

  public String getVigenciaString() {
    return vigenciaString;
  }

  public void setVigenciaString(String vigenciaString) {
    this.vigenciaString = vigenciaString;
  }

  public boolean isVigencia() {
    return vigencia;
  }

  public void setVigencia(boolean vigencia) {
    this.vigencia = vigencia;
  }
}
