package com.alexandertutoriales.service.ecommerce.service;

import com.alexandertutoriales.service.ecommerce.entity.Categoria;
import com.alexandertutoriales.service.ecommerce.entity.dto.CategoriaDto;
import com.alexandertutoriales.service.ecommerce.entity.filters.CategoriaFilter;
import com.alexandertutoriales.service.ecommerce.mapper.CategoriaMapper;
import com.alexandertutoriales.service.ecommerce.repository.CategoriaRepository;
import com.alexandertutoriales.service.ecommerce.spec.CategoriaSpec;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import static com.alexandertutoriales.service.ecommerce.utils.Global.*;

@Service
@Transactional
public class CategoriaService {
    private final CategoriaRepository repository;
    private final CategoriaSpec spec;
    private final CategoriaMapper mapper;

    public CategoriaService(CategoriaRepository repository, CategoriaSpec spec, CategoriaMapper mapper) {
        this.repository = repository;
        this.spec = spec;
        this.mapper = mapper;
    }

    public GenericResponse listarCategoriasActivas() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA,
                this.repository.listarCategoriaActivas());
    }

    public GenericResponse<Page<CategoriaDto>> findAll(Pageable page, CategoriaFilter filter){
        if(page.getSort() == null){
            List<Order> listaOrden = new ArrayList<>();
            listaOrden.add(new Order(Direction.ASC, Categoria.C_NOMBRE));
            Sort sort = Sort.by(listaOrden);
            page = PageRequest.of(page.getPageNumber(), page.getPageSize(), sort);
        }
        // Page<Categoria> lista = repository.findAll(spec.filtrar(filter), page);
        // return new GenericResponse<>(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, mapper.toDto(lista));
        Page<CategoriaDto> lista = mapper.toDto(repository.findAll(spec.filtrar(filter), page));
        return new GenericResponse<>(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, lista);
    }
}
