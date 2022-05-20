package com.example.demo.service.stringgeneration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


class DataResource{

    public List<String> getList(DataType type) {
        switch (type) {
            case MIDDLENAME:
                return getListOfPatronymics();
            case NAME:
                return getListOfNames();
            case SURNAME:
                return getListOfSurnames();
            default:
                return new ArrayList<>();

        }
    }


    private List<String> getListOfSurnames(){
        List<String> surnames = new ArrayList<String>();
        // Путь к директории:
        String path="src\\main\\resources\\";
        // Текстовая переменная для записи считываемых из файла строк:
        String str;
        try{
            // Объект буферизированного потока ввода:
            BufferedReader input=new BufferedReader(new FileReader(path+"Surnames.txt"));

            // Считывание строк из одного файла и запись в другой файл:
            while((str=input.readLine())!=null){
                surnames.add(str);
            }
            // Поток закрывается:
            input.close();
            return(surnames);
        }

        // Обработка исключений:

        catch(FileNotFoundException e){
            System.out.println("Файл не найден: "+e);
            return(surnames);
        }

        catch(IOException e){
            System.out.println("Ошибка доступа к файлу: "+e);
            return(surnames);
        }
    }

    private List<String> getListOfNames(){
        List<String> names = new ArrayList<String>();
        // Путь к директории:
        String path="src\\main\\resources\\";
        // Текстовая переменная для записи считываемых из файла строк:
        String str;
        try{
            // Объект буферизированного потока ввода:
            BufferedReader input=new BufferedReader(new FileReader(path+"Names.txt"));
            // Считывание строк из одного файла и запись в другой файл:
            while((str=input.readLine())!=null){
                names.add(str);
            }
            // Поток закрывается:
            input.close();
            return(names);
        }

        // Обработка исключений:
        catch(FileNotFoundException e){
            System.out.println("Файл не найден: "+e);
            return(names);
        }

        catch(IOException e){
            System.out.println("Ошибка доступа к файлу: "+e);
            return(names);
        }
    }

    private List<String> getListOfPatronymics(){
        List<String> patronymics = new ArrayList<String>();
        // Путь к директории:
        String path="src\\main\\resources\\";
        // Текстовая переменная для записи считываемых из файла строк:
        String str;
        try{
            // Объект буферизированного потока ввода:
            BufferedReader input=new BufferedReader(new FileReader(path+"Patronymics.txt"));
            // Считывание строк из одного файла и запись в другой файл:
            while((str=input.readLine())!=null){
                patronymics.add(str);
            }
            // Поток закрывается:
            input.close();
            return(patronymics);
        }

        // Обработка исключений:
        catch(FileNotFoundException e){
            System.out.println("Файл не найден: "+e);
            return(patronymics);
        }

        catch(IOException e){
            System.out.println("Ошибка доступа к файлу: "+e);
            return(patronymics);
        }
    }
}
