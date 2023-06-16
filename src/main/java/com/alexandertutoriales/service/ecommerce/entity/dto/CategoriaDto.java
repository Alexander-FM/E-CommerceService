package com.alexandertutoriales.service.ecommerce.entity.dto;

import com.alexandertutoriales.service.ecommerce.entity.DocumentoAlmacenado;

public class CategoriaDto {
  private int id;
  private String nombre;
  private boolean vigencia;
  //Consideramos como una excepción ya que haríamos diversos cambios aquí.
  private DocumentoAlmacenado foto;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public boolean isVigencia() {
    return vigencia;
  }

  public void setVigencia(boolean vigencia) {
    this.vigencia = vigencia;
  }

  public DocumentoAlmacenado getFoto() {
    return foto;
  }

  public void setFoto(DocumentoAlmacenado foto) {
    this.foto = foto;
  }
}
