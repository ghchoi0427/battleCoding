package com.dku.dandev.controller;

import com.dku.dandev.domain.ChatMessage;
import com.dku.dandev.domain.MatchRequestMessage;
import com.dku.dandev.domain.SystemMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat.sendRequest")
    @SendTo("/topic/public")
    public MatchRequestMessage sendRequestMessage(@Payload MatchRequestMessage message) {
        return message;
    }

    @MessageMapping("/chat.sendData")
    @SendTo("/topic/public")
    public SystemMessage sendSystemMessage(@Payload SystemMessage message) {
        return message;
    }

}
