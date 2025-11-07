package com.gkfcsolution.websocketmessaging.storage;

import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2025 at 17:01
 * File: null.java
 * Project: web-socket-messaging
 *
 * @author Frank GUEKENG
 * @date 07/11/2025
 * @time 17:01
 */
@Getter
public class UserStorage {
    private static UserStorage instance;
    private Set<String> users;

    private UserStorage(){
        users = new HashSet<>();
    }

    public static synchronized UserStorage getInstance(){
        if (instance == null)
            instance = new UserStorage();
        return instance;
    }

    public void setUsers(String userName) throws Exception {
        if (users.contains(userName)){
            throw new Exception("user already exists with userName: " + userName);
        }
        users.add(userName);
    }
}
