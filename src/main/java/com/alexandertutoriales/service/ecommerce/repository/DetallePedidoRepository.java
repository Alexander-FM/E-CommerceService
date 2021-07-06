package com.alexandertutoriales.service.ecommerce.repository;

import com.alexandertutoriales.service.ecommerce.entity.DetallePedido;
import com.alexandertutoriales.service.ecommerce.entity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Integer> {
    @Query("SELECT DP FROM DetallePedido DP WHERE DP.pedido.id=:idP")
    Iterable<DetallePedido> findByPedido(int idP);
}
