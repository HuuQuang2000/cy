package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/subject")
@RestController
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/getAll")
    public Flux<Subject> findAll(){
        return subjectRepository.findAll();
    }

    @GetMapping(value = "/findById/{id}")
    public Mono<Subject> findById(@PathVariable Long id){
        return subjectRepository.findById(id);
    }
    @GetMapping(value = "/deleteById/{id}")
    public Mono deleteById(@PathVariable Long id){
        return subjectRepository.deleteById(id);
    }
    @PostMapping(value = "/add")
    public Mono save(@RequestBody SubjectDTO subjectDTO){
        String subject_name = subjectDTO.getName();
        Subject subject = new Subject();
        subject.setName(subject_name);
        Mono<Subject> stu = subjectRepository.save(subject);
        return stu;
    }

    @PostMapping("/update")
    public Mono update(@RequestBody SubjectDTO subjectDTO){
        return subjectRepository.findById(subjectDTO.getId())
                .flatMap(p -> {
                    p.setName(subjectDTO.getName());
                    return subjectRepository.save(p);
                });
    }

//    @GetMapping("/page/{page_index}/{page_size}")
//    public Response<Flux<Subject>> getAllTC(@PathVariable("page_index") int pageIndex,@PathVariable("page_size") int pageSize){
//        Pageable pageable = PageRequest.of(pageIndex,pageSize);
//        Flux<StudentDTO> flux = subjectRepository.findByPage(pageable);
//        Long totalItems = subjectRepository.count().block();
//        return Response.ofSucceeded(flux.toStream().collect(Collectors.toList()), pageable,totalItems);
//    }
}
