package com.example.demo.controller;


import com.example.demo.dto.Request;
import com.example.demo.service.numericservice.NumberType;
import com.example.demo.service.numericservice.NumericService;
import com.example.demo.service.stringgeneration.DataType;
import com.example.demo.service.stringgeneration.StringGeneration;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = {"http://localhost:3000", "https://mirea-datagen-front.herokuapp.com/"})
public class GenerateController {
    private final NumericService numericService;
    private final StringGeneration stringGeneration;

    public GenerateController(NumericService numericService,
                              StringGeneration stringGeneration) {
        this.numericService = numericService;
        this.stringGeneration = stringGeneration;
    }

    private final Set<String> dataTypes = Arrays.stream(DataType.values())
            .map(DataType::name)
            .collect(Collectors.toSet());


    private final Set<String> numberTypes = Arrays.stream(NumberType.values())
            .map(NumberType::name)
            .collect(Collectors.toSet());

    @PostMapping("/generate")
    public ResponseEntity<?> generate(@RequestBody Request request) {

        int amount = request.getAmount();
        List<Object> fields = request.getFields();
        Map<String, List<?>> nameFields = new HashMap<>();
        for (Object field : fields) {
            Map map = (HashMap) field;
            String name = map.get("name").toString();
            String type = map.get("type").toString();
            if (numberTypes.contains(type)) {
                Integer from = Integer.parseInt(map.get("from").toString());
                Integer to = Integer.parseInt(map.get("to").toString());
                List<Number> nums = numericService.getRandomArray(from, to, amount, NumberType.valueOf(type));
                nameFields.put(name, nums);
            } else if (dataTypes.contains(type)) {
                List<String> data = stringGeneration.getResult(DataType.valueOf(type), amount);
                nameFields.put(name, data);
            } else {
                throw new IllegalStateException(String.format("Тип не распознан - %s", type));
            }
        }

        List<Map<String, ?>> objects = new ArrayList<>();
        for (int i = 0; i < amount; ++i) {
            Map<String, Object> object = new HashMap<>();
            for (String name : nameFields.keySet()) {
                object.put(name, nameFields.get(name).get(i));
            }
            objects.add(object);
        }



        return ResponseEntity.ok()
                .body(objects);
    }

    @GetMapping("/status")
    public ResponseEntity<?> status() {
        return ResponseEntity.ok().body("Server is work");
    }

}
