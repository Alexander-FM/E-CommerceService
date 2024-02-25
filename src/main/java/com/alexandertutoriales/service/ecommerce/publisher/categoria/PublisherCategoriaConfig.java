package com.alexandertutoriales.service.ecommerce.publisher.categoria;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class PublisherCategoriaConfig {
  /**
   * Nombre de la nueva cola a la cual apuntamos en el application.propiertes
   */
  @Value("${nttdata.queue.name}")
  private String nttdataQueue;

  /**
   * Configuración de la cola que será utilizada para publicar mensajes.
   *
   * @return Objeto Queue que representa la cola configurada.
   */
  @Bean
  public Queue nttdataQueue() {
    return new Queue(nttdataQueue, true);
  }
}
