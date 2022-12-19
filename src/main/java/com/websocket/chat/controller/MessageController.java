package com.websocket.chat.controller;

import com.websocket.chat.dao.UserStorageRepository;
import com.websocket.chat.model.MessageModel;
import com.websocket.chat.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    UserStorageRepository userStorageRepository;

    @Autowired
    public MessageController(SimpMessagingTemplate simpMessagingTemplate, UserStorageRepository userStorageRepository) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.userStorageRepository = userStorageRepository;
    }

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageModel message) {
        System.out.println("handling send message: " + message + " to: " + to);
        boolean isExists = userStorageRepository.existsByUserName(to);
        if (isExists) {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }

//    @MessageMapping("/chat/{to}")
//    @SendTo("/topic/messages/{userName}")
//
//    public void setSimpMessagingTemplate(){
//        setSimpMessagingTemplate();
//    }

}
