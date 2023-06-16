package com.alexandertutoriales.service.ecommerce.controller;

import com.alexandertutoriales.service.ecommerce.entity.Categoria;
import com.alexandertutoriales.service.ecommerce.entity.filters.CategoriaFilter;
import com.alexandertutoriales.service.ecommerce.service.CategoriaService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("/filtrar")
    public GenericResponse<Page<Categoria>> filtrar(Pageable pageRequest,
        @Valid @RequestBody(required = false) CategoriaFilter filter) {
        return this.service.findAll(pageRequest, filter);
    }
}
