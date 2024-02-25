package com.alexandertutoriales.service.ecommerce.publisher.pedidos;

import com.alexandertutoriales.service.ecommerce.entity.dto.GenerarPedidoDTO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit //Es necesario para los publicadores.
public class PublisherPedidos {
  /**
   * The rabbit template.
   */
  private final RabbitTemplate rabbitTemplate;

  /**
   * The Queue.
   */
  private final Queue queue;

  public PublisherPedidos(RabbitTemplate rabbitTemplate, Queue queue) {
    this.rabbitTemplate = rabbitTemplate;
    this.queue = queue;
  }

  /**
   * Envía un mensaje a la cola. Este método se puede utilizar en cualquier clase donde queramos
   * enviar un mensaje a dicha cola.
   *
   * @param generarPedidoDTO the generar pedido dto.
   */
  public void send(final GenerarPedidoDTO generarPedidoDTO) {
    rabbitTemplate.convertAndSend(queue.getName(), generarPedidoDTO);
  }
}
