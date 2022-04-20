package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Persister;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
//    @Column(name = "create_at")
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String UserUpdate;
    private String UserCreate;
    @PrePersist
    public void Persitist(){
       this.createAt = LocalDateTime.now();
        this.UserCreate = "quang";
    }
    @PreUpdate
    public void prePersitist(){

        updateAt = LocalDateTime.now();
        this.UserUpdate = "quang";
    }

    public BaseEntity() {
    }

    public BaseEntity(LocalDateTime createAt, LocalDateTime updateAt, String userUpdate, String userCreate) {
        this.createAt = createAt;
        this.updateAt = updateAt;
        UserUpdate = userUpdate;
        UserCreate = userCreate;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getUserUpdate() {
        return UserUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        UserUpdate = userUpdate;
    }

    public String getUserCreate() {
        return UserCreate;
    }

    public void setUserCreate(String userCreate) {
        UserCreate = userCreate;
    }
}

