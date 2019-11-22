package demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Person {
    @Id
    private String SSN;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private boolean isAwesome;
    private Double awesomeness;
    private BigDecimal wealth;

    public String getsSSN() {
        return SSN;
    }

    public void setsSSN(String sSN) {
        this.SSN = sSN;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public Double getAwesomeness() {
        return awesomeness;
    }

    public void setAwesomeness(Double awesomeness) {
        this.awesomeness = awesomeness;
    }

    public BigDecimal getWealth() {
        return wealth;
    }

    public void setWealth(BigDecimal wealth) {
        this.wealth = wealth;
    }
}
