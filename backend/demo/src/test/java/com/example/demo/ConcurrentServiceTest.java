package com.example.demo;

public class ConcurrentServiceTest {
    public static void main(String[] args) {
        ConcurrentService service = new ConcurrentService();

        String s1 = "1 2 3 4 5 6 7 8 9";
        String s2 = "90 1 2 3 4 5 6 7 8";

        Runnable r1 = () -> service.findMax(s1);
        Runnable r2 = () -> service.findMax(s2);
        Runnable r3 = () -> System.out.println(Thread.currentThread().getName() + " see " + service.getNums());

        new Thread(r1).start();
        new Thread(r3).start();
        new Thread(r2).start();

    }
}
