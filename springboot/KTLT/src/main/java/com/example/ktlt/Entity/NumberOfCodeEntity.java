package com.example.ktlt.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="numberOfCode")
public class NumberOfCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "name")
    private String name;
    @OneToMany(mappedBy = "numberOfCode",cascade = CascadeType.PERSIST)
    private List<ProductEntity> productEntityList;

}

