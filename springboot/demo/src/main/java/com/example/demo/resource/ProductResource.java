package com.example.demo.resource;

import com.example.demo.service.ProductDataFetcher;
import com.example.demo.service.UserDataFetcher;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductResource {
    @Autowired
    ProductDataFetcher productDataFetcher;

    @PostMapping()
    public ResponseEntity<Object> findByid(@RequestBody String query){
        ExecutionResult execute = productDataFetcher.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
