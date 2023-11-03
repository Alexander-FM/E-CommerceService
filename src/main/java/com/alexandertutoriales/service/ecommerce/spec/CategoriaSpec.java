package com.alexandertutoriales.service.ecommerce.spec;

import com.alexandertutoriales.service.ecommerce.entity.Categoria;
import com.alexandertutoriales.service.ecommerce.entity.filters.CategoriaFilter;
import org.springframework.data.jpa.domain.Specification;

public interface CategoriaSpec {

  Specification<Categoria> filtrar(CategoriaFilter filter);

}
