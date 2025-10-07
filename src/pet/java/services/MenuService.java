package pet.java.services;

import pet.java.entities.AddressEntitie;
import pet.java.entities.PetEntitie;
import pet.java.entities.enums.PetGender;
import pet.java.entities.enums.PetType;
import pet.java.repository.PetRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuService {
    private final PetRepository petRepository;

    public MenuService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void showMenu() {
        System.out.println("------ MENU ----");
        System.out.println(
            "1 - Cadastrar um novo pet\n" +
            "2 - Alterar os dados do pet cadastrado\n" +
            "3 - Deletar um pet cadastrado\n" +
            "4 - Listar todos os pets cadastrados\n" +
            "5 - Listar pets por algum critério (idade, nome, raça)\n" +
            "6 - Sair"
        );
    }

    public int chooseOptionsMenu(Scanner input) {
        int choice;
        showMenu();
        choice = input.nextInt();
        try {
            while (choice == 0 || choice < 0) {
                showMenu();
                choice = input.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Input error: " + e.getMessage());
        }
        return choice;
    }

    public void showSearchingPetMenu() {
        System.out.println("------ SEARCHING PET MENU BY ----");
        System.out.println(
            "1 - Nome ou sobrenome\n" +
            "2 - Sexo\n" +
            "3 - Idade\n" +
            "4 - Peso\n" +
            "5 - Raça\n" +
            "6 - Endereço\n" +
            "7 - Nome e/ou sobrenome e idade\n" +
            "8 - Idade e peso"
        );
    }

    public int chooseOptionsSearchingPetMenu(Scanner input) {
        int choice;
        System.out.println("Escolha os criterios para procurar pelo seu pet: ");
        System.out.println("(Digite zero para sair do menu após escolher)");
        showSearchingPetMenu();
        choice = input.nextInt();
        try {
            while (choice != 0) {
                choice = input.nextInt();
                return choice;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return choice;
    }

    public void readDataPet(Scanner input) {
        String name, lastName, petTypeString, petGenderString, city, race, houseNumber, street;
        double weight, years;
        PetEntitie pet = new PetEntitie();
        AddressEntitie address = new AddressEntitie();
        try (BufferedReader reader = petRepository.reader()){
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
                            houseNumber = input.nextLine();
                            city = input.nextLine();
                            street = input.nextLine();
                            address.setHouseNumber(houseNumber);
                            address.setCity(city);
                            address.setStreet(street);
                            pet.setAddress(address);
                            lines = reader.readLine();
                            break;
                        case 5:
                            System.out.println(lines);
                            years = input.nextDouble();
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
            petRepository.getPetList().add(pet);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerPet() {
        petRepository.writeRegisteredPetInFile();
    }

}
