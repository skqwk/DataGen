package com.example.demo.controller;


import com.example.demo.dto.Request;
import com.example.demo.service.numericservice.NumericService;
import com.example.demo.service.stringgeneration.StringGeneration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins="http://localhost:3000")
public class GenerateController {
    private final NumericService numericService;
    private final StringGeneration stringGeneration;

    public GenerateController(NumericService numericService,
                              StringGeneration stringGeneration) {
        this.numericService = numericService;
        this.stringGeneration = stringGeneration;
    }

    @PostMapping("/generate")
    public ResponseEntity<?> generate(@RequestBody Request request) {
        System.out.println(request);

        for (Object field : request.getFields()) {
            Map map = (HashMap) field;
            System.out.println(map);
        }
        return ResponseEntity.ok()
                .body(Map.of(
                        "key", "value"
                ));
    }

    @GetMapping("/something")
    public String getSomething() {
        return "Hello world!";
    }

    @GetMapping("/hello")
    public String getAnotherHelloWorld() {
        return "Hello world GENERATE!";
    }

}
