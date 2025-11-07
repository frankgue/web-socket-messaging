package com.gkfcsolution.websocketmessaging.controller;

import com.gkfcsolution.websocketmessaging.model.MessageModel;
import com.gkfcsolution.websocketmessaging.storage.UserStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2025 at 17:06
 * File: null.java
 * Project: web-socket-messaging
 *
 * @author Frank GUEKENG
 * @date 07/11/2025
 * @time 17:06
 */
@RestController
@Slf4j
@CrossOrigin
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageModel message){
        log.info("Hanling send message: {} to: {}", message, to);
        System.out.println("Handling send message: " + message + " to: " + to);
        boolean isExists = UserStorage.getInstance().getUsers().contains(to);
        if (isExists){
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }
}
