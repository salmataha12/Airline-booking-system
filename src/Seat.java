import java.util.Random;

public class Seat {

    private int seatNumber;

    private int bookingID;
    private boolean seatStatus;

    private String seatType; // VIP / ECONOMY / BUSINESS;


    public Seat() {}
    public Seat(int seatNumber, boolean seatStatus, String seatType , int bookingID) {
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
        this.seatType = seatType;
        this.bookingID = bookingID;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(boolean seatStatus) {
        this.seatStatus = seatStatus;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

}
