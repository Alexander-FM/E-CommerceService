package com.alexandertutoriales.service.ecommerce.repository;

import java.util.Optional;

import com.alexandertutoriales.service.ecommerce.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

  //Método para iniciar sesión desde la app de E-commerce.
  @Query("SELECT U FROM Usuario U WHERE U.email=:correo AND U.clave=:password")
  Optional<Usuario> login(String correo, String password);

  @Query("SELECT U FROM Usuario U WHERE U.cliente.id=:idCliente")
  Optional<Usuario> findUsuarioByClienteId(int idCliente);
}
