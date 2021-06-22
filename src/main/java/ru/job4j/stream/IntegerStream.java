package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerStream {
    public static void main(String[] args) {
        List<Integer> srcList = List.of(new Integer[]{-2, 1, 0, 2, 5});
        List<Integer> rsl = srcList.stream().filter(
                tmp -> tmp > 0
        ).collect(Collectors.toList());
        rsl.forEach(System.out::println);
    }
}