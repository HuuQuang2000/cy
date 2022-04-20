package com.example.ktlt.Repository;


import com.example.ktlt.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<UserEntity,Long> {
}
