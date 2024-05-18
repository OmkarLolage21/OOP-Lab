package FinalOOPLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class LibraryBook {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public LibraryBook(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return title + " by " + author + ", ISBN: " + isbn + ", Available: " + (available ? "Yes" : "No");
    }
}

class BookLibrary {
    private List<LibraryBook> books;

    public BookLibrary() {
        books = new ArrayList<>();
    }

    public void addBook(LibraryBook book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor());
    }

    public void borrowBook(String isbn) {
        for (LibraryBook book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.isAvailable()) {
                    book.borrow();
                    System.out.println("You have borrowed: " + book.getTitle());
                } else {
                    System.out.println("Sorry, this book is currently unavailable.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String isbn) {
        for (LibraryBook book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isAvailable()) {
                    book.returnBook();
                    System.out.println("You have returned: " + book.getTitle());
                } else {
                    System.out.println("This book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchByTitle(String title) {
        List<LibraryBook> results = new ArrayList<>();
        for (LibraryBook book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        if (!results.isEmpty()) {
            for (LibraryBook book : results) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found with that title.");
        }
    }

    public void searchByAuthor(String author) {
        List<LibraryBook> results = new ArrayList<>();
        for (LibraryBook book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }
        if (!results.isEmpty()) {
            for (LibraryBook book : results) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found by that author.");
        }
    }

    public void displayAvailableBooks() {
        List<LibraryBook> availableBooks = new ArrayList<>();
        for (LibraryBook book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        if (!availableBooks.isEmpty()) {
            System.out.println("Available books:");
            for (LibraryBook book : availableBooks) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books are currently available.");
        }
    }
}

public class LibraryISBN {
    public static void main(String[] args) {
        BookLibrary library = new BookLibrary();
        Scanner scanner = new Scanner(System.in);

        library.addBook(new LibraryBook("To Kill a Mockingbird", "Harper Lee", "1234567890"));
        library.addBook(new LibraryBook("1984", "George Orwell", "2345678901"));
        library.addBook(new LibraryBook("The Great Gatsby", "F. Scott Fitzgerald", "3456789012"));

        while (true) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add a new book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Search for a book by title");
            System.out.println("5. Search for a book by author");
            System.out.println("6. Display available books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new LibraryBook(title, author, isbn));
                    break;
                case 2:
                    System.out.print("Enter ISBN to borrow: ");
                    isbn = scanner.nextLine();
                    library.borrowBook(isbn);
                    break;
                case 3:
                    System.out.print("Enter ISBN to return: ");
                    isbn = scanner.nextLine();
                    library.returnBook(isbn);
                    break;
                case 4:
                    System.out.print("Enter title to search: ");
                    title = scanner.nextLine();
                    library.searchByTitle(title);
                    break;
                case 5:
                    System.out.print("Enter author to search: ");
                    author = scanner.nextLine();
                    library.searchByAuthor(author);
                    break;
                case 6:
                    library.displayAvailableBooks();
                    break;
                case 7:
                    System.out.println("Exiting the library system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
