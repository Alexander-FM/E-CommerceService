package com.alexandertutoriales.service.ecommerce.repository;

import com.alexandertutoriales.service.ecommerce.entity.OfertaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface Oferta producto repository.
 */
@Repository
public interface OfertaProductoRepository extends JpaRepository<OfertaProducto, Integer> {

  /**
   * Listar ofertas productos iterable por id oferta.
   *
   * @return the iterable
   */
  @Query("SELECT O FROM OfertaProducto O WHERE O.idOferta.id=:idOferta AND O.idPlatillo.vigencia IS true")
  Iterable<OfertaProducto> listarOfertasProductos(int idOferta);
}
