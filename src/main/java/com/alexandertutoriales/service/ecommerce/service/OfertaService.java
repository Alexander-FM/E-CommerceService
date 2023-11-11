package com.alexandertutoriales.service.ecommerce.service;

import static com.alexandertutoriales.service.ecommerce.utils.Global.OPERACION_CORRECTA;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_OK;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_WARNING;
import static com.alexandertutoriales.service.ecommerce.utils.Global.TIPO_DATA;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alexandertutoriales.service.ecommerce.entity.Oferta;
import com.alexandertutoriales.service.ecommerce.repository.OfertaRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;

/**
 * The type Oferta service.
 */
@Service
public class OfertaService {

  private final OfertaRepository ofertaRepository;

  /**
   * Instantiates a new Oferta service.
   *
   * @param ofertaRepository the oferta repository
   */
  public OfertaService(OfertaRepository ofertaRepository) {
    this.ofertaRepository = ofertaRepository;
  }

  /**
   * Listar ofertas.
   *
   * @return the generic response
   */
  public GenericResponse<List<Oferta>> listarOfertas() {
    LocalDate localDate = LocalDate.now();
    Date fechaActual = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    List<Oferta> ofertasActivas =
        ofertaRepository.findByFechaInicioBeforeAndFechaFinAfter(fechaActual);

    if (BooleanUtils.isFalse(ofertasActivas.isEmpty())) {
      return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, ofertasActivas);
    } else {
      return new GenericResponse(TIPO_DATA, RPTA_WARNING, OPERACION_CORRECTA, new ArrayList<>());
    }
  }
}
