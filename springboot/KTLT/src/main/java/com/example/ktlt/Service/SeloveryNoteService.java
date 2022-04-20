package com.example.ktlt.Service;

import com.example.ktlt.Entity.ProductEntity;
import com.example.ktlt.Entity.SeliveryNoteEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public class SeloveryNoteService implements IBaseService<SeliveryNoteEntity , Long>{


    @Override
    public List<SeliveryNoteEntity> getAll() {
        return null;
    }

    @Override
    public Boolean saveOrUpdate(SeliveryNoteEntity seliveryNoteEntity) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public SeliveryNoteEntity findById(Long id) {
        return null;
    }

    @Override
    public Page<SeliveryNoteEntity> findByPage(int pageIndex, int pageSize) {
        return null;
    }
}
