import java.util.*;

class Booking {
    String movieName, customerName;
    double ticketPrice;
    int tickets;

    Booking(String customerName, String movieName,
            double ticketPrice, int tickets) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.tickets = tickets;
    }

    Booking(String customerName, String movieName, int tickets) {
        this(customerName, movieName, 200, tickets);
    }

    void bookTickets(int tickets) {
        this.tickets = tickets;
    }

    void bookTickets(int tickets, double price) {
        this.tickets = tickets;
        this.ticketPrice = price;
    }

    void display() {
        System.out.println("\nCustomer Name   : "
                + customerName.toUpperCase());
        System.out.println("Movie Name      : "
                + movieName.toUpperCase());

        if (tickets <= 0) {
            System.out.println("Booking Status  : Invalid number of tickets");
            return;
        }

        double total = ticketPrice * tickets;
        double discount = (tickets >= 5) ? total * 0.10 : 0;
        double finalAmount = total - discount;

        System.out.printf("Ticket Price    : Rs. %.2f%n", ticketPrice);
        System.out.println("Number of Tickets: " + tickets);
        System.out.println("Booking Status  : Booking Successful");
        System.out.printf("Total Amount    : Rs. %.2f%n", total);
        System.out.printf("Discount        : Rs. %.2f%n", discount);
        System.out.printf("Final Amount    : Rs. %.2f%n", finalAmount);
    }

    boolean compareCustomer(Booking b) {
        return customerName.equalsIgnoreCase(b.customerName);
    }
}

 class Main {
    public static void main(String[] args) {
        System.out.println("CINEMA TICKET BOOKING");

        Booking b1 = new Booking("Sneha", "Avatar", 200, 5);
        b1.display();

        Booking b2 = new Booking("Arjun", "Avatar", 2);
        b2.display();

        System.out.println("Same Customer: "
                + b1.compareCustomer(b2));
    }
}