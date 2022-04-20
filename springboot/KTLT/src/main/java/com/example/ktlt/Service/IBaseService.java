package com.example.ktlt.Service;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IBaseService <T,V>{
    List<T> getAll();
    Boolean saveOrUpdate(T t);
    Boolean deleteById(V id);
    T findById(V id);
    Page<T> findByPage(int pageIndex , int pageSize);
}
