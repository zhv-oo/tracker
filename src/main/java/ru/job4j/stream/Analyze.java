package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(list -> list.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(obj ->
                        new Tuple(obj.getName(), obj.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .average()
                                .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(obj -> obj.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName, LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::getScore)
                        ))
                .entrySet()
                .stream()
                .map(obj -> new Tuple(obj.getKey(), obj.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(obj ->
                        new Tuple(obj.getName(), obj.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .sum()))
                                .max(Comparator.comparing(Tuple::getScore))
                                .orElse(null);

    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(obj -> obj.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                Collectors.summingDouble(Subject::getScore)
                        ))
                .entrySet()
                .stream()
                .map(obj -> new Tuple(obj.getKey(), obj.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}