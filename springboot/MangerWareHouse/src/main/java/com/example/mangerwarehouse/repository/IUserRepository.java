package com.example.mangerwarehouse.repository;

import com.example.mangerwarehouse.DTO.UserDTO;
import com.example.mangerwarehouse.Modal.UserModal;
import com.example.mangerwarehouse.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Long> {
    @Query("select new com.example.mangerwarehouse.Modal.UserModal(u) from UserEntity u ")
    List<UserModal> getAll();
    UserModal findByUsernameAndPassword(String username , String password);

    @Query("select new com.example.mangerwarehouse.Modal.UserModal(u) from UserEntity u ")
    Page<UserModal> findByPage(int pageIndex , int pageSize);
}
