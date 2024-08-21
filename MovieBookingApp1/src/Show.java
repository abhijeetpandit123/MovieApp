import java.util.ArrayList;
import java.util.List;

public class Show {
    private String showtime;
    private List<Seat> seats;

    public Show(String showtime, int numberOfSeats) {
        this.showtime = showtime;
        this.seats = initializeSeats(numberOfSeats);
    }

    private List<Seat> initializeSeats(int numberOfSeats) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.add(new Seat(i));
        }
        return seats;
    }

    public String getShowtime() {
        return showtime;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Seat bookSeat() {
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                seat.book();
                return seat;
            }
        }
        return null; // No available seats
    }

    public boolean cancelSeat(int seatNumber) {
        if (seatNumber > 0 && seatNumber <= seats.size()) {
            Seat seat = seats.get(seatNumber - 1);
            if (seat.isBooked()) {
                seat.cancel();
                return true;
            }
        }
        return false;
    }
    public int availableSeats() {
        int count = 0;
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                count++;
            }
        }
        return count;
    }
}
