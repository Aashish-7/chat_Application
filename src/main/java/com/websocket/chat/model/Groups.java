package com.websocket.chat.model;

import com.websocket.chat.storage.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;

    private String groupName;

    @ManyToMany
    private List<User> list;
}
