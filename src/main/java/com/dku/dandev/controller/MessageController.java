package com.dku.dandev.controller;

import com.dku.dandev.domain.MatchRequestMessage;
import com.dku.dandev.domain.SystemMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public MatchRequestMessage sendSystemMessage(@Payload MatchRequestMessage matchRequestMessage) {
        return matchRequestMessage;
    }

//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public SystemMessage addUser(@Payload SystemMessage systemMessage, SimpMessageHeaderAccessor headerAccessor) {
//        Long sender = systemMessage.getSender();
//        headerAccessor.getSessionAttributes().put("user")
//    }

    private final SimpMessageSendingOperations sendingOperations;

    public MessageController(SimpMessageSendingOperations sendingOperations) {
        this.sendingOperations = sendingOperations;
    }


    @MessageMapping("/chat/message")
    public void enter(SystemMessage message, String matchId, Long senderId) {
        if (message.getMessageType().equals(SystemMessage.MessageType.ENTER)) {
            message.setMatchId(matchId);
            message.setSender(senderId);
        }
        sendingOperations.convertAndSend("/topic/chat/" + message.getMatchId(), message);
    }

    @MessageMapping("/chat/sendMessage")
    public void enterRoom(@Payload SystemMessage message) {
        if (message.getMessageType().equals(SystemMessage.MessageType.ENTER)) {
            sendingOperations.convertAndSend("/topic/chat/" + message.getMatchId(), message);
        }
    }
}
