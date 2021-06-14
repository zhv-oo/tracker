package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] srcOne = left.split("\\. ");
        String[] srcTwo = right.split("\\. ");
        return Integer.compare(Integer.parseInt(srcOne[0]), Integer.parseInt(srcTwo[0]));
    }
}