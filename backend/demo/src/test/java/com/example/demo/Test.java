package com.example.demo;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.empty;

public class Test {

    public void boo() {
        synchronized (this) {
            int i = 5;
        }
    }
    public synchronized void foo() {
        int i = 5;
    }


    public static void main(String[] args) {
        Set<Integer> set =
        concat(
                concat(
                        of(1, 2, 3, 4),
                        of(5, 6, 7, 8)),
                        empty()
        )
                .collect(toSet());

    }
}
