package com.example.ktlt.Service;

import com.example.ktlt.Entity.UserEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public class UserService implements IBaseService<UserEntity ,Long>{
    @Override
    public List<UserEntity> getAll() {
        return null;
    }

    @Override
    public Boolean saveOrUpdate(UserEntity userEntity) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public UserEntity findById(Long id) {
        return null;
    }

    @Override
    public Page<UserEntity> findByPage(int pageIndex, int pageSize) {
        return null;
    }
}
