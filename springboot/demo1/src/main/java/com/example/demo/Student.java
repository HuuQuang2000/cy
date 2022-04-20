package com.example.demo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("student")
public class Student {
    @Id
    private Long id;
    private String name;
    private String address;
    private Long subject_id;
}
