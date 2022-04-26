package com.example.demo.service.stringGeneration;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Временный вспомогательный класс для генерации
 * */
public class DataResource {
    private static final String NAMEFILE = "backend/demo/src/main/resources/textFile/name.txt";
    private static final String MIDDLENAMEFILE = "backend/demo/src/main/resources/textFile/middleName.txt";
    private static final String SURNAMEFILE = "backend/demo/src/main/resources/textFile/surname.txt";

    public List<String> getList(String type){
        String filename;
        switch (type){
            case "name":
                filename = NAMEFILE;
                break;
            case "middleName":
                filename = MIDDLENAMEFILE;
                break;
            case "surname":
                filename = SURNAMEFILE;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }

        List<String> result = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            while (br.ready()) {
                result.add(br.readLine());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return result;
    }
}
