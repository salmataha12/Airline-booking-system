import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class represents a Flight object with various attributes and methods.
public class Flight {
    // Scanner object for user input, shared across all Flight instances.
    private static Scanner scan = new Scanner(System.in);

    // Flight attributes
    private String flightNumber;
    private String departureLocation;
    private String arrivalLocation;
    private String departureTime;
    private String arrivalTime;
    private String status;
    private String origin;
    private String destination;
    private double fare; // Fare for the flight
    private double distance; // Distance of the flight
    private final double km = 1.75; // Constant representing fare per kilometer
    private List<Seat> seats; // List of seats available on the flight
    public static List<Flight> flights = new ArrayList<>(); // Static list to store all Flight instances

    // Default constructor
    public Flight() {}

    // Parameterized constructor to initialize Flight attributes
    public Flight(String flightNumber, String departureLocation, String arrivalLocation, String departureTime, String arrivalTime, String status, String origin, String destination, double distance, List<Seat> seats) {
        this.flightNumber = flightNumber;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.fare = distance * this.km; // Calculate fare based on distance and constant fare per kilometer
        this.seats = seats;
    }

    // Getter and setter methods for Flight attributes
    public static Scanner getScan() {
        return scan;
    }

    public static void setScan(Scanner scan) {
        Flight.scan = scan;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    // Method to update fare based on distance
    public void updateFare(){
        setFare(getDistance() * this.km);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
