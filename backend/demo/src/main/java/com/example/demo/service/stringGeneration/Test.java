package com.example.demo.service.stringGeneration;

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
        List<String> strings = new ArrayList<>();
        strings.add("name");
        strings.add("middleName");
        strings.add("surname");

        /**
         * Пример запуска
         * */
        DataResource dataResource = new DataResource();
        StringGeneration stringGeneration = new StringGeneration(dataResource);
        System.out.println(stringGeneration.getResult(strings, 5));
    }
}
