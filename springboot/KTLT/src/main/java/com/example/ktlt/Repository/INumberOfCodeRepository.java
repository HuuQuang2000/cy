package com.example.ktlt.Repository;


import com.example.ktlt.Entity.CategoryEntity;
import com.example.ktlt.Entity.NumberOfCodeEntity;
import org.springframework.data.repository.CrudRepository;

public interface INumberOfCodeRepository extends CrudRepository<NumberOfCodeEntity,Long> {

}
