package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroup("А-438");
        student.setDateIn(new Date());
        System.out.println("ФИО: " + student.getFio() + System.lineSeparator()
                + "Группа: " + student.getGroup() + System.lineSeparator()
                + "Дата поступления: " + student.getDateIn());
    }
}