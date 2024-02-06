package org.trzcinska;
public class Author {
    private String name;
    private int age;
    private String favouriteGenre;

    public Author(String name, int age, String favouriteGenre) {
        this.name = name;
        this.age = age;
        this.favouriteGenre = favouriteGenre;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getFavouriteGenre() {
        return this.favouriteGenre;
    }
}
