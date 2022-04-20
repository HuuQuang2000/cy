package com.example.mangerwarehouse.entity;

import com.example.mangerwarehouse.utils.util;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

public class BaseEntity {
    private LocalDateTime startAt;
    private LocalDateTime updateAt;
    private String userCreate;
    private String userUpdate;

    @PrePersist
    public void prePresist(HttpSession session){
        UserEntity user = (UserEntity) session.getAttribute("user");
        this.userCreate = user.getUsername();
        this.startAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(HttpSession session){
        UserEntity user = (UserEntity) session.getAttribute("user");
        this.userUpdate = user.getUsername();
        this.updateAt = updateAt.now();
    }
}
