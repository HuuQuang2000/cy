package com.example.demo.service;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseService<T> extends DataFetcher<T> {
    List<T> getAll(DataFetchingEnvironment dataFetchingEnvironment);
    Boolean delete(DataFetchingEnvironment environment);
    T findByid(DataFetchingEnvironment dataFetchingEnvironment);
    T update(DataFetchingEnvironment environment);
    Boolean save(DataFetchingEnvironment environment);
    Page<T> getAllPage(DataFetchingEnvironment dataFetchingEnvironment);
    Page<T> findPage(DataFetchingEnvironment dataFetchingEnvironment);
}
