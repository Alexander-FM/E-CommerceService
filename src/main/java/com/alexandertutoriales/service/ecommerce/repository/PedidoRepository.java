package com.alexandertutoriales.service.ecommerce.repository;

import com.alexandertutoriales.service.ecommerce.entity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

    @Query("SELECT P FROM Pedido P WHERE P.cliente.id=:idCli")
    Iterable<Pedido> devolverMisCompras(int idCli);
}
