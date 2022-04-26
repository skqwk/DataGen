package com.example.demo.service.stringgeneration;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для проверки вместо теста
 *
 * @author Ivan Cherepanov
 * */
public class Test {
    public static void main(String[] args) {

        /**
         * Пример, что будет в массив, при выборе пользователем полей для генерации
         * */
        List<DataType> strings = new ArrayList<>();
        strings.add(DataType.NAME);
        strings.add(DataType.MIDDLENAME);
        strings.add(DataType.SURNAME);

        /**
         * Пример запуска
         * */
        DataResource dataResource = new DataResource();
        StringGeneration stringGeneration = new StringGeneration(dataResource);
        System.out.println(stringGeneration.getResult(strings, 5));
    }
}
