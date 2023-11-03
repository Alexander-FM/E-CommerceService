package com.alexandertutoriales.service.ecommerce.repository;

import com.alexandertutoriales.service.ecommerce.entity.Platillo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlatilloRepository extends CrudRepository<Platillo, Integer> {

  @Query("SELECT P FROM Platillo P WHERE P.recomendado IS TRUE AND P.stock > 0")
  Iterable<Platillo> listarPlatillosRecomendados();

  @Query("SELECT P FROM Platillo P WHERE P.categoria.id=:idC AND P.stock > 0 AND P.vigencia IS TRUE")
  Iterable<Platillo> listarPlatillosPorCategoria(int idC);

  @Modifying
  @Query("UPDATE Platillo P SET P.stock=P.stock-:cant WHERE P.id=:id")
  void descontarStock(int cant, int id);

  @Modifying
  @Query("UPDATE Platillo P SET P.stock=P.stock+:cant WHERE P.id=:id")
  void aumentarStock(int cant, int id);

}
