package com.example.demo.service.stringgeneration;

import java.util.*;

/**
 * Класс для генерации строковых данных
 *
 * @author Ivan Cherepanov
 */
public class StringGeneration {
    private DataResource dataResource;
    private Random randomGenerator = new Random();

    /**
     * Конструктор
     *
     * @param dataResource предоставляет массив данных, после будет заменен на ДАО или любую другую реализацию
     */
    public StringGeneration(DataResource dataResource) {
        this.dataResource = dataResource;
    }

    /**
     * Метод для возврата списка, считанного из файла
     *
     * @param inputParameters массив значений, для которых нужно сгенерировать списки
     * @param amountOfRecords число записей
     * @return рандомный словарь строк
     */
    public Map<DataType, List<String>> getResult(List<DataType> inputParameters, int amountOfRecords) {
        Map<DataType, List<String>> result = new HashMap<>();
        for (DataType inputString : inputParameters) {
            result.put(inputString, getListByParameter(dataResource.getList(inputString), amountOfRecords));
        }
        return result;
    }

    /**
     * Метод для возврата списка, считанного из файла
     *
     * @param oneList         массив значений определенного типа, из которого будет производиться рандомная выборка
     * @param amountOfRecords число записей
     * @return рандомный список значений согласно входным данным
     */
    private List<String> getListByParameter(List<String> oneList, int amountOfRecords) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < amountOfRecords; i++) {
            result.add(oneList.
                    get(randomGenerator.nextInt(oneList.size())));
        }
        return result;
    }
}
