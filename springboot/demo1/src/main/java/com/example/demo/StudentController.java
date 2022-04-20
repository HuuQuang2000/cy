package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @GetMapping("/index")
    public Flux<?> getAllStudent(){
        return studentRepository.getAll();
    }
    @GetMapping("/index/{id}")
    public Mono<Student> findById(@PathVariable("id") Long id){
        return studentRepository.findById(id);
    }
    @DeleteMapping("/index/{id}")
    public Mono deleteById(@PathVariable("id") Long id){
        return  studentRepository.deleteById(id);
    }

    @PostMapping("/index/add")
    public Mono save(@RequestBody Student student){
        return  studentRepository.save(student);
    }

    @PostMapping("/index/update")
    public Mono update(@RequestBody  Student student){
        return studentRepository.findById(student.getId())
                .flatMap(p -> {
                    p.setName(student.getName());
                    p.setAddress(student.getAddress());
                    p.setSubject_id(student.getSubject_id());
                    return studentRepository.save(p);
                });
    }

    @GetMapping(value = "/getAllCodittion")
    public Response<Flux<Student>> getAllTC(Pageable pageable){
        Flux<Student> flux = studentRepository.findAllBy(pageable);
        Long totalItems = studentRepository.count().block();
        return Response.ofSucceeded(flux.toStream().collect(Collectors.toList()), pageable,totalItems);
    }

}
