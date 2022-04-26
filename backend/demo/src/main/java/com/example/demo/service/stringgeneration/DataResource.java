package com.example.demo.service.stringgeneration;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Временный вспомогательный класс для генерации
 *
 * @author Ivan Cherepanov
 * */
public class DataResource {
    private static final String NAMEFILE = "backend/demo/src/main/resources/textFile/name.txt";
    private static final String MIDDLENAMEFILE = "backend/demo/src/main/resources/textFile/middleName.txt";
    private static final String SURNAMEFILE = "backend/demo/src/main/resources/textFile/surname.txt";

    /**
     * Метод для возврата списка, считанного из файла
     *
     * @param type параметр-имя, массив значений которого нужно получить
     * @return считанный массив строк
     */
    public List<String> getList(DataType type){
        String filename;
        switch (type){
            case NAME:
                filename = NAMEFILE;
                break;
            case MIDDLENAME:
                filename = MIDDLENAMEFILE;
                break;
            case SURNAME:
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
