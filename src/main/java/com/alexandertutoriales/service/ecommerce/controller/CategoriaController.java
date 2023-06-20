package com.alexandertutoriales.service.ecommerce.controller;

import com.alexandertutoriales.service.ecommerce.entity.Categoria;
import com.alexandertutoriales.service.ecommerce.entity.dto.CategoriaDto;
import com.alexandertutoriales.service.ecommerce.entity.filters.CategoriaFilter;
import com.alexandertutoriales.service.ecommerce.exception.UnprocessableEntityException;
import com.alexandertutoriales.service.ecommerce.service.CategoriaService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    /*@PostMapping("/filtrar")
    public GenericResponse<Page<CategoriaDto>> filtrar(Pageable pageRequest,
        @Valid @RequestBody(required = false) CategoriaFilter filter) {
        return this.service.findAll(pageRequest, filter);
    }*/
    @PostMapping("/filtrar")
    public ResponseEntity<Page<CategoriaDto>> filtrar(Pageable pageRequest,
        @Valid @RequestBody(required = false) CategoriaFilter filter) {
        return ResponseEntity.ok(this.service.findAll(pageRequest, filter));
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<CategoriaDto> getCategoriaById(@PathVariable(required = true) int id) {
        CategoriaDto categoriaDto = this.service.findCategoriaById(id);
        return ResponseEntity.ok(categoriaDto);
    }
    @PostMapping
    public ResponseEntity<Integer> create(@Valid @RequestBody CategoriaDto categoriaDto) {
        // No proporcionar identificador en la creación, si lo hace dará un error.
        if (categoriaDto.getId() != null) {
            throw new UnprocessableEntityException();
        }
        Integer id = this.service.save(categoriaDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
    @PutMapping(value = "/{categoriaInfo}")
    public ResponseEntity<Integer> update(@PathVariable(value = "categoriaInfo", required = true) Integer id,
        @Valid @RequestBody CategoriaDto categoriaDto){
        categoriaDto.setId(id);
        Integer categoriaId = this.service.save(categoriaDto);
        return ResponseEntity.ok(categoriaId);
    }

    @DeleteMapping("/deleteCategoria/{categoriaId}")
    public ResponseEntity<Void> deleteContrato(@Valid @PathVariable Integer categoriaId) {
        if (categoriaId == null) {
            throw new UnprocessableEntityException();
        }
        this.service.deleteCategoriaById(categoriaId);
        return ResponseEntity.ok().build();
    }
}
