package com.example.ktlt.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "receiptNote")
public class ReceiptNoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "name")
    private String name;
    @OneToMany(mappedBy = "receiptNote",cascade = CascadeType.PERSIST)
    private List<ProductEntity> productEntityList;
}
