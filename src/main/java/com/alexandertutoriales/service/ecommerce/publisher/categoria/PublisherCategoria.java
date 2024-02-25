package com.alexandertutoriales.service.ecommerce.publisher.categoria;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit //Es necesario para los publicadores.
public class PublisherCategoria {
  /**
   * The rabbit template.
   */
  private final RabbitTemplate rabbitTemplate;

  /**
   * The nttdata queue.
   */
  private final Queue nttdataQueue;

  public PublisherCategoria(RabbitTemplate rabbitTemplate, Queue nttdataQueue) {
    this.rabbitTemplate = rabbitTemplate;
    this.nttdataQueue = nttdataQueue;
  }

  /**
   * Envía un mensaje a la cola. Este método se puede utilizar en cualquier clase donde queramos
   * enviar un mensaje a dicha cola.
   *
   * @param message the message.
   */
  public void sendMessageNttDataQueue(final String message) {
    rabbitTemplate.convertAndSend(nttdataQueue.getName(), message);
  }
}
