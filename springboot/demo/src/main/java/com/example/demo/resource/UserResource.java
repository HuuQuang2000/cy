package com.example.demo.resource;

import com.example.demo.service.UserDataFetcher;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserResource {
    @Autowired
    UserDataFetcher userDataFetcher;

    @PostMapping()
    public ResponseEntity<Object> findByid(@RequestBody String query){
        ExecutionResult execute = userDataFetcher.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
