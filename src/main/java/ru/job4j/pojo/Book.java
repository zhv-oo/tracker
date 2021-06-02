package ru.job4j.pojo;

public class Book {
    private String name;
    private int cPages;

    public Book(String name, int cPages) {
        this.name = name;
        this.cPages = cPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getcPages() {
        return cPages;
    }

    public void setcPages(int cPages) {
        this.cPages = cPages;
    }
}
