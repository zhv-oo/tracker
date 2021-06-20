package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("1. Task", "2. Task", "11. Task");
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("String 1: " + left + " String 2: " + right);
            return right.length() - left.length();
        };
        numbers.sort(cmpDescSize);
        System.out.println(numbers);
    }
}