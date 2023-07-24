package com.alexandertutoriales.service.ecommerce.repository;

import com.alexandertutoriales.service.ecommerce.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    //Método para iniciar sesión desde la app de angular.
    @Query("SELECT U FROM User U WHERE U.username=:username AND U.password=:password")
    Optional<User> loginUser(String username, String password);
}
