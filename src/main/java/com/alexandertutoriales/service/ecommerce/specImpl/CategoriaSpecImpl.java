package com.alexandertutoriales.service.ecommerce.specImpl;

import com.alexandertutoriales.service.ecommerce.entity.Categoria;
import com.alexandertutoriales.service.ecommerce.entity.filters.CategoriaFilter;
import com.alexandertutoriales.service.ecommerce.spec.CategoriaSpec;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CategoriaSpecImpl extends AbstractSpec implements CategoriaSpec {

  @Override
  public Specification<Categoria> filtrar(CategoriaFilter filter) {
    return ((root, query, cb) -> {
      List<Predicate> conditions = new ArrayList<>();
      if (filter.getVerInactivos() == null || filter.getVerInactivos().equals("NO")) {
        conditions.add(cb.equal(root.get(Categoria.C_VIGENCIA),1));
      }
      return and(cb, conditions);
    });
  }
}
