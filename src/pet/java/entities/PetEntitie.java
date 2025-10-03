package pet.java.entities;

import pet.java.entities.enums.PetGender;
import pet.java.entities.enums.PetType;

public class PetEntitie {
    private String name;
    private String lastName;
    private PetType petType;
    private PetGender petGender;
    private AddressEntitie address;
    private double years;
    private double weight;
    private String race;

    public PetEntitie() {
    }

    public PetEntitie(String name, String lastName, PetType petType, PetGender petGender, AddressEntitie address, double years, double weight, String race) {
        this.name = name;
        this.lastName = lastName;
        this.petType = petType;
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
        if (!lastName.matches("[a-zA-z0-9 ]*")) {
            throw new IllegalArgumentException("Last name cannot contain special characters");
        }
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (!name.matches("[a-zA-Z0-9 ]*")) {
            throw new IllegalArgumentException("Name cannot contain special characters");
        }
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setTipoPet(PetType petType) {
        this.petType = petType;
    }

    public PetGender getPetGender() {
        return petGender;
    }

    public void setPetGender(PetGender petGender) {
        this.petGender = petGender;
    }

    public AddressEntitie getAddress() {
        return address;
    }

    public void setAddress(AddressEntitie address) {
        this.address = address;
    }

    public double getYears() {
        return years;
    }

    public void setYears(double years) throws IllegalArgumentException {
        if (years > 20) {
            throw new IllegalArgumentException("Years cannot be more than 20");
        }
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

    public void setRace(String race) throws IllegalArgumentException {
        if (!race.matches("[a-zA-z0-9 ]*")) {
            throw new IllegalArgumentException("Name cannot contain special characters");
        }
        this.race = race;
    }

    public void fullName() {
        String fullName = getName() + getLastName();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getName()).append(" - ");
        stringBuilder.append(getPetType().toString()).append(" - ");
        stringBuilder.append(getPetGender().toString()).append(" - ");
        stringBuilder.append(getAddress().getStreet()).append(" - ");
        stringBuilder.append(getAddress().getHouseNumber()).append(" - ");
        stringBuilder.append(getAddress().getCity()).append(" - ");
        stringBuilder.append(getYears()).append(" anos").append(" - ");
        stringBuilder.append(getWeight()).append("kg").append(" - ");
        stringBuilder.append(getRace());
        return stringBuilder.toString();
    }
}