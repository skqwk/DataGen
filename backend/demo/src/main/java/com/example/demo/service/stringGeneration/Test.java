package com.example.demo.service.stringGeneration;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("name");
        strings.add("middleName");
        strings.add("surname");
        DataResource dataResource = new DataResource();
        StringGeneration stringGeneration = new StringGeneration(dataResource);
        System.out.println(stringGeneration.getResult(strings, 5));
    }
}
