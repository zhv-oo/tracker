package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FuncDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = List.of(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPow2FunctionThenLinearResults() {
        List<Double> result = FuncDiapason.diapason(-2, 2, x -> x * x);
        List<Double> expected = List.of(4D, 1D, 0D, 1D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenShowFunctionThenLinearResults() {
        List<Double> result = FuncDiapason.diapason(2, 6, x -> Math.pow(2, x) + 1);
        List<Double> expected = List.of(5D, 9D, 17D, 33D);
        assertThat(result, is(expected));
    }
}