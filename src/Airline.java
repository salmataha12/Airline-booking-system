import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;

class Airline {

    //---------------------------------------------COLLECTIONS---------------------------------------//
    public static void main(String[] args) throws IOException {

        // Initialize scanner for user input
        Scanner input = new Scanner(System.in);

        // Initialize controllers
        PersonsController per = new PersonsController();
        ManageFlight manage = new ManageFlight();
        ManageSeat seat = new ManageSeat();

        // Create some sample person and flight data
        // Add sample passengers and admins
        new Person("omar", 24, "M", "omar@gmail.com", "egyptian", "hossam", "123", "PASSENGER", new Passenger("992233", true, 12), new Admin(), new ArrayList<Seat>());
        new Person("abdallah", 19, "M", "abduallh@gmail.com", "egyptian", "ahmed", "222", "ADMIN", new Passenger(), new Admin("trash", 12, 996633), new ArrayList<Seat>());

        // Add passengers
        per.addPassenger("ashraf", 22, "M", "asharf@gmail.com", "bangaladish", "mohsen", "333", "AC103", false, -5);
        per.addPassenger("mohsen", 22, "M", "asharf@gmail.com", "bangaladish", "mohsen", "333", "AC103", false, -5);

        // Define seats for flights
        List<Seat> seatsForFlightABC20 = new ArrayList<>() {
            {
                add(new Seat(1, true, "Business", -1)); //true = available
                add(new Seat(2, true, "Business", -1));
                // Add more seats as needed
            }
        };

        // Create flights and add seats
        manage.createFlight("ABC20", "Cairo Air", "Bangladish Air", "5:03", "7:03", "Active", "Egypt", "Bangladish", 600, seatsForFlightABC20);

        // Update flights
        manage.updateFlight("ABC20", "KSA Air", "Cairo Air", "10:02", "12:02", "Active", "KSA", "Egypt", 150);    // 0

        // Authenticate person
        per.authenticatePerson("hossam", "123");

        // Book ticket
        manage.bookTicket("KSA", "Egypt", "10:02", 2);
    }
}






//        //--------------------------------------------TESTING----------------------------------------------//
//
//
//        String userName, password, str1, str2, str3, str4, str5, str6, str7, str8, str9;
//        int choice = 0, index, num1, login_choice = 0, num2, pick = 0;
//
//        do {
//            System.out.println("-1 - EXIT");
//            System.out.println(" 0 - Sign_up");
//            System.out.println(" 1 - log in");
//            pick = input.nextInt();
//            input.nextLine();
//            if(pick == -1){
//                return;
//            }
//
//            if (pick == 0) {
//                System.out.println("Enter your name: ");
//                str1 = input.nextLine();
//                System.out.println("Enter your age: ");
//                num1 = input.nextInt();
//                input.nextLine();
//                System.out.println("Enter your gender: ");
//                str2 = input.nextLine();
//                System.out.println("Enter your email: ");
//                str3 = input.nextLine();
//                System.out.println("Enter your nationality: ");
//                str4 = input.nextLine();
//                System.out.println("Enter your username : ");
//                str5 = input.nextLine();
//                System.out.println("Enter your password : ");
//                str6 = input.nextLine();
//                System.out.println("Enter your passport number : ");
//                str7 = input.nextLine();
//                per.addPassenger(str1, num1, str2, str3, str4, str5, str6, str7, false, 0);
//            } else {
//                do {
//                    System.out.println("Enter your username");
//                    userName = input.nextLine();
//                    System.out.println("Enter your password");
//                    password = input.nextLine();
//                    if (per.authenticatePerson(userName, password) == -1) {
//                        System.out.println("invalid credintials: ");
//                        System.out.println("0 - return ");
//                        System.out.println("1 - Try again ");
//                        login_choice = input.nextInt();
//                        input.nextLine();
//
//                    }
//                } while (per.authenticatePerson(userName, password) == -1 && login_choice != 0);
//
//
//                if (per.authenticatePerson(userName, password) == 1) {
//                    System.out.println("Welcome PASSENGER: " + Person.persons.get(PersonsController.userId).getName());
//                    do {
//                        System.out.println("------------ENTER YOUR CHOICE-------------");
//                        System.out.println("0 - return");
//                        System.out.println("1 - Manage account");
//                        System.out.println("2 - Book a ticket");
//                        System.out.println("3 - Cancel a booking");
//                        System.out.println("4 - Update a booking");
//                        System.out.println("5 - View tickets");
//                        choice = input.nextInt();
//                        input.nextLine();
//                        switch (choice) {
//
//                            case 1:
//                                per.Display();
//                                System.out.println("Update age: ");
//                                num1 = input.nextInt();
//                                input.nextLine();
//                                System.out.println("change password ");
//                                str1 = input.nextLine();
//                                System.out.println("change username ");
//                                str2 = input.nextLine();
//                                System.out.println("update email ");
//                                str3 = input.nextLine();
//
//                                per.updateAccount(num1, str1, str2, str3);
//                                System.out.println(Person.persons.get(PersonsController.userId).getAge());
//                                System.out.println(Person.persons.get(PersonsController.userId).getUsername());
//                                break;
//                            case 2:
//                                System.out.println("-----------TIMING SLOTS-----------");
//                                manage.timingSlots();
//
//                                System.out.println("-----------Available Flights-----------");
//                                manage.displayAllFlight();
//
//                                System.out.println("-----------BOOK FLIGHT-----------");
//
//                                System.out.println("Enter your origin: ");
//                                str1 = input.nextLine();
//                                System.out.println("Enter your destination: ");
//                                str2 = input.nextLine();
//                                System.out.println("Enter the departure time: ");
//                                str3 = input.nextLine();
//                                System.out.println("Enter seat number: ");
//                                num1 = input.nextInt();
//                                input.nextLine();
//                                manage.bookTicket(str1, str2, str3, num1);
//                                System.out.println("Prints the amount of seats this passenger has booked: " + Person.persons.get(PersonsController.userId).getSeats().size());
//                                break;
//                            case 3:
//                                System.out.println("Enter the ID of the seat you want to remove: ");
//                                num1 = input.nextInt();
//                                input.nextLine();
//                                manage.cancelBooking(num1);
//                                System.out.println("Prints the amount of seats this passenger has booked: " + Person.persons.get(PersonsController.userId).getSeats().size());
//                                break;
//                            case 4:
//                                System.out.println("cancel a booking and book a different seat");
//
//                                System.out.println("Enter the ID of your booked seat to remove it: ");
//                                num1 = input.nextInt();
//                                input.nextLine();
//                                System.out.println("Enter the same origin : ");
//                                str1 = input.nextLine();
//                                System.out.println("Enter the same destination: ");
//                                str2 = input.nextLine();
//                                System.out.println("Enter the same departure time: ");
//                                str3 = input.nextLine();
//                                System.out.println("Enter your new seat number: ");
//                                num2 = input.nextInt();
//                                manage.updateBooking(num1, str1, str2, str3, num2);
//                                System.out.println("Prints the amount of seats this passenger has booked: " + Person.persons.get(PersonsController.userId).getSeats().size());
//                                break;
//                            case 5:
//                                manage.viewTickets();
//
//                        }
//                    } while (choice != 0);
//
//                } else if (per.authenticatePerson(userName, password) == 2) {
//                    System.out.println("Welcome ADMIN: " + Person.persons.get(PersonsController.userId).getName());
//                    do {
//                        System.out.println("------------ENTER YOUR CHOICE-------------");
//                        System.out.println("0 - return");
//                        System.out.println("1 - Add a flight");
//                        System.out.println("2 - Remove a flight");
//                        System.out.println("3 - Update a flight");
//                        System.out.println("4 - Generate flight report");
//                        choice = input.nextInt();
//                        input.nextLine();
//                        switch (choice) {
//                            case 1:
//                                System.out.println("Enter Flight a Number for the new flight: ");
//                                str1 = input.nextLine();
//                                System.out.println("Enter the departure location for your flight: ");
//                                str2 = input.nextLine();
//                                System.out.println("Enter the arrival location: ");
//                                str3 = input.nextLine();
//                                System.out.println("Enter the departure time: ");
//                                str4 = input.nextLine();
//                                System.out.println("Enter the arrival time: ");
//                                str5 = input.nextLine();
//                                System.out.println("Enter the status : ");
//                                str6 = input.nextLine();
//                                System.out.println("Enter the origin : ");
//                                str7 = input.nextLine();
//                                System.out.println("Enter the destination : ");
//                                str8 = input.nextLine();
//                                System.out.println("Enter the distance : ");
//                                num1 = input.nextInt();
//                                input.nextLine();
//                                manage.createFlight(str1, str2, str3, str4, str5, str6, str7, str8, num1, seatsForFlightABC24);
//                                index = manage.findFlightByFlightNumber(str1);
//                                System.out.println(manage.getFlights().get(index).getFlightNumber());
//                                System.out.println(manage.getFlights().get(index).getDepartureLocation());
//                                break;
//                            case 2:
//                                manage.displayAllFlight();
//                                System.out.println("Enter the number of the flight you wish to remove");
//                                str1 = input.nextLine();
//                                manage.removeFlight(str1);
//                                manage.displayAllFlight();
//                                break;
//                            case 3:
//                                System.out.println("Enter Flight a Number to update: ");
//                                str1 = input.nextLine();
//                                System.out.println("Enter the departure location to update: ");
//                                str2 = input.nextLine();
//                                System.out.println("Enter the arrival location to update: ");
//                                str3 = input.nextLine();
//                                System.out.println("Enter the departure time to update: ");
//                                str4 = input.nextLine();
//                                System.out.println("Enter the arrival time to update: ");
//                                str5 = input.nextLine();
//                                System.out.println("Enter the status to update: ");
//                                str6 = input.nextLine();
//                                System.out.println("Enter the origin to update: ");
//                                str7 = input.nextLine();
//                                System.out.println("Enter the destination to update: ");
//                                str8 = input.nextLine();
//                                System.out.println("Enter the distance to update: ");
//                                num1 = input.nextInt();
//                                manage.updateFlight(str1, str2, str3, str4, str5, str6, str7, str8, num1);
//                                break;
//                            case 4:
//                                System.out.println("Enter origin ");
//                                str1 = input.nextLine();
//                                System.out.println("Enter destination ");
//                                str2 = input.nextLine();
//                                manage.generateReport(str1, str2);
//                                break;
//                        }
//                    } while (choice != 0);
//                }
//            }
//
//        } while (pick != -1);