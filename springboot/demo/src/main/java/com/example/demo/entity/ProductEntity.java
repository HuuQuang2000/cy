package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "product")
public class ProductEntity extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;
    private int total;
   @ManyToOne(cascade = CascadeType.PERSIST)
    private UserEntity userEntity;
}
