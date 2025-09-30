package pet.java.entities;

import pet.java.entities.enums.PetGender;
import pet.java.entities.enums.PetType;

public class Pet {
    private String name;
    private String lastName;
    private PetType tipoPet;
    private PetGender petGender;
    private Address address;
    private int years;
    private double weight;
    private String race;

    public Pet() {
    }

    public Pet(String name, String lastName, PetType tipoPet, PetGender petGender, Address address, int years, double weight, String race) {
        this.name = name;
        this.lastName = lastName;
        this.tipoPet = tipoPet;
        this.petGender = petGender;
        this.address = address;
        this.years = years;
        this.weight = weight;
        this.race = race;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Lastname cannot be empty");
        }
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException{
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public PetType getTipoPet() {
        return tipoPet;
    }

    public void setTipoPet(PetType tipoPet) {
        this.tipoPet = tipoPet;
    }

    public PetGender getPetGender() {
        return petGender;
    }

    public void setPetGender(PetGender petGender) {
        this.petGender = petGender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws IllegalArgumentException {
        if (weight > 60.0 || weight < 0.5) {
            throw new IllegalArgumentException("Weight cannot be more than 60 or less than 0,5 kilos");
        }
        this.weight = weight;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
