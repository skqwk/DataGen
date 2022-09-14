package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConcurrentService {

    List<Integer> nums;

    public synchronized int findMax(String list) {
        nums = Arrays.stream(list.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = nums.size();
        int max = Math.max(
                findMax(nums.subList(0, n / 2)),
                findMax(nums.subList(n / 2 + 1, n)));
        System.out.println(Thread.currentThread().getName() + " find " + max);
        return max;
    }

    public int findMax(List<Integer> list) {
        System.out.println(Thread.currentThread().getName());
        int max = Integer.MIN_VALUE;
        for (int num : list) {
            max = Math.max(num, max);
        }
        return max;
    }

    public List<Integer> getNums() {
        return this.nums;
    }


}
