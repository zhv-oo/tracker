package ru.job4j.stream;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class MatrixConvertTest {

    @Test
    public void matrixIntToList() {
        MatrixConvert matrixConvert = new MatrixConvert();
        Integer[][] src = new Integer[][] {
                {1, 2, 3},
                {2, 3, 5},
                {4, 7, 9}
        };
        List<Integer> result = matrixConvert.matrixToList(src);
        List<Integer> expected = List.of(1, 2, 3, 2, 3, 5, 4, 7, 9);
        assertEquals(expected, result);
    }
}