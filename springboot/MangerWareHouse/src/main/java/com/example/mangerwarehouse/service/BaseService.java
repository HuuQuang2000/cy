package com.example.mangerwarehouse.service;

import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseService<T,V> {
    List<T> getAll();
    Boolean delete(V id);
    T findByid(V id);
    T update(T t);
    Boolean save(T t);
    Page<T> findByPage(int pageIndex, int pageSize);
}
