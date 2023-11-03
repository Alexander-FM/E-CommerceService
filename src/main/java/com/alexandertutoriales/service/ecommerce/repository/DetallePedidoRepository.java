package com.alexandertutoriales.service.ecommerce.repository;

import com.alexandertutoriales.service.ecommerce.entity.DetallePedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Integer> {

  @Query("SELECT DP FROM DetallePedido DP WHERE DP.pedido.id=:idP")
  Iterable<DetallePedido> findByPedido(int idP);

  //Consultar el total de compras
  @Query(value = "SELECT SUM(dp.cantidad * dp.precio) AS \"Total\" FROM detalle_pedido dp JOIN pedido p\n" +
      "ON P.id = dp.pedido_id\n" +
      "WHERE p.cliente_id =:idCli AND p.anular_pedido = 0", nativeQuery = true)
  Double totalByIdCustomer(int idCli);
}
