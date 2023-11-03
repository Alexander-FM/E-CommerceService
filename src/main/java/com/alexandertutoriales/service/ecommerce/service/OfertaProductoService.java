package com.alexandertutoriales.service.ecommerce.service;

import static com.alexandertutoriales.service.ecommerce.utils.Global.OPERACION_CORRECTA;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_OK;
import static com.alexandertutoriales.service.ecommerce.utils.Global.TIPO_DATA;

import java.util.List;

import com.alexandertutoriales.service.ecommerce.entity.OfertaProducto;
import com.alexandertutoriales.service.ecommerce.repository.OfertaProductoRepository;
import com.alexandertutoriales.service.ecommerce.repository.OfertaRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import org.springframework.stereotype.Service;

/**
 * The type Oferta producto service.
 */
@Service
public class OfertaProductoService {

  private final OfertaProductoRepository ofertaProductoRepository;

  private final OfertaRepository ofertaRepository;

  /**
   * Instantiates a new Oferta producto service.
   *
   * @param ofertaProductoRepository the oferta producto repository
   * @param ofertaRepository the oferta repository
   */
  public OfertaProductoService(OfertaProductoRepository ofertaProductoRepository, OfertaRepository ofertaRepository) {
    this.ofertaProductoRepository = ofertaProductoRepository;
    this.ofertaRepository = ofertaRepository;
  }

  /**
   * Listar ofertas productos por id oferta.
   *
   * @return the generic response
   */
  public GenericResponse<List<OfertaProducto>> listarOfertasProductos(int idOferta) {
    return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA,
        this.ofertaProductoRepository.listarOfertasProductos(idOferta));
  }

}
