package com.example.ktlt.Entity;


import com.example.ktlt.Utils.Util;
import jdk.jfr.internal.Utils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class BaseEntity {
    private String userCreate;
    private String userUpdate;
    private LocalDateTime starAt;
    private LocalDateTime updateAt;

    @PrePersist
    public void prePresist(){
        this.userCreate = Util.username;
        this.starAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        this.userCreate = Util.username;
        this.starAt = LocalDateTime.now();
    }
}
