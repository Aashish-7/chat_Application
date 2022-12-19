package com.websocket.chat.storage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_storage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String userName;

}

//
//    private static UserStorage instance;
//    private Set<String> users;
//
//    private UserStorage() {
//        users = new HashSet<>();
//    }
//
//    public static synchronized UserStorage getInstance() {
//        if (instance == null) {
//            instance = new UserStorage();
//        }
//        return instance;
//    }
//
//    public Set<String> getUsers() {
//        return users;
//    }
//
//    public void setUser(String userName) throws Exception {
//        if (users.contains(userName)) {
//            throw new Exception("User already exists with userName: " + userName);
//        }
//        users.add(userName);
//    }