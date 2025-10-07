import java.util.List;

public class Passenger{
    // Attributes
    private String passportNumber;
    private boolean frequentFlyer;
    private int loyaltyPoints;

    // Constructors
    public Passenger() {
    }

    public Passenger(String passportNumber, boolean frequentFlyer, int loyaltyPoints) {
        this.passportNumber = passportNumber;
        this.frequentFlyer = frequentFlyer;
        this.loyaltyPoints = loyaltyPoints;
    }

    // Getter for passport number
    public String getPassportNumber() {
        return passportNumber;
    }

    // Setter for passport number
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    // Getter for frequent flyer status
    public Boolean getFrequentFlyer() {
        return frequentFlyer;
    }

    // Setter for frequent flyer status
    public void setFrequentFlyer(Boolean frequentFlyer) {
        this.frequentFlyer = frequentFlyer;
    }

    // Getter for loyalty points
    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Setter for loyalty points
    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
