package com.example.demo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface StudentRepository extends ReactiveCrudRepository<Student,Long> {
    @Query(" select s.id , s.name , s.address, su.id as subject_id, su.name as subject_name from student s inner join subject su on s.subject_id = su.id")
    Flux<StudentDTO> getAll();

    @Query(" select s.id , s.name , s.address, su.id as subject_id, su.name as subject_name from student s inner join subject su on s.subject_id = su.id")
    Flux<StudentDTO> findByPage1(Pageable pageable);

    Flux<Student> findAllBy(Pageable pageable);

    @Query(" select s.id , s.name , s.address where id= ?1")
    List<Student> findAllById(List<Long> id);
}
