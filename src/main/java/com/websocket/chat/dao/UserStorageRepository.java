package com.websocket.chat.dao;

import com.websocket.chat.storage.UserStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStorageRepository extends JpaRepository<UserStorage, Long> {
    UserStorage findByUserName(String userName);

    boolean existsByUserName(String userName);

}