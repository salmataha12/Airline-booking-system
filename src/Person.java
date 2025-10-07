import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private String gender;
    private String emil;
    private String nationality;
    private String username;
    private String password;
    private String type;

    public static List<Person> persons = new ArrayList<>();
    
    private Passenger passenger;
    private Admin admin;
    private List<Seat> seats;

    public Person() {
    }
    
    public Person(String name, int age, String gender, String emil, String nationality, String username, String password, String type, Passenger passenger, Admin admin, List<Seat> seats) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.emil = emil;
        this.nationality = nationality;
        this.username = username;
        this.password = password;
        this.type = type;
        this.passenger = passenger;
        this.admin = admin;
        this.seats = seats;

        persons.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}