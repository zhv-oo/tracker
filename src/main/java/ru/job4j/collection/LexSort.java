package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.compare(getNumber(left), getNumber(right));
    }

    private int getNumber(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (line.charAt(i) != '.') {
            stringBuilder.append(line.charAt(i));
            i++;
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}