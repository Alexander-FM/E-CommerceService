package com.alexandertutoriales.service.ecommerce.controller.socket;

import com.alexandertutoriales.service.ecommerce.entity.dto.GenerarPedidoDTO;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PedidoSocketController {
    @SendTo("/topic/pedido-notification")
    public GenerarPedidoDTO notification(GenerarPedidoDTO response) {
        return response;
    }
}
