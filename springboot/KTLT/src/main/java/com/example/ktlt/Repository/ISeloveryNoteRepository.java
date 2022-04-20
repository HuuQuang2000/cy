package com.example.ktlt.Repository;


import com.example.ktlt.Entity.ReceiptNoteEntity;
import com.example.ktlt.Entity.SeliveryNoteEntity;
import org.springframework.data.repository.CrudRepository;

public interface ISeloveryNoteRepository extends CrudRepository<SeliveryNoteEntity,Long> {

}
