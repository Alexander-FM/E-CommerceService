package com.alexandertutoriales.service.ecommerce.controller;

import java.util.List;

import com.alexandertutoriales.service.ecommerce.entity.Oferta;
import com.alexandertutoriales.service.ecommerce.service.OfertaService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Oferta controller.
 */
@RestController
@RequestMapping("api/oferta")
public class OfertaController {

  private final OfertaService ofertaService;

  /**
   * Instantiates a new Oferta controller.
   *
   * @param ofertaService the oferta producto service
   */
  public OfertaController(OfertaService ofertaService) {
    this.ofertaService = ofertaService;
  }

  /**
   * Listar ofertas
   *
   * @return the generic response
   */
  @GetMapping("/listar-ofertas")
  public GenericResponse<List<Oferta>> listarOfertasProductos() {
    return this.ofertaService.listarOfertas();
  }

}
