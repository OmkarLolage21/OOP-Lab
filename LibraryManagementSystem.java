package FinalOOPLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void checkOut() {
        if (available) {
            available = false;
        } else {
            System.out.println("Book is already checked out.");
        }
    }

    public void checkIn() {
        if (!available) {
            available = true;
        } else {
            System.out.println("Book is already checked in.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Available: " + available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void checkOutBook(String title) {
        Book book = searchBook(title);
        if (book != null) {
            if (book.isAvailable()) {
                book.checkOut();
                System.out.println("Book checked out successfully.");
            } else {
                System.out.println("Book is already checked out.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    public void checkInBook(String title) {
        Book book = searchBook(title);
        if (book != null) {
            if (!book.isAvailable()) {
                book.checkIn();
                System.out.println("Book checked in successfully.");
            } else {
                System.out.println("Book is already checked in.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Add a new book");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Check out a book");
            System.out.println("5. Check in a book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added successfully.");
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book book = library.searchBook(searchTitle);
                    if (book != null) {
                        System.out.println(book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book title to check out: ");
                    String checkoutTitle = scanner.nextLine();
                    library.checkOutBook(checkoutTitle);
                    break;
                case 5:
                    System.out.print("Enter book title to check in: ");
                    String checkinTitle = scanner.nextLine();
                    library.checkInBook(checkinTitle);
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
