package ru.job4j.collection;

import java.util.Comparator;
public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] strOne = o1.split("/");
        String[] strTwo = o2.split("/");
        int rsl = strOne[0].compareTo(strTwo[0]);
        if (rsl == 0) {
            rsl = o1.compareTo(o2);
        } else {
            rsl = o2.compareTo(o1);
        }
        return rsl;
    }
}