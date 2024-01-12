package com.alexandertutoriales.service.ecommerce.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfig {

  /**
   * Nombre de la cola a la cual apuntamos en el application.propiertes
   */
  @Value("${ecommerce.queue.name}")
  private String message;

  @Bean
  public Queue queue() {
    return new Queue(message, true);
  }
}
