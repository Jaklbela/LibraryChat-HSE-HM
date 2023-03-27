import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        List<Book> books = new ArrayList<>();
        Book example = new Book();
        example.name = "Java for beginners";
        ArrayList<String> authors = new ArrayList<>();
        authors.add("hse");
        authors.add("fcs");
        authors.add("dmalex");
        example.authors = authors;
        example.description = "Book about java language for students.";
        example.year = 2023;
        System.out.println("Write a command (get <book name>; put <book>; list; all; return)");
        books.add(example);
        while (true) {
            Scanner in = new Scanner(System.in);
            String command = in.next();

            switch (command) {
                case "get": {
                    String name = in.next();
                    books.add(library.get(name));
                    break;
                }
                case "put": {
                    library.returnBook(example);
                    books.remove(example);
                    break;
                }
                case "list": {
                    for (Book b : books
                    ) {
                        library.print(b);
                    }
                    break;
                }
                case "all": {
                    for (Book b : library.books
                    ) {
                        library.print(b);
                    }
                    System.out.println("Quantity: " + library.quantity);
                    break;
                }
                case "return": {
                    return;
                }
            }
        }
    }
}