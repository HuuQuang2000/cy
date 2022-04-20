package com.example.demo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface SubjectRepository extends ReactiveCrudRepository<Subject ,Long> {
    @Query(" select s.id , s.name , s.address, su.id as subject_id, su.name as subject_name from student s inner join subject su on s.idSubject = su.id")
    Flux<StudentDTO> findByPage(Pageable pageable);
}
