package FinalOOPLab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Flight {
    private String flightNumber;
    private String departure;
    private String arrival;
    private Date departureDate;
    private Date arrivalDate;
    private int totalSeats;
    private int availableSeats;

    public Flight(String flightNumber, String departure, String arrival, Date departureDate, Date arrivalDate, int totalSeats) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        } else {
            throw new RuntimeException("No available seats for this flight.");
        }
    }

    public void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }
}

class Passenger {
    private String name;
    private String email;

    public Passenger(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class Reservation {
    private Flight flight;
    private Passenger passenger;

    public Reservation(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}

public class FlightReservationSystem {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private List<Flight> flights;
    private List<Reservation> reservations;

    public FlightReservationSystem() {
        flights = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> searchFlights(String departure, String arrival, Date departureDate) {
        List<Flight> availableFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDeparture().equals(departure) &&
                    flight.getArrival().equals(arrival) &&
                    flight.getDepartureDate().equals(departureDate)) {
                availableFlights.add(flight);
            }
        }
        return availableFlights;
    }

    public void bookTicket(Flight flight, Passenger passenger) {
        try {
            flight.bookSeat();
            Reservation reservation = new Reservation(flight, passenger);
            reservations.add(reservation);
            System.out.println("Booking confirmed for " + passenger.getName() + " on flight " + flight.getFlightNumber());
        } catch (RuntimeException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }

    public void cancelReservation(Reservation reservation) {
        Flight flight = reservation.getFlight();
        flight.cancelSeat();
        reservations.remove(reservation);
        System.out.println("Reservation canceled for " + reservation.getPassenger().getName());
    }

    public static void main(String[] args) {
        FlightReservationSystem system = new FlightReservationSystem();
        Scanner scanner = new Scanner(System.in);

        Flight flight1 = new Flight("ABC123", "New York", "Los Angeles", parseDate("01/05/2024"), parseDate("01/05/2024"), 100);
        Flight flight2 = new Flight("XYZ456", "New York", "Chicago", parseDate("02/05/2024"), parseDate("02/05/2024"), 50);
        system.addFlight(flight1);
        system.addFlight(flight2);

        System.out.println("Welcome to the Flight Reservation System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Search for flights");
            System.out.println("2. Book a ticket");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter departure city:");
                    String departure = scanner.nextLine();
                    System.out.print("Enter arrival city: ");
                    String arrival = scanner.nextLine();
                    System.out.print("Enter departure date (dd/MM/yyyy): ");
                    Date departureDate = parseDate(scanner.nextLine());
                    List<Flight> availableFlights = system.searchFlights(departure, arrival, departureDate);
                    if (availableFlights.isEmpty()) {
                        System.out.println("No flights available for the given criteria.");
                    } else {
                        System.out.println("Available flights:");
                        for (Flight flight : availableFlights) {
                            System.out.println(flight.getFlightNumber() + " - " + flight.getDeparture() + " to " + flight.getArrival());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String passengerEmail = scanner.nextLine();
                    Passenger passenger = new Passenger(passengerName, passengerEmail);
                    System.out.print("Enter the flight number you want to book: ");
                    String flightNumber = scanner.nextLine();
                    Flight selectedFlight = null;
                    for (Flight flight : system.flights) {
                        if (flight.getFlightNumber().equals(flightNumber)) {
                            selectedFlight = flight;
                            break;
                        }
                    }
                    if (selectedFlight != null) {
                        system.bookTicket(selectedFlight, passenger);
                    } else {
                        System.out.println("Flight not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter your email to cancel the reservation: ");
                    String emailToCancel = scanner.nextLine();
                    boolean found = false;
                    for (Reservation reservation : system.reservations) {
                        if (reservation.getPassenger().getEmail().equals(emailToCancel)) {
                            system.cancelReservation(reservation);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No reservation found for the provided email.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Date parseDate(String dateString) {
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return null;
        }
    }
}


