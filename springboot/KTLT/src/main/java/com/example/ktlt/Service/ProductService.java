package com.example.ktlt.Service;

import com.example.ktlt.Entity.ProductEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public class ProductService implements IBaseService<ProductEntity , Long>{
    @Override
    public List<ProductEntity> getAll() {
        return null;
    }

    @Override
    public Boolean saveOrUpdate(ProductEntity productEntity) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public ProductEntity findById(Long id) {
        return null;
    }

    @Override
    public Page<ProductEntity> findByPage(int pageIndex, int pageSize) {
        return null;
    }
}
