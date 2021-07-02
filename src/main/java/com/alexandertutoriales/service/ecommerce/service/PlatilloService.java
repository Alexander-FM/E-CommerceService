package com.alexandertutoriales.service.ecommerce.service;

import com.alexandertutoriales.service.ecommerce.entity.DocumentoAlmacenado;
import com.alexandertutoriales.service.ecommerce.repository.PlatilloRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.alexandertutoriales.service.ecommerce.utils.Global.*;

@Service
@Transactional
public class PlatilloService {
    private PlatilloRepository repository;
    private DocumentoAlmacenadoService daService;

    public PlatilloService(PlatilloRepository repository, DocumentoAlmacenadoService daService) {
        this.repository = repository;
        this.daService = daService;
    }

    public GenericResponse listarPlatillosRecomendados(){
        return new GenericResponse(TIPO_DATA,
                RPTA_OK,
                OPERACION_CORRECTA,
                this.repository.listarPlatillosRecomendados());
    }
    public GenericResponse listarPlatillosPorCategoria(int idC){
        return new GenericResponse(TIPO_DATA,
                RPTA_OK,
                OPERACION_CORRECTA,
                this.repository.listarPlatillosPorCategoria(idC));
    }
}
