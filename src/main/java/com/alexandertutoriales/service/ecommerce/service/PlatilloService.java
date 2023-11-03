package com.alexandertutoriales.service.ecommerce.service;

import static com.alexandertutoriales.service.ecommerce.utils.Global.OPERACION_CORRECTA;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_OK;
import static com.alexandertutoriales.service.ecommerce.utils.Global.TIPO_DATA;

import com.alexandertutoriales.service.ecommerce.repository.PlatilloRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PlatilloService {

  private PlatilloRepository repository;

  private DocumentoAlmacenadoService daService;

  public PlatilloService(PlatilloRepository repository, DocumentoAlmacenadoService daService) {
    this.repository = repository;
    this.daService = daService;
  }

  public GenericResponse listarPlatillosRecomendados() {
    return new GenericResponse(TIPO_DATA,
        RPTA_OK,
        OPERACION_CORRECTA,
        this.repository.listarPlatillosRecomendados());
  }

  public GenericResponse listarPlatillosPorCategoria(int idC) {
    return new GenericResponse(TIPO_DATA,
        RPTA_OK,
        OPERACION_CORRECTA,
        this.repository.listarPlatillosPorCategoria(idC));
  }
}
