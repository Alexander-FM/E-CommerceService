package com.alexandertutoriales.service.ecommerce.controller;

import com.alexandertutoriales.service.ecommerce.entity.DocumentoAlmacenado;
import com.alexandertutoriales.service.ecommerce.service.DocumentoAlmacenadoService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/documento-almacenado")
public class DocumentoAlmacenadoController {

  private DocumentoAlmacenadoService service;

  public DocumentoAlmacenadoController(DocumentoAlmacenadoService service) {
    this.service = service;
  }

  @GetMapping
  public GenericResponse list() {
    return service.list();
  }

  @GetMapping("/{id}")
  public GenericResponse find(@PathVariable Long id) {
    return null;
  }

  @GetMapping("/download/{fileName}")
  public ResponseEntity<Resource> download(@PathVariable String fileName, HttpServletRequest request) {
    return service.downloadByFileName(fileName, request);
  }

  @PostMapping
  public GenericResponse save(@ModelAttribute DocumentoAlmacenado obj) {
    return service.save(obj);
  }

  @PutMapping("/editImage/{id}")
  public GenericResponse update(@PathVariable Long id, @ModelAttribute DocumentoAlmacenado obj) {
    obj.setId(id);
    return service.save(obj);
  }

  @DeleteMapping("/deleteImage/{id}")
  public GenericResponse delete(@PathVariable Long id) {
    return service.deleteById(id);
  }
}
