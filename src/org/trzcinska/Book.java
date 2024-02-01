package org.trzcinska;

public class Book {
    private String title;
    private String genre;
    private int numberOfPages;

    public Book(int numberOfPages, String genre, String title) {
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {

        return genre;
    }

    public int getNumberOfPages() {

        return numberOfPages;
    }
}
