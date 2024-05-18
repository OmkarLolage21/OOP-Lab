package FinalOOPLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Movie {
    private String title;
    private String genre;
    private int duration;
    private double rating;

    public Movie(String title, String genre, int duration, double rating) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Genre: " + genre + ", Duration: " + duration + " mins, Rating: " + rating;
    }
}

class Theater {
    private List<Movie> movies;
    private List<String> bookedTickets;

    public Theater() {
        this.movies = new ArrayList<>();
        this.bookedTickets = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        System.out.println("Movie added: " + movie);
    }

    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
        } else {
            System.out.println("Available movies:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    public void bookTicket(String movieTitle) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                bookedTickets.add(movieTitle);
                System.out.println("Ticket booked for: " + movieTitle);
                return;
            }
        }
        System.out.println("Movie not found: " + movieTitle);
    }

    public void displayBookedTickets() {
        if (bookedTickets.isEmpty()) {
            System.out.println("No booked tickets.");
        } else {
            System.out.println("Booked tickets:");
            for (String ticket : bookedTickets) {
                System.out.println(ticket);
            }
        }
    }

    public void cancelBooking(String movieTitle) {
        if (bookedTickets.remove(movieTitle)) {
            System.out.println("Booking cancelled for: " + movieTitle);
        } else {
            System.out.println("No booking found for: " + movieTitle);
        }
    }
}

public class OnlineTicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Theater theater = new Theater();

        // Adding some sample movies to the theater
        theater.addMovie(new Movie("Inception", "Sci-Fi", 148, 8.8));
        theater.addMovie(new Movie("The Dark Knight", "Action", 152, 9.0));
        theater.addMovie(new Movie("Interstellar", "Sci-Fi", 169, 8.6));
        theater.addMovie(new Movie("The Matrix", "Action", 136, 8.7));

        while (true) {
            System.out.println("\nOnline Movie Ticket Booking System");
            System.out.println("1. Display available movies");
            System.out.println("2. Book tickets for a movie");
            System.out.println("3. View booked tickets");
            System.out.println("4. Cancel a booked ticket");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    theater.displayMovies();
                    break;
                case 2:
                    System.out.print("Enter the title of the movie to book: ");
                    String movieTitle = scanner.nextLine();
                    theater.bookTicket(movieTitle);
                    break;
                case 3:
                    theater.displayBookedTickets();
                    break;
                case 4:
                    System.out.print("Enter the title of the movie to cancel booking: ");
                    String cancelTitle = scanner.nextLine();
                    theater.cancelBooking(cancelTitle);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
