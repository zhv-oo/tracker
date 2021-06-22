package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentsToMapTest {
    @Test
    public void items4To3Maps() {
        StudentsToMap stm = new StudentsToMap();
        List<Student> students = List.of(
                new Student(4, "Ivanov"),
                new Student(4, "Petrov"),
                new Student(3, "Krasnov"),
                new Student(5, "Sidorov")
        );
        Map<String, Student> result = stm.listToMap(students);
        assertEquals(students.get(2), result.get("Krasnov"));
    }

    @Test
    public void whenDuplicateKey() {
        StudentsToMap stm = new StudentsToMap();
        List<Student> students = List.of(
                new Student(4, "Ivanov"),
                new Student(4, "Petrov"),
                new Student(3, "Ivanov"),
                new Student(5, "Sidorov")
        );
        Map<String, Student> result = stm.listToMap(students);
        assertThat(result.size(), is(3));
    }
}