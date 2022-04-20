package com.example.mangerwarehouse.Modal;

import com.example.mangerwarehouse.DTO.UserDTO;
import com.example.mangerwarehouse.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModal {
    private Long id;
    private String username;
    private String password;
    private int type;

    public UserModal(UserEntity user){
        UserModal.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .type(user.getType())
                .build();
    }

    public static UserModal toModel(UserDTO userDTO){
       return  UserModal.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .type(userDTO.getType())
                .build();
    }

    public static UserEntity toEntity(UserModal userModal){
        return  UserEntity.builder()
                .id(userModal.getId())
                .username(userModal.getUsername())
                .password(userModal.getPassword())
                .type(userModal.getType())
                .build();
    }
}
