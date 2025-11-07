package com.gkfcsolution.websocketmessaging.controller;

import com.gkfcsolution.websocketmessaging.storage.UserStorage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created on 2025 at 17:14
 * File: null.java
 * Project: web-socket-messaging
 *
 * @author Frank GUEKENG
 * @date 07/11/2025
 * @time 17:14
 */
@RestController
@Slf4j
@CrossOrigin
public class UsersController {

    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName){
        log.info("Handling register user request: {}", userName);
        try {
            UserStorage.getInstance().setUsers(userName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Set<String> fetchAll(){
        return UserStorage.getInstance().getUsers();
    }
}
