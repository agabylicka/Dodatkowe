package org.trzcinska;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean keep = true;
        Scanner scanner = new Scanner(System.in);
        String answer;
        Library methods = new Library();
        do {
            System.out.println("What do You want to do? Write number:" +
                    "1.Add author and book " +
                    "2.Show authors " +
                    "3.Show books " +
                    "4.Exit ");
            answer = scanner.nextLine();
            if (answer.equals("4")) {
                //"4.exit"
                keep = false;
            } else if (answer.equals("1")) {
                System.out.println("What is the name of the author? ");
                String author = scanner.nextLine();
                List<Book> books = methods.getBooksOfAuthor(author);
                if (books.isEmpty()) { // gdy nie ma autora
                    System.out.println("What is the title of the book? ");
                    String title = scanner.nextLine();
                    System.out.println("What is the number of pages? ");
                    int pages = Integer.parseInt(scanner.nextLine());
                    System.out.println("What is the genre? ");
                    String fantasy = scanner.nextLine();
                    Book object = new Book(pages, fantasy, title);
                    books.add(object);
                    methods.addBookToAuthor(author, object);
                } else { //gdy jest autor
                    System.out.println("What is the title of the book?");
                    String title = scanner.nextLine();
                    boolean titleExist = books.contains(title);
                    if (titleExist) { //tytuł istnieje
                        System.out.println("Title exist");
                    } else { // tytuł nie istnieje, dodać go
                        System.out.println("What is the number of pages?");
                        int pages = Integer.parseInt(scanner.nextLine()); //zapisana zmiennna dot. liczby stron??
                        System.out.println("What is the genre?");  //Jeszcze nie uzywana, dopiero w sortowaniu
                        String fantasy = scanner.nextLine();
                        Book object = new Book(pages, fantasy, title);
                        methods.addBookToAuthor(author, object);
                    }
                }
            } else if (answer.equals("2")) {
                //"2. Show authors"
                List<Author> allAuthors = methods.getAllAuthors();
                for (Author author : allAuthors) {
                    System.out.println(author.getName()); //iterowanie po kluczach
                }
            } else if (answer.equals("3")) {
                //"3. Show books"
                List<Book> allBooks = methods.getAllBooks();
                Collections.sort(allBooks);
                for (Book book : allBooks) {
                    System.out.println(book.getTitle()); //iterowanie po wartościach
                }
            } else {
                System.out.println("Give proper answer");
            }

        } while (keep);
    }
}