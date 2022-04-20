package com.example.mangerwarehouse.entity;

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
@Table(name="product")
public class ProductEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ten_sanpham")
    private String name;
    @Column(name="gia")
    private int price;
    @Column(name= "soluong")
    private int total;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CategoryEntity category;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private NumberOfCode numberOfCode;
}
