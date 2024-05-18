package FinalOOPLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;

class Books {
    String title;
    String author;

    public Books(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "'" + title + "' by " + author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return title.equals(book.getTitle()) && author.equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}

class LibraryM {
    private List<Book> books;

    public LibraryM() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book removed: " + book);
        } else {
            System.out.println("Book not found: " + book);
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

public class LibraryApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryM library = new LibraryM();

        while (true) {
            System.out.println("\nChoose Operation:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter Title of the Book:");
                    String title = scanner.nextLine();
                    System.out.println("Enter Author of the Book:");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter Title of the Book to Remove:");
                    String removeTitle = scanner.nextLine();
                    System.out.println("Enter Author of the Book to Remove:");
                    String removeAuthor = scanner.nextLine();
                    library.removeBook(new Book(removeTitle, removeAuthor));
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
