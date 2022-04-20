package com.example.mangerwarehouse.DTO;

import com.example.mangerwarehouse.Modal.UserModal;
import com.example.mangerwarehouse.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.html.parser.Entity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private int type;

    private UserDTO(UserEntity user){

    }
}
