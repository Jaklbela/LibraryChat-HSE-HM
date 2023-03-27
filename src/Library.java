import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    public Library() {
        books = new ArrayList<>();
        quantity = 0;
    }

    public Book get(String name) {
        List<Book> match = find(name);
        if (match.size() == 0) {
            System.out.println("There is no such a book in a library.");
            return null;
        }
        if (match.size() > 1) {
            for (int i = 1; i < match.size() + 1; ++i) {
                System.out.print(i + ": ");
                print(match.get(i - 1));
            }
        }
        System.out.println("Enter a number of a book.");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice < 1 || choice > match.size()) {
            System.out.println("Wrong number.");
            return null;
        }
        Book book = match.get(choice - 1);
        books.remove(book);
        System.out.println("Book " + book.name + " is taken.");
        match.clear();
        quantity--;
        return book;
    }

    public void returnBook(Book book) {
        books.add(book);
        System.out.println("Book " + book.name + " is returned.");
        quantity++;
    }

    public void ifContains(String name) {
        List<Book> match = find(name);
        if (match.size() == 0) {
            System.out.println("There is no book with this name in a library.");
        } else {
            System.out.println("Book with this name is exist in a library.");
        }
    }
    
    public void print(Book book) {
        System.out.print("Name: " + book.name + "\n" +
                "Description: " + book.description + "\n" +
                "Authors:");
        for (String author: book.authors
             ) {
            System.out.print(" " + author);
        }
        System.out.print("\n" + "Year: " + book.year + "\n");
    }
    
    private List<Book> find(String name) {
        List<Book> match = new ArrayList<>();
        for (Book book: books
             ) {
            if (book.name == name) {
                match.add(book);
            }
        }
        return match;
    }

    public List<Book> books;
    public int quantity;
}
