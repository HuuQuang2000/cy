package com.example.ktlt.Service;

import com.example.ktlt.Entity.ReceiptNoteEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public class ReceipNoteRervice implements IBaseService<ReceiptNoteEntity ,Long>{
    @Override
    public List<ReceiptNoteEntity> getAll() {
        return null;
    }

    @Override
    public Boolean saveOrUpdate(ReceiptNoteEntity receiptNoteEntity) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public ReceiptNoteEntity findById(Long id) {
        return null;
    }

    @Override
    public Page<ReceiptNoteEntity> findByPage(int pageIndex, int pageSize) {
        return null;
    }
}
