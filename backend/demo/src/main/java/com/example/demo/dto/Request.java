package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class Request {
    private String name;
    private Integer amount;
    private List<Object> fields;
}
