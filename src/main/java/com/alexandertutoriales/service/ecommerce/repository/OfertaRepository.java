package com.alexandertutoriales.service.ecommerce.repository;

import java.util.Date;
import java.util.List;

import com.alexandertutoriales.service.ecommerce.entity.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * The interface Oferta repository.
 */
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

  /**
   * Find by fecha inicio before and fecha fin after list.
   *
   * @param fechaActual the fecha actual
   * @return the list
   */
  @Query("SELECT O FROM Oferta O WHERE O.fechaInicio <= :fechaActual AND O.fechaFin >= :fechaActual")
  List<Oferta> findByFechaInicioBeforeAndFechaFinAfter(Date fechaActual);
}
