package ru.job4j.builder;

public class Car {
    private String brand;
    private String line;
    private byte age;
    private String model;
    private String type;
    private boolean secondHand;
    private byte owners;

    static class Builder {
        private String brand;
        private String line;
        private byte age;
        private String model;
        private String type;
        private boolean secondHand;
        private byte owners;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildLine(String line) {
            this.line = line;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildType(String type) {
            this.type = type;
            return this;
        }

        Builder buildSndHand(Boolean secondHand) {
            this.secondHand = secondHand;
            return this;
        }

        Builder buildOwners(byte owners) {
            this.owners = owners;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.line = line;
            car.age = age;
            car.model = model;
            car.type = type;
            car.secondHand = secondHand;
            car.owners = owners;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Brand: " + this.brand + " Line: " + this.line
                + " Age: " + this.age + " Model: " + this.model
                + " Type: " + this.type + " Second Hand: " + this.secondHand
                + " Owners: " + this.owners;
    }

    public static void main(String[] args) {
        Car car = new Builder().buildBrand("Honda")
                .buildLine("5doors")
                .buildAge((byte) 9)
                .buildModel("CR-V")
                .buildType("SUV")
                .buildSndHand(true)
                .buildOwners((byte) 2)
                .build();
        System.out.println(car);
    }
}