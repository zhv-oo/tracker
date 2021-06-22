package ru.job4j.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsToMap {
    public Map<String, Student> listToMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        key -> key.getSurname(),
                        value -> value,
                        (value, value2) -> value.equals(value2.getSurname())
                                ? value : value2
                ));
    }
}