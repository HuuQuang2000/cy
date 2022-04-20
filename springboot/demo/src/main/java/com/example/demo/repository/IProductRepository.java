package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("select p from ProductEntity p where p.name like CONCAT('%',?1,'%')")
    Page<ProductEntity> findAllByfiledSearch(String filedSearch,Pageable pageable);
}
