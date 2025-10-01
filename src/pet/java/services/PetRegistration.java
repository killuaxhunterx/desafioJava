package pet.java.services;

import pet.java.entities.Address;
import pet.java.entities.Pet;
import pet.java.entities.enums.PetGender;
import pet.java.entities.enums.PetType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PetRegistration {
    private List<Pet> petList = new ArrayList<>();

    public PetRegistration() {
    }

    public PetRegistration(List<Pet> petList) {
        this.petList = petList;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public void registerPet(Pet pet) {
        getPetList().add(pet);
    }

    public void deletePet(Pet pet) {
        getPetList().remove(pet);
    }

    public void registerPet() {
        String name, lastName, petTypeString, petGenderString, city, street, race;
        int houseNumber;
        double weight, years;

        Scanner input = new Scanner(System.in);
        Pet pet = new Pet();
        Address address = new Address();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("src/pet/java/utils/formulario.txt"))) {
                String lines = reader.readLine();
                for (int i = 1; i <= 7; i++) {
                    if (lines != null) {
                        switch (i) {
                            case 1:
                                System.out.println(lines);
                                name = input.nextLine();
                                pet.setName(name);
                                lastName = input.nextLine();
                                pet.setLastName(lastName);
                                lines = reader.readLine();
                                break;
                            case 2:
                                System.out.println(lines);
                                petTypeString = input.nextLine();
                                PetType petType = PetType.valueOf(petTypeString.toUpperCase());
                                pet.setTipoPet(petType);
                                lines = reader.readLine();
                                break;
                            case 3:
                                System.out.println(lines);
                                petGenderString = input.nextLine();
                                PetGender petGender = PetGender.valueOf(petGenderString.toUpperCase());
                                pet.setPetGender(petGender);
                                lines = reader.readLine();
                                break;
                            case 4:
                                System.out.println(lines);
                                houseNumber = input.nextInt();
                                city = input.next();
                                street = input.next();
                                address.setHouseNumber(houseNumber);
                                address.setCity(city);
                                address.setStreet(street);
                                pet.setAddress(address);
                                lines = reader.readLine();
                                break;
                            case 5:
                                System.out.println(lines);
                                years = input.nextInt();
                                pet.setYears(years);
                                lines = reader.readLine();
                                break;
                            case 6:
                                System.out.println(lines);
                                weight = input.nextDouble();
                                pet.setWeight(weight);
                                lines = reader.readLine();
                                break;
                            case 7:
                                System.out.println(lines);
                                race = input.next();
                                pet.setRace(race);
                                break;
                        }
                    }
                }
                getPetList().add(pet);
            }
        } catch (IOException e) {
            System.out.print("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.print("Input error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.print("Argument error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
