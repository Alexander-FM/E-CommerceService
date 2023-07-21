package com.alexandertutoriales.service.ecommerce.repository;

import com.alexandertutoriales.service.ecommerce.entity.DocumentoAlmacenado;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

public interface DocumentoAlmacenadoRepository extends CrudRepository<DocumentoAlmacenado, Long> {
    @Query("SELECT da FROM DocumentoAlmacenado da WHERE da.estado = 'A' AND da.eliminado = false")
    Iterable<DocumentoAlmacenado> list();

    @Query("SELECT da FROM DocumentoAlmacenado da WHERE da.fileName = :fileName AND da.estado = 'A' AND da.eliminado = false")
    Optional<DocumentoAlmacenado> findByFileName(String fileName);

    @Transactional
    @Modifying
    @Query("DELETE FROM DocumentoAlmacenado da WHERE da.id = :id")
    int deleteImageById(Long id);
}
