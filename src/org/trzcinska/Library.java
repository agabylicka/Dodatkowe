package org.trzcinska;

import java.util.*;

public class Library {
    HashMap<String, List<String>> authorAndBook = new HashMap<>();
    private int numberOfPages;
    Scanner scanner = new Scanner(System.in);
    String authorName;

    public List<String> getBooksOfAuthor(String authorName) {
        //z pomocą ifa sytuacje:
        //1. autor istnieje w bazie
        if (authorAndBook.containsKey(this.authorName)) {
            System.out.println("Author exist");
            return authorAndBook.get(authorName);
        }
        return Collections.emptyList();
    }

    public List<String> addBookToAuthor(String authorName, org.trzcinska.Book book) {
        //wyciągnij listę wartości dla tego autora i zapisz ja do zmiennej chwilowej
        List<String> books = authorAndBook.get(this.authorName);
        String title = book.getTitle();
        //jeśli tytuł istnieje to kontynuuj
        if (books == null) {
            books = new ArrayList<>();
        }

        if (books.contains(title)) {
            System.out.println("Title exist");
        } else {
            //dodanie tytułu do listy
            books.add(title);
            authorAndBook.put(authorName, books);
        }
        return books;
    }

    public List<String> getAllAuthors() {
        List<String> authors = new ArrayList<>();
        for (String author : authorAndBook.keySet()) {
            authors.add(author);
        }
        return authors;
    }

    public List<String> getAllBooks() {
        List<String> books = new ArrayList<>();
        for (String key : authorAndBook.keySet()) {
            List<String> publications = authorAndBook.get(key); //wybiera książki na podstawie autora z hashmapy
            for (String publication : publications) {  //wybiera pojedynczy tytuł z listy pojedynczego autora
                books.add(publication);
            }
        }
        return books;
    }

    public HashMap<String, List<String>> getAllBooksAndAuthors() {

        return authorAndBook;
    }

}