package com.example.ktlt.Service;

import com.example.ktlt.Entity.NumberOfCodeEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public class NumberOfCodeService implements IBaseService<NumberOfCodeEntity,Long>{
    @Override
    public List<NumberOfCodeEntity> getAll() {
        return null;
    }

    @Override
    public Boolean saveOrUpdate(NumberOfCodeEntity numberOfCodeEntity) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public NumberOfCodeEntity findById(Long id) {
        return null;
    }

    @Override
    public Page<NumberOfCodeEntity> findByPage(int pageIndex, int pageSize) {
        return null;
    }
}
