import java.util.ArrayList;
import java.util.List;

public class Booking {
    private List<Movie> movies;

    public Booking() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }


    public void bookTicket(String movieTitle, String showtime, Integer seatNumber) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                for (Show show : movie.getShows()) {
                    if (show.getShowtime().equalsIgnoreCase(showtime)) {
                        // Checking if a specific seat number is provided
                        if (seatNumber != null) {
                            Seat seat = show.getSeats().get(seatNumber - 1);
                            if (!seat.isBooked()) {
                                seat.book();

                                System.out.println("Booking confirmed: Movie - " + movieTitle + ", Showtime - " + showtime + ", Seat Number - " +seatNumber);
                            } else {
                                System.out.println("Seat number " + seatNumber + " is already booked.");
                            }
                        } else {
                            // If no specific seat number is provided, allocate the next available seat
                            Seat bookedSeat = show.bookSeat();
                            if (bookedSeat != null) {
                                System.out.println("Booking confirmed: Movie - " + movieTitle + ", Showtime - " + showtime + ", Seat Number - " + bookedSeat.getSeatNumber());
                            } else {
                                System.out.println("No available seats for the selected showtime.");
                            }
                        }
                        return;
                    }
                }
            }
        }
        System.out.println("Movie or showtime not found.");
    }
    public void cancelTicket(String movieTitle, String showtime, int seatNumber) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                for (Show show : movie.getShows()) {
                    if (show.getShowtime().equalsIgnoreCase(showtime)) {
                        boolean canceled = show.cancelSeat(seatNumber);
                        if (canceled) {
                            System.out.println("Ticket canceled: Movie - " + movieTitle + ", Showtime - " + showtime + ", Seat Number - " + seatNumber);
                        } else {
                            System.out.println("Invalid seat number or seat was not booked.");
                        }
                        return;
                    }
                }
            }
        }
        System.out.println("Movie or showtime not found.");
    }

    public void displayStatus(String movieTitle, String showtime) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                for (Show show : movie.getShows()) {
                    if (show.getShowtime().equalsIgnoreCase(showtime)) {
                        Seat show1 = new Seat(100);
                        System.out.println("Showtime: " + showtime + ", Available Seats: " + show.availableSeats()+", Booked Seats:"+(show1.getSeatNumber()-show.availableSeats()) );
                        return;
                    }

                }
            }
        }
        System.out.println("Movie or showtime not found.");
    }
}
