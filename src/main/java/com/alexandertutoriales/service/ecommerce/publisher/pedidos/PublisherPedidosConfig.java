package com.alexandertutoriales.service.ecommerce.publisher.pedidos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class PublisherPedidosConfig {
  /**
   * The amqpAdmin.
   */
  private final AmqpAdmin amqpAdmin;

  /**
   * Nombre de la cola a la cual apuntamos en el application.propiertes
   */
  @Value("${ecommerce.queue.name}")
  private String message;

  public PublisherPedidosConfig(AmqpAdmin amqpAdmin) {
    this.amqpAdmin = amqpAdmin;
  }

  @Bean
  public Queue queue() {
    return new Queue(message, true);
  }

  /**
   * Primero verifica si cola existe y luego elimina todos los mensajes de la cola al iniciar la aplicación.
   *
   * @param rabbitTemplate the rabbit template.
   * @return boolean
   */
  @Bean
  public Boolean clearQueueOnStartup(RabbitTemplate rabbitTemplate) {
    if (amqpAdmin.getQueueProperties(message) != null) {
      while (true) {
        log.info("Se van a eliminar los mensajes de la cola: " + message);
        Object messages = rabbitTemplate.receiveAndConvert(message);
        if (messages == null) {
          log.info("La cola está vacía");
          break;
        }
      }
      log.info("Mensajes eliminados de la cola: " + message);
      return true;
    } else {
      log.warn("La cola " + message + " no existe. No se realizará ninguna operación.");
      return false;
    }
  }
}
