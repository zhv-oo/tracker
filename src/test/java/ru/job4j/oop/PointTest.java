package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when3D4To0Than() {
        Point figur = new Point(4, 4, 4);
        Point figurDist = new Point(0, 0, 0);
        double expect = 6.93;
        double rsl = figur.distance3d(figurDist);
        Assert.assertEquals(expect, rsl, 0.01);
    }

    @Test
    public void when3DThan() {
        Point figur = new Point(4, 1, 8);
        Point figurDist = new Point(0, 3, 2);
        double expect = 7.48;
        double rsl = figur.distance3d(figurDist);
        Assert.assertEquals(expect, rsl, 0.01);
    }

    @Test
    public void when3D0Than0() {
        Point figur = new Point(0, 0, 0);
        Point figurDist = new Point(0, 0, 0);
        double expect = 0;
        double rsl = figur.distance3d(figurDist);
        Assert.assertEquals(expect, rsl, 0.01);
    }
}