package com.gkfcsolution.websocketmessaging.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2025 at 16:58
 * File: null.java
 * Project: web-socket-messaging
 *
 * @author Frank GUEKENG
 * @date 07/11/2025
 * @time 16:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageModel {
    private String message;
    private String formLogin;
}
