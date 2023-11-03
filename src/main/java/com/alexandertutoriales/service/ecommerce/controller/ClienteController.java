package com.alexandertutoriales.service.ecommerce.controller;

import com.alexandertutoriales.service.ecommerce.entity.Cliente;
import com.alexandertutoriales.service.ecommerce.service.ClienteService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

  private final ClienteService service;

  public ClienteController(ClienteService service) {
    this.service = service;
  }

  @PostMapping()
  public GenericResponse save(@Valid @RequestBody Cliente c) {
    return this.service.save(c);
  }

  @PutMapping("/{id}")
  public GenericResponse update(@PathVariable int id, @Valid @RequestBody Cliente c) {
    c.setId(id);
    return this.service.save(c);
  }

}
