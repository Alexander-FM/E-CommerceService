package com.alexandertutoriales.service.ecommerce.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {

  /**
   * The rabbit template
   */
  private final RabbitTemplate rabbitTemplate;

  /**
   * The Queue
   */
  private final Queue queue;

  public Publisher(RabbitTemplate rabbitTemplate, Queue queue) {
    this.rabbitTemplate = rabbitTemplate;
    this.queue = queue;
  }

  /**
   * Envía un mensaje a la cola. Este método se puede utilizar en cualquier clase donde queramos
   * enviar un mensaje a dicha cola.
   * @param object the object.
   */
  public void send(final Object object) {
    rabbitTemplate.convertAndSend(queue.getName(), object);
  }
}
