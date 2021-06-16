package ru.job4j.collection;

import java.util.Comparator;
public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] strOne = o1.split("/");
        String[] strTwo = o2.split("/");
        int rsl = strTwo[0].compareTo(strOne[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}