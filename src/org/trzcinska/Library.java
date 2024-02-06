package org.trzcinska;

import java.util.*;

public class Library {
    private HashMap<Author, List<Book>> authorAndBook = new HashMap<>();
    private int numberOfPages;
    String authorName;
    Scanner scanner = new Scanner(System.in);

    public List<Book> getBooksOfAuthor(String authorName) {
        //z pomocą ifa sytuacje:
        //1. autor istnieje w bazie
        for (Author author : authorAndBook.keySet()) {
            if (author.getName().equals(authorName)) {
                System.out.println("Found");
                System.out.println(author);
                return authorAndBook.get(author);
            }
        }
        //jeśli autor nie istnieje, to zwróć mi pustą listę
        return new ArrayList<>();
    }

    public void addBookToAuthor(String authorName, Book book) {
        //wyciągnij listę wartości dla tego autora i zapisz ja do zmiennej chwilowej
        List<Book> books = authorAndBook.get(authorName);
        //jeśli tytuł istnieje to kontynuuj
        if (books == null) {
            books = new ArrayList<>();
            books.add(book);
            //dodać autora
            System.out.println("What is the age of the author? ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("What is the favourite genre? ");
            String genre = scanner.nextLine();
            Author author = new Author(authorName, age, genre);
            authorAndBook.put(author, books);
            return;
        }
        //sprawdź czy lista książek zawiera podany tytuł
        //iteruje po liście odczytanych ksiazek autora
        for (Book book1 : books) {
            //żeby znaleźć właściwy tytuł
            if (book1.getTitle().equals(book.getTitle())) {
                System.out.println("Found");
                System.out.println(book1);
                return;
            }
        }
        //jeśli tytuł nie istnieje, to dodaj go do mapy
        books.add(book);
        //find author of the book by authorName
        for (Author author : authorAndBook.keySet()) {
            if (author.getName().equals(authorName)) {
                //dodaje książkę do znalezionego autora
                authorAndBook.put(author, books);
            }
        }
    }

    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        for (Author author : authorAndBook.keySet()) {
            authors.add(author);
        }
        return authors;
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        for (Author author : authorAndBook.keySet()) {
            List<Book> publications = authorAndBook.get(author); //wybiera książki na podstawie autora z hashmapy
            for (Book publication : publications) {  //wybiera pojedynczy tytuł z listy pojedynczego autora
                books.add(publication);
            }
        }
        return books;
    }

    public HashMap<Author, List<Book>> getAllBooksAndAuthors() {
        return authorAndBook;
    }

}