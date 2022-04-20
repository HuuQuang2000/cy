package com.example.ktlt.Repository;


import com.example.ktlt.Entity.CategoryEntity;
import com.example.ktlt.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<CategoryEntity,Long> {
}
