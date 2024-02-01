package org.trzcinska;

import org.trzcinska.Author;
import org.trzcinska.Book;
import org.trzcinska.Library;
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
            if (answer.equals("1")) {
                System.out.println("What is the name of the author? ");
                String author = scanner.nextLine();
                List<String> books = methods.getBooksOfAuthor(author);
                if (books.isEmpty()) { // gdy nie ma autora
                    System.out.println("What is the title of the book? ");
                    String title = scanner.nextLine();
                    System.out.println("What is the number of pages? ");
                    int pages = Integer.parseInt(scanner.nextLine());
                    System.out.println("What is the genre? ");
                    String fantasy = scanner.nextLine();
                    Book object = new Book(pages, fantasy, title);
                    methods.addBookToAuthor(author, object);
                } else { //gdy jest autor
                    System.out.println("What is the title of the book?");
                    String title = scanner.nextLine();
                    boolean titleExist = books.contains(title);
                    if (titleExist) { //tytuł istnieje
                        System.out.println("Title exist");
                    } else { // tytuł nie istnieje, dodać go
                        System.out.println("What is the number of pages?");
                        int pages = Integer.parseInt(scanner.nextLine());
                        System.out.println("What is the genre?");
                        String fantasy = scanner.nextLine();
                        Book object = new Book(pages, fantasy, title);
                        methods.addBookToAuthor(author, object);
                    }
                }
            } else if (answer.equals("2")) {
                //"2. Show authors"
                List<String> allAuthors = methods.getAllAuthors();
                for (String author : allAuthors) {
                    System.out.println(author); //iterowanie po kluczach
                }
            } else if (answer.equals("3")) {
                //"3. Show books"
                List<String> allBooks = methods.getAllBooks();
                for (String book : allBooks) {
                    System.out.println(book); //iterowanie po wartościach
                }
            } else if (answer.equals("4")) {
                //"4.exit"
                break;
            } else {
                System.out.println("Give proper answer");
            }

        } while (keep);
    }
}