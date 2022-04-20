package com.example.ktlt.Repository;


import com.example.ktlt.Entity.NumberOfCodeEntity;
import com.example.ktlt.Entity.ReceiptNoteEntity;
import org.springframework.data.repository.CrudRepository;

public interface IReceipNoteRepository extends CrudRepository<ReceiptNoteEntity,Long> {

}
