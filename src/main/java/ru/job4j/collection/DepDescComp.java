package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return !o1.substring(0, 2).equals(o2.substring(0, 2))
                ? o2.compareTo(o1) : o1.compareTo(o2);
    }
}