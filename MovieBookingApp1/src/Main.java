import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Booking bookingSystem = new Booking();

        // Initialize movies and shows
        Show show1 = new Show("10:00 AM", 100);
        Show show2 = new Show("1:00 PM", 100);
        Movie movie1 = new Movie("BAHUBALI", "Action", Arrays.asList(show1, show2));

        Show show3 = new Show("11:00 AM", 100);
        Show show4 = new Show("2:00 PM", 100);
        Movie movie2 = new Movie("TOY STORY", "Cartoon", Arrays.asList(show3, show4));

        bookingSystem.addMovie(movie1);
        bookingSystem.addMovie(movie2);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMovie Ticket Booking System");
            System.out.println("1. Available Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Display Status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Available Movies:");
                    System.out.println("1. BAHUBALI - Action (Showtimes: 10:00 AM, 1:00 PM)");
                    System.out.println("2. TOY STORY - Cartoon (Showtimes: 11:00 AM, 2:00 PM)");
                    break;

                case 2:
                    System.out.println("Select a movie:");
                    System.out.println("1. BHAUBALI");
                    System.out.println("2. TOY STORY");
                    System.out.print("Enter your choice: ");
                    int movieChoice = scanner.nextInt();
                    scanner.nextLine();

                    String bookMovieTitle = "";
                    switch (movieChoice) {
                        case 1:
                            bookMovieTitle = "BAHUBALI";
                            break;
                        case 2:
                            bookMovieTitle = "TOY STORY";
                            break;
                        default:
                            System.out.println("Invalid movie choice.");
                            continue;
                    }

                    System.out.println("Select a showtime:");
                    switch (movieChoice) {
                        case 1:
                            System.out.println("1. 10:00 AM");
                            System.out.println("2. 1:00 PM");
                            break;
                        case 2:
                            System.out.println("1. 11:00 AM");
                            System.out.println("2. 2:00 PM");
                            break;
                    }
                    int showtimeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    String bookShowtime = "";
                    if (movieChoice == 1) {
                        bookShowtime = (showtimeChoice == 1) ? "10:00 AM" : (showtimeChoice == 2) ? "1:00 PM" : "";
                    } else if (movieChoice == 2) {
                        bookShowtime = (showtimeChoice == 1) ? "11:00 AM" : (showtimeChoice == 2) ? "2:00 PM" : "";
                    }

                    if (bookShowtime.isEmpty()) {
                        System.out.println("Invalid showtime choice.");
                        continue;
                    }

                    System.out.print("Enter seat number (or leave blank for next available): ");
                    String seatInput = scanner.nextLine();
                    Integer seatNumber = seatInput.isEmpty() ? null : Integer.parseInt(seatInput);
                    bookingSystem.bookTicket(bookMovieTitle, bookShowtime, seatNumber);
                    break;

                case 3:
                    System.out.println("Select a movie:");
                    System.out.println("1. BAHUBALI");
                    System.out.println("2. TOY STORY");
                    System.out.print("Enter your choice: ");
                    int cancelMovieChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    String cancelMovieTitle = "";
                    switch (cancelMovieChoice) {
                        case 1:
                            cancelMovieTitle = "BAHUBALI";
                            break;
                        case 2:
                            cancelMovieTitle = "TOY STORY";
                            break;
                        default:
                            System.out.println("Invalid movie choice.");
                            continue;
                    }

                    System.out.println("Select a showtime:");
                    switch (cancelMovieChoice) {
                        case 1:
                            System.out.println("1. 10:00 AM");
                            System.out.println("2. 1:00 PM");
                            break;
                        case 2:
                            System.out.println("1. 11:00 AM");
                            System.out.println("2. 2:00 PM");
                            break;
                    }
                    int cancelShowtimeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    String cancelShowtime = "";
                    if (cancelMovieChoice == 1) {
                        cancelShowtime = (cancelShowtimeChoice == 1) ? "10:00 AM" : (cancelShowtimeChoice == 2) ? "1:00 PM" : "";
                    } else if (cancelMovieChoice == 2) {
                        cancelShowtime = (cancelShowtimeChoice == 1) ? "11:00 AM" : (cancelShowtimeChoice == 2) ? "2:00 PM" : "";
                    }

                    if (cancelShowtime.isEmpty()) {
                        System.out.println("Invalid showtime choice.");
                        continue;
                    }

                    System.out.print("Enter seat number: ");
                    int seatNum = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    bookingSystem.cancelTicket(cancelMovieTitle, cancelShowtime, seatNum);
                    break;

                case 4:
                    System.out.println("Select a movie:");
                    System.out.println("1.BAHUBALI ");
                    System.out.println("2. TOY STORY");
                    System.out.print("Enter your choice: ");
                    int statusMovieChoice = scanner.nextInt();
                    scanner.nextLine();

                    String statusMovieTitle = "";
                    switch (statusMovieChoice) {
                        case 1:
                            statusMovieTitle = "BAHUBALI";
                            break;
                        case 2:
                            statusMovieTitle = "TOY STORY";
                            break;
                        default:
                            System.out.println("Invalid movie choice.");
                            continue;
                    }

                    System.out.println("Select a showtime:");
                    switch (statusMovieChoice) {
                        case 1:
                            System.out.println("1. 10:00 AM");
                            System.out.println("2. 1:00 PM");
                            break;
                        case 2:
                            System.out.println("1. 11:00 AM");
                            System.out.println("2. 2:00 PM");
                            break;
                    }
                    int statusShowtimeChoice = scanner.nextInt();
                    scanner.nextLine();

                    String statusShowtime = "";
                    if (statusMovieChoice == 1) {
                        statusShowtime = (statusShowtimeChoice == 1) ? "10:00 AM" : (statusShowtimeChoice == 2) ? "1:00 PM" : "";
                    } else if (statusMovieChoice == 2) {
                        statusShowtime = (statusShowtimeChoice == 1) ? "11:00 AM" : (statusShowtimeChoice == 2) ? "2:00 PM" : "";
                    }

                    if (statusShowtime.isEmpty()) {
                        System.out.println("Invalid showtime choice.");
                        continue;
                    }

                    bookingSystem.displayStatus(statusMovieTitle, statusShowtime);
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
