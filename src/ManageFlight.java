import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageFlight {

    public ManageFlight() {
    }

    public Flight createFlight(String flightNumber, String departureLocation, String arrivalLocation, String departureTime, String arrivalTime,
            String status, String origin, String destination, double distance, List<Seat> seats) {
        Flight flight = new Flight(flightNumber, departureLocation, arrivalLocation, departureTime, arrivalTime, status, origin, destination, distance, seats);

        Flight.flights.add(flight);  // method for adding flight

        System.out.println("-------------------------------------");
        System.out.println("Flight added");
        System.out.println("-------------------------------------");

        return flight;
    }

    public int findFlightByFlightNumber(String flightNumber) {
        for (int i = 0; i < Flight.flights.size(); i++) {
            Flight flight = Flight.flights.get(i);
            if (flight.getFlightNumber().equals(flightNumber)) {
                return i;
            }
        }
        return -1;
    }

    public List<Integer> findFlightByRoute(String origin, String destination) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < Flight.flights.size(); i++) {
            Flight flight = Flight.flights.get(i);
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public int findFlightByRouteAndTime(String origin, String destination, String departureTime) {

        for (int i = 0; i < Flight.flights.size(); i++) {
            Flight flight = Flight.flights.get(i);
            if (flight.getOrigin().equals(origin)
                    && flight.getDestination().equals(destination)
                    && flight.getDepartureTime().equals(departureTime)) {
                return i;
            }
        }
        return -1;
    }

    //remove flight from collection
    public void removeFlight(String flightNumber) {
        int index = findFlightByFlightNumber(flightNumber);
        if (index != -1) {
            Flight.flights.remove(index);
            System.out.println("-------------------------------------");
            System.out.println(flightNumber + " removed.");
            System.out.println("-------------------------------------");
            return;
        }
        System.out.println("-------------------------------------");
        System.out.println("Flight not found");
        System.out.println("-------------------------------------");
    }

    public void updateFlight(String flightNumber, String departureLocation, String arrivalLocation,
            String departureTime, String arrivalTime, String status, String origin,
            String destination, double distance) {
        int index = findFlightByFlightNumber(flightNumber);
        if (index != -1) {
            Flight flight = Flight.flights.get(index);
            flight.setFlightNumber(flightNumber);
            flight.setDepartureLocation(departureLocation);
            flight.setArrivalLocation(arrivalLocation);
            flight.setDepartureTime(departureTime);
            flight.setArrivalTime(arrivalTime);
            flight.setStatus(status);
            flight.setOrigin(origin);
            flight.setDestination(destination);
            flight.setDistance(distance);
            flight.updateFare();
            return;
        }
        System.out.println("-------------------------------------");
        System.out.println("Flight not found");
        System.out.println("-------------------------------------");
    }

    public double generateReport(String origin, String destination) {
        List<Integer> indexes = findFlightByRoute(origin, destination);   // [1, 5, 10]
        double finalFare = 0;

        for (int i = 0; i < indexes.size(); i++) {
            finalFare += Flight.flights.get(indexes.get(i)).getFare();
        }
        
        System.out.println("the total fare is: $" + finalFare);
        
        return finalFare;
    }

    public int isSeatAvailable(int flightIndex, int seatNumber) {
        List<Seat> seat = Flight.flights.get(flightIndex).getSeats();
        for (int i = 0; i < seat.size(); i++) {
            if (seat.get(i).getSeatNumber() == seatNumber && seat.get(i).getSeatStatus()) {
                return i;
            }
        }
        return -1;
    }

    public void bookTicket(String origin, String destination, String DepartureTime, int seatNumber) throws JsonProcessingException, IOException {
        Random random = new Random();
        Person currentPerson = Person.persons.get(PersonsController.userId);

        ObjectMapper objectMapper = new ObjectMapper();

        String filePathUsers = "src/Database.txt";
        String filePathFlights = "src/Flights.txt";

        int flightIndex = findFlightByRouteAndTime(origin, destination, DepartureTime);
        int seatIndex = isSeatAvailable(flightIndex, seatNumber);

        List<Seat> seats = currentPerson.getSeats();

        if (seatIndex != -1) {

            Seat seat = Flight.flights.get(flightIndex).getSeats().get(seatIndex);
            
            seat.setSeatStatus(false);
            seat.setBookingID(random.nextInt(900) + 100);
            seats.add(seat);
            
            System.out.println("Seat booked!" + " your flight ID is: " + Flight.flights.get(flightIndex).getFlightNumber() + "your booking ID is: " + seat.getBookingID());

            String _flights = objectMapper.writeValueAsString(Flight.flights);
            String _persons = objectMapper.writeValueAsString(Person.persons);

            BufferedWriter persons_writer = new BufferedWriter(new FileWriter(filePathUsers));
            persons_writer.write(_persons);

            BufferedWriter flights_writer = new BufferedWriter(new FileWriter(filePathFlights));
            flights_writer.write(_flights);

            persons_writer.close();
            flights_writer.close();

            return;
        }
        System.out.println("there is no flight with your chosen origin, destination or Time, or seat is already taken");
    }

    public void cancelBooking(int bookingID) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String filePathUsers = "src/Database.txt";
            String filePathFlights = "src/Flights.txt";

            Person currentPerson = Person.persons.get(PersonsController.userId);
            List<Seat> seats = currentPerson.getSeats();
            for (int i = 0; i < Person.persons.get(PersonsController.userId).getSeats().size(); i++) {
                Seat seat = Person.persons.get(PersonsController.userId).getSeats().get(i);
                if (seat.getBookingID() == bookingID) {
                    seat.setSeatStatus(true);
                    seats.remove(seat);
                    seat.setBookingID(-1);
                }
            }
            
            for (Flight flight : Flight.flights) {
                for (Seat seat : flight.getSeats()) {
                    if(seat.getBookingID() == bookingID){
                        seat.setBookingID(-1);
                        seat.setSeatStatus(true);
                    }
                }
            }
            Flight.flights.size();

            String _flights = objectMapper.writeValueAsString(Flight.flights);
            String _persons = objectMapper.writeValueAsString(Person.persons);

            BufferedWriter persons_writer = new BufferedWriter(new FileWriter(filePathUsers));
            persons_writer.write(_persons);

            BufferedWriter flights_writer = new BufferedWriter(new FileWriter(filePathFlights));
            flights_writer.write(_flights);

            persons_writer.close();
            flights_writer.close();
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ManageFlight.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageFlight.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateBooking(int bookingID, String origin, String destination,
            String DepartureTime, int seatNumber) throws JsonProcessingException, IOException {
        cancelBooking(bookingID);
        bookTicket(origin, destination, DepartureTime, seatNumber);
    }

    public void viewTickets() {

        for (int i = 0; i < Person.persons.get(PersonsController.userId).getSeats().size(); i++) {
            Flight flight = Flight.flights.get(i);
            Seat seats = Person.persons.get(PersonsController.userId).getSeats().get(i);
            System.out.println("Info for ticket number: " + seats.getBookingID());
            System.out.println("-----------------------------------");
            System.out.println("Your Ticket Class is: " + seats.getSeatType());
            System.out.println("Your Seat number is: " + seats.getSeatNumber());
            System.out.println("Your Flight number is: " + flight.getFlightNumber());
            System.out.println("Your destination is: " + flight.getDestination());
            System.out.println("Your origin is: " + flight.getOrigin());
            System.out.println("Your arrival location is: " + flight.getArrivalLocation());
            System.out.println("Your departure time is: " + flight.getDepartureTime());
            System.out.println("Your arrival time is: " + flight.getArrivalTime());
            System.out.println("----------------------------------------------------------------------");
        }

    }

    public void timingSlots() {
        for (int i = 0; i < Flight.flights.size(); i++) {
            Flight flight = Flight.flights.get(i);
            System.out.println("Available time slots are: " + " is " + Flight.flights.get(i).getDepartureTime());
        }
    }

    public int returnFlightIndexByFlightNumber(String FlightNumber) {
        int counter = 0;
        for (int i = 0; i < Flight.flights.size(); i++) {
            Flight flight = Flight.flights.get(i);
            if (flight.getFlightNumber().equals(FlightNumber)) {
                counter = i;
            }
        }
        return counter;
    }

    public String displayAllFlight() {
        StringBuilder flightInfo = new StringBuilder();
        for (int i = 0; i < Flight.flights.size(); i++) {
            Flight flight = Flight.flights.get(i);
            flightInfo.append("Flight number: ").append(flight.getFlightNumber()).append("\n");
            flightInfo.append("Origin: ").append(flight.getOrigin()).append("\n");
            flightInfo.append("Destination: ").append(flight.getDestination()).append("\n\n");
        }
        return flightInfo.toString();

    }
}