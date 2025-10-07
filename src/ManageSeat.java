import java.awt.datatransfer.FlavorEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManageSeat extends ManageFlight {
    // List to store seats
    private final List<Seat> seats = new ArrayList<>();

    // Constructor
    public ManageSeat(){}

    // Method to create a seat
    public Seat createSeat(int seatNumber, boolean seatStatus, String seatType , int bookingID) {
        // Create a new Seat object
        Seat seat = new Seat(seatNumber, seatStatus, seatType, bookingID);
        // Add the seat to the seats list
        this.seats.add(seat);
        return seat;
    }

    // Method to get all seats
    public List<Seat> getSeats() {
        return seats;
    }

    // Method to check if a seat is available
    public boolean isSeatAvailable(int seatNumber) {
        boolean check = false;
        for (Seat seat : seats) {
            if (seat.getSeatNumber() == seatNumber) {
                if (seat.getSeatStatus()) {
                    // Print confirmation message if seat is available
                    System.out.println("you chose seat number: " + seatNumber + " Checking availability.....  true");
                    return true;
                }
            }
        }
        // Print message if seat is not available
        System.out.println(".... false");
        return false;
    }

    // Method to check availability of all seats
    public void checkAllSeats(){
        for (int i = 0; i < seats.size(); i++) {
            Seat seat = this.seats.get(i);
            if(seat.getSeatStatus()) {
                // Print message if seat is available
                System.out.println("seat number: " + seat.getSeatNumber() + " is Available");
            } else {
                // Print message if seat is taken
                System.out.println("Seat number: " + seat.getSeatNumber() + " is taken");
            }
        }
    }
}
