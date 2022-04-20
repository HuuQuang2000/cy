package com.example.mangerwarehouse.service;

import com.example.mangerwarehouse.DTO.UserDTO;
import com.example.mangerwarehouse.Modal.UserModal;
import com.example.mangerwarehouse.entity.UserEntity;
import com.example.mangerwarehouse.repository.IUserRepository;
import com.fasterxml.jackson.databind.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class UserService implements BaseService<UserModal , Long>{
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<UserModal> getAll() {
        List<UserModal> list = iUserRepository.getAll();
        return list;
    }
    @Override
    public Boolean delete(Long id) {
        try {
            iUserRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public UserModal findByid(Long id) {
        UserEntity userEntity = iUserRepository.findById(id).get();
        UserModal userModal = new UserModal(userEntity);
        return userModal;
    }

    @Override
    public UserModal update(UserModal userModal) {
        UserEntity userEntity = UserModal.toEntity(userModal);
        iUserRepository.save(userEntity);
        return new UserModal(userEntity);
    }

    @Override
    public Boolean save(UserModal userModal) {
        try {
            UserEntity userEntity = UserModal.toEntity(userModal);
            iUserRepository.save(userEntity);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Page<UserModal> findByPage(int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex,pageSize);
        Page<UserModal> pageEntity = iUserRepository.findByPage(pageIndex,pageSize);
        return pageEntity;
    }

    public boolean Login(UserModal userModal){
        try{
            UserModal isUser = iUserRepository.findByUsernameAndPassword(userModal.getUsername(), userModal.getPassword());
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
