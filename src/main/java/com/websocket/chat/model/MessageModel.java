package com.websocket.chat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.messaging.handler.annotation.SendTo;

@Getter
@SendTo
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageModel {

    private String message;
    private String fromLogin;
}
