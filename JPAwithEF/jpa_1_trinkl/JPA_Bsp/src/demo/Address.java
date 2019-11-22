package demo;

import javax.persistence.*;

@Entity
public class Address {
    private String SSN;
    @Id
    private short addressNo;
    private String country;
    private String city;
    private String street;
    private short streetNo;
    @ManyToOne()
    private Person person;


    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public short getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(short addressNo) {
        this.addressNo = addressNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public short getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(short streetNo) {
        this.streetNo = streetNo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
