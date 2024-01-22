package com.alexandertutoriales.service.ecommerce.repository;

import com.alexandertutoriales.service.ecommerce.entity.Dispositivo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DispositivoRepository extends CrudRepository<Dispositivo, Integer> {
  @Query("SELECT D FROM Dispositivo D WHERE D.deviceId = :deviceId")
  Dispositivo existDeviceId(String deviceId);
}
