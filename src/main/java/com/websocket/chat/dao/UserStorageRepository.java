package com.websocket.chat.dao;

import com.websocket.chat.storage.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStorageRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    boolean existsByUserName(String userName);

}