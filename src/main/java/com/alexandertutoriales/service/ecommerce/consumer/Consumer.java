package com.alexandertutoriales.service.ecommerce.consumer;

import com.alexandertutoriales.service.ecommerce.entity.dto.GenerarPedidoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
  /**
   * Permite pasar una coleccion de colas que son todas aquellas colas que nuestro consumidor estará escuchando en RabbitMQ. De momento solo
   * tenemos una cola en nuestro application.propiertes.
   *
   * @param generarPedidoDTO el generar pedido dto.
   */
  @RabbitListener(queues = {"${ecommerce.queue.name}"})
  public void receive(@Payload GenerarPedidoDTO generarPedidoDTO) {
    log.info("Pedido ID '{}' : ", generarPedidoDTO.getPedido().getId() + " Cliente ID '{}' : "
        + generarPedidoDTO.getPedido().getCliente().getNombreCompletoCliente());
    makeSlow();
  }

  /**
   * Ejecutar cada 1.5 minutos.
   */
  private void makeSlow() {
    try {
      Thread.sleep(15000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
