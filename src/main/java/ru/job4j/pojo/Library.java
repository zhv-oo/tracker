package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] lib = new Book[] {new Book("One", 126), new Book("Two", 154),
                new Book("Three", 88), new Book("Clean code", 144)};
        show(lib);
        Book tmp = lib[3];
        lib[3] = lib[0];
        lib[0] = tmp;
        show(lib);
        show(lib, "Clean code");
    }

    public static void show(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.print(books[i].getName() + " " + books[i].getcPages() + " | ");
        }
        System.out.println(System.lineSeparator());
    }

    public static void show(Book[] books, String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                System.out.println(name + " " + book.getcPages());
                break;
            }
        }
    }
}