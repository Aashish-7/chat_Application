package com.websocket.chat.service;

import com.websocket.chat.dao.UserStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupsService {

    UserStorageRepository userStorageRepository;

    @Autowired
    public GroupsService(UserStorageRepository userStorageRepository) {
        this.userStorageRepository = userStorageRepository;
    }

    public String createGroup(){
        userStorageRepository.findAll();
        return "joining group";
    }
}
