package com.alexandertutoriales.service.ecommerce.controller;

import java.net.MalformedURLException;

import com.alexandertutoriales.service.ecommerce.entity.Dispositivo;
import com.alexandertutoriales.service.ecommerce.service.DispositivoService;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import com.alexandertutoriales.service.ecommerce.utils.SendNotification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/dispositivo")
public class DispositivoController {

  private final DispositivoService service;

  public DispositivoController(DispositivoService service) {
    this.service = service;
  }

  //GUARDAR DISPOSITIVO
  @PostMapping("/saveDevice")
  public GenericResponse registerDevice(@RequestBody Dispositivo dispositivo) {
    return this.service.registerDevice(dispositivo);
  }

  @PostMapping("/sendNotification/{deviceId}")
  public GenericResponse sendNotification(@PathVariable() int deviceId, @RequestBody SendNotification notification)
      throws MalformedURLException {
    return this.service.sendNotification(notification, deviceId);
  }

}
