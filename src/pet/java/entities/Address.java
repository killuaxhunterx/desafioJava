package pet.java.entities;

public class Address {
    private Integer houseNumber;
    private String city;
    private String street;
    public final String statusHouseNumber = "NAO INFORMADO";

    public Address() {
    }

    public Address(int houseNumber, String city, String street) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        if (houseNumber == null || houseNumber == 0) {
            this.houseNumber = null;
        }
        this.houseNumber = houseNumber;
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
}
