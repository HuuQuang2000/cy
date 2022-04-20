package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String username ;
    private String password;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "userEntity")
    private List<ProductEntity> productEntityList;
}
