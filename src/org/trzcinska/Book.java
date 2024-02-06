package org.trzcinska;

public class Book implements Comparable {
    private String title;
    private String genre;
    private int numberOfPages;

    public Book(int numberOfPages, String genre, String title) {
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    @Override
    public int compareTo(Object o) {
        Book b = (Book) o;
        //z int numberOfPages zrobić obiekt
        return Integer.valueOf(this.numberOfPages).compareTo(b.getNumberOfPages());
    }
}
