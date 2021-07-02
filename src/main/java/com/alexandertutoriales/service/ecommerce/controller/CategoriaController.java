package com.alexandertutoriales.service.ecommerce.controller;

import com.alexandertutoriales.service.ecommerce.service.CategoriaService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }
    @GetMapping
    public GenericResponse listarPlatillosRecomendados() {
        return this.service.listarCategoriasActivas();
    }

}
