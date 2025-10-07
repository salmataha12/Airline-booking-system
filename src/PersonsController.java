import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonsController {
    public static String Sayed;
    public static int userId;

    public PersonsController() {
    }

    public void addPassenger(String name, int age, String gender, String emil, String nationality, String username, String password, String passportNumber, boolean frequentFlyer, int loyaltyPoints) {

        new Person(name, age, gender, emil, nationality, username, password, "PASSENGER", new Passenger(passportNumber, frequentFlyer, loyaltyPoints), new Admin(), new ArrayList<Seat>());

        System.out.println("-------------------------------------");
        System.out.println("Passenger added");
        System.out.println("-------------------------------------");

    }

    public int authenticatePerson(String username, String password) {

        try {
            for (int i = 0; i < Person.persons.size(); i++) {
                Person person = Person.persons.get(i);
                if (person.getUsername().equals(username) && person.getPassword().equals(password)) {
                    if (person.getType().equals("PASSENGER")) {
                        userId = i;
                        Sayed = person.getName();
                        return 1;
                    } else if (person.getType().equals("ADMIN")) {
                        Sayed = person.getName();
                        userId = i;
                        return 2;
                    }
                }
            }
            return -1;
        } catch (Exception ex) {
            Logger.getLogger(gui_register.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return -1;
    }

    public void updateAccount(int age, String password, String username, String email, String name) throws JsonProcessingException, IOException {
        
        Person person = Person.persons.get(userId);
        
        person.setAge(age);
        person.setPassword(password);
        person.setUsername(username);
        person.setEmil(email);
        person.setName(name);
        Sayed = person.getName();
        String filePath = "src/Database.txt";
        
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(Person.persons);

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(json);
        writer.close();

        System.out.println("Database updated successfully.");

    }

    public void Display() {

        Person person = Person.persons.get(userId);

        System.out.println("---------------Info---------------");
        System.out.println("Header \t\t\t value\n");
        System.out.println("Age:\t\t\t" + " " + person.getAge());
        System.out.println("Name:\t\t\t" + " " + person.getName());
        System.out.println("Loyalty:\t\t" + " " + person.getPassenger().getLoyaltyPoints());
        System.out.println("UserName\t\t" + " " + person.getUsername());
        System.out.println("Password\t\t" + " " + person.getPassword());
        System.out.println("Email:\t\t\t" + " " + person.getEmil());
        System.out.println("passport Number:" + " " + person.getPassenger().getPassportNumber());
        System.out.println("Gender:\t\t\t" + " " + person.getGender());
        System.out.println("Frequent flyer: " + " " + person.getPassenger().getFrequentFlyer());
        System.out.println("----------------------------------");

    }

    public void SplitString(String _user, String _pass) throws IOException {
        String filePath = "src/Database.txt";

        String database = new String(Files.readAllBytes(Paths.get(filePath)));
        String[] db = database.split("\n");

        for (String part : db) {
            String user = part.split("--")[0] + part.split("--")[1];
            System.out.println(user);
            String[] creds = part.split(", --");
            String _username = creds[0].split(",")[0].trim();
            String _password = creds[0].split(",")[1].trim();
            String _type = creds[0].split(",")[2].trim();
            System.out.println(_username + "\t" + _password + "\t" + _type);
            String[] parts = user.split(",\\s*");
            // Split the input string by comma
            // Assign first and last strings
            String firstString = parts[0];
            String lastString = parts[parts.length - 1];
            // Print the individual strings
            System.out.println("First string = " + firstString);
            System.out.println("Last string = " + lastString);
            // Extract the words between two commas
            for (int i = 1; i < parts.length - 1; i++) {
                System.out.println("Word " + i + " = " + parts[i]);
                System.out.println("the parts are length:" + parts.length);
            }
        }

    }

}