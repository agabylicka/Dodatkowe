import org.trzcinska.Author;
import org.trzcinska.Book;
import org.trzcinska.Library;

import java.util.*;
//Stwórz klasę biblioteki, która umożliwi użytkownikowi na zapis autora i listy książek, które napisał. Użytkownik
// powinien móc dodać autora, książki do autora.
// Książki powinny być sortowane przy użyciu liczby stron!!!
// Jako główną strukturę danych wykorzystaj HashMapę, gdzie kluczem jest autor, wartością lista książek.


public class Main {
    public static void main(String[] args) {
        HashMap<String, List<String>> authorAndBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String answer;
        boolean doQuit = true;
        do {
            System.out.println("If You want quit, write: exit");
            System.out.println("To add author, write: author");
            System.out.println("To add title, write: title");
            answer = scanner.nextLine();
            if (answer.equals("exit")) {
                doQuit = false;
                break;
            } else if (answer.equals("author")) {
                System.out.println("Give type full name of the author");
                answer = scanner.nextLine();
                //z pomocą ifa sytuacje:
                //1. autor istnieje w bazie
                if (authorAndBook.containsKey(answer)) {
                    System.out.println("Author exist");
                    continue;
                } //nie istnieje
                authorAndBook.put(answer, new ArrayList<>());
            } else if (answer.equals("title")) {
                System.out.println("Who is the author?");
                answer = scanner.nextLine();
                //autor istnieje, dodać do niego książkę
                if (authorAndBook.containsKey(answer)) {
                    //wyciągnij listę wartości dla tego autora i zapisz ja do zmiennej chwilowej
                    List<String> titles = authorAndBook.get(answer);
                    //do listy/zmiennej chwilowej dodaj jeden tytuł
                    System.out.println("What is the title of the book?");
                    String title = scanner.nextLine();
                    //jeśli tytuł istnieje to kontynuuj
                    if (titles.contains(title)) {
                        System.out.println("Title exist");
                        continue;
                    } else {
                        //dodanie tytułu do listy
                        titles.add(title);
                        //dodanie listy do mapy
                        authorAndBook.put(answer, titles);
                    }
                } else {
                    //dodaj autora
                    String author = answer;
                    //dodaj tytuł
                    System.out.println("What is the title of the book?");
                    String title = scanner.nextLine();
                    //dodaj autora i listę tytułów autora do mapy
                    List<String> titles = new ArrayList<>();
                    titles.add(title);
                    authorAndBook.put(author, titles);
                }
            } else {
                System.out.println("Give proper answer");
            }

        } while (doQuit);
    }
}
