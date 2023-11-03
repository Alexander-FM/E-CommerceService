package com.alexandertutoriales.service.ecommerce.controller;

import java.util.List;

import com.alexandertutoriales.service.ecommerce.entity.OfertaProducto;
import com.alexandertutoriales.service.ecommerce.service.OfertaProductoService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Oferta producto controller.
 */
@RestController
@RequestMapping("api/oferta-producto")
public class OfertaProductoController {

  private final OfertaProductoService ofertaProductoService;

  /**
   * Instantiates a new Oferta producto controller.
   *
   * @param ofertaProductoService the oferta producto service
   */
  public OfertaProductoController(OfertaProductoService ofertaProductoService) {
    this.ofertaProductoService = ofertaProductoService;
  }

  /**
   * Listar ofertas productos por id oferta.
   *
   * @return the generic response
   */
  @GetMapping("/listar-ofertas-productos/{idOferta}")
  public GenericResponse<List<OfertaProducto>> listarOfertasProductos(@PathVariable int idOferta) {
    return this.ofertaProductoService.listarOfertasProductos(idOferta);
  }

}
