package pet.java.entities;

public class AddressEntitie {
    private String houseNumber;
    private String city;
    private String street;
    public final String statusHouseNumber = "NAO INFORMADO";

    public AddressEntitie() {
    }

    public AddressEntitie(String houseNumber, String city, String street) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        if (houseNumber == null || houseNumber.contains(String.valueOf(0))) {
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

    public String fullAddress() {
        String fullAddress = getHouseNumber() + getStreet() + getCity();
        return  fullAddress;
    }
}
