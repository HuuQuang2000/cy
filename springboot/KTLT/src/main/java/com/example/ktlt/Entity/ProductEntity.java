package com.example.ktlt.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="total")
    private int total;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CategoryEntity category;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private NumberOfCodeEntity numberOfCode;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ReceiptNoteEntity receiptNote;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private SeliveryNoteEntity seliveryNote;

}
