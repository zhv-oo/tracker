package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] lineArr = line.split(" ");
        Set<String> inn = new HashSet<>(Arrays.asList(origin.split("\\.|,|!| ")));
        for (String str : lineArr) {
            if (!inn.contains(str)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}