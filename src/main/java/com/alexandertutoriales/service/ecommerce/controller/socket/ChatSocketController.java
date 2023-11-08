package com.alexandertutoriales.service.ecommerce.controller.socket;

import com.alexandertutoriales.service.ecommerce.utils.Chat;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChatSocketController {

  @MessageMapping("/sendMessage")
  @SendTo("/topic/chat")
  public Chat sendMessage(@RequestBody Chat chat) {
    return chat;
  }
}
