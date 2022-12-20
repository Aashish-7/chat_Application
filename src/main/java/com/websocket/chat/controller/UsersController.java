package com.websocket.chat.controller;

import com.websocket.chat.dao.UserStorageRepository;
import com.websocket.chat.service.GroupsService;
import com.websocket.chat.storage.User;
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

    GroupsService groupsService;
    @Autowired
    public UsersController(UserStorageRepository userStorageRepository, GroupsService groupsService) {
        this.userStorageRepository = userStorageRepository;
        this.groupsService = groupsService;
    }

    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName) throws Exception {
        System.out.println("handling register user request: " + userName);
        try {
            fetchAll();
            User user = new User();
            if (userStorageRepository.existsByUserName(userName)){
                throw new Exception("user already exits");
            }
            user.setUserName(userName);
            userStorageRepository.save(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Set<String> fetchAll() {
        return userStorageRepository.findAll().stream().map(User::getUserName).collect(Collectors.toSet());
    }


    @GetMapping("/createGroup")
    public String createGroup() {
        return groupsService.createGroup();
    }

}
