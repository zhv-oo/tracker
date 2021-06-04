package ru.job4j.poly;

public class Bus implements Transport {

    private boolean drive = false;
    private int pass = 0;
    private double price = 50;

    @Override
    public void drive() {
        if (!this.drive) {
            this.drive = true;
        }
    }

    @Override
    public void passengers(int count) {
        this.pass = count;
    }

    @Override
    public double refuel(int count) {
        return this.price * count;
    }
}