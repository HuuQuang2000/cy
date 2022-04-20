package com.example.ktlt.Service;

import com.example.ktlt.Entity.CategoryEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public class CategoryService implements IBaseService<CategoryEntity,Long>{
    @Override
    public List<CategoryEntity> getAll() {
        return null;
    }

    @Override
    public Boolean saveOrUpdate(CategoryEntity categoryEntity) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public CategoryEntity findById(Long id) {
        return null;
    }

    @Override
    public Page<CategoryEntity> findByPage(int pageIndex, int pageSize) {
        return null;
    }
}
