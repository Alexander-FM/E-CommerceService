package com.alexandertutoriales.service.ecommerce.repository;

import com.alexandertutoriales.service.ecommerce.entity.Categoria;
import com.alexandertutoriales.service.ecommerce.entity.Platillo;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>, JpaSpecificationExecutor<Categoria> {
    @Query("SELECT C FROM Categoria C WHERE C.vigencia IS 1")
    Iterable<Categoria> listarCategoriaActivas();

    @Query("SELECT c FROM Categoria c WHERE c.id = :id")
    Categoria findById(@Param("id") int id);

    @Modifying
    @Query("update Categoria c set c.vigencia = false where c.id = :id")
    void desactivar(@Param("id") Integer id);

    @Modifying
    @Query("update Categoria c set c.vigencia = true where c.id = :id")
    void activar(@Param("id") Integer id);
}
