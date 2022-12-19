package com.websocket.chat.controller;

import com.websocket.chat.dao.UserStorageRepository;
import com.websocket.chat.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class UsersController {

    UserStorageRepository userStorageRepository;

    @Autowired
    public UsersController(UserStorageRepository userStorageRepository) {
        this.userStorageRepository = userStorageRepository;
    }

    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName) {
        System.out.println("handling register user request: " + userName);
        fetchAll();
        try {
            UserStorage userStorage = new UserStorage();
            userStorage.setUserName(userName);
            userStorageRepository.save(userStorage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Set<String> fetchAll() {
        return userStorageRepository.findAll().stream().map(UserStorage::getUserName).collect(Collectors.toSet());
    }

}
