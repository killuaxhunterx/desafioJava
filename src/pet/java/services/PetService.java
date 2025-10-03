package pet.java.services;

import pet.java.entities.PetEntitie;
import pet.java.entities.enums.PetType;
import pet.java.repository.PetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetService {
    private String name;
    private String lastName;
    private PetType petType;
    private String petGender;
    private String address;
    private double years;
    private double weight;
    private String race;
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getYears() {
        return years;
    }

    public void setYears(double year) {
        this.years = year;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public String getPetGender() {
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void searchByType(Scanner input) {
        String petType;
        int i = 1;
        System.out.println("Digite o tipo de pet: (Gato/Cachorro)");
        petType = input.nextLine();
        List<PetEntitie> allPets = petRepository.findAllPets();
        for (PetEntitie pet : allPets) {
            if (pet.getPetType().toString().toUpperCase().contains(petType.toUpperCase())) {
                System.out.println(i + " - " +pet);
                i++;
            }
        }
    }

    public void searchPetByNameOrLastName(String nameOrLastName) {
        List<PetEntitie> allPets = petRepository.findAllPets();
        int i = 1;
        for (PetEntitie pet : allPets) {
            if (pet.getName().toUpperCase().contains(nameOrLastName.toUpperCase())
            ) {
                System.out.println(i + " - " +pet);
                i++;
            }
        }
    }

    public void searchPetByYear(double years) {
        List<PetEntitie> allPets = petRepository.findAllPets();
        int i = 1;
        for (PetEntitie pet : allPets) {
            if (pet.getYears() == years) {
                System.out.println(i + " - " +pet);
                i++;
            }
        }
    }

    public void searchPetByWeight(double weight) {
        List<PetEntitie> allPets = petRepository.findAllPets();
        int i = 1;
        for (PetEntitie pet : allPets) {
            if (pet.getWeight() == weight) {
                System.out.println(i + " - " +pet);
                i++;
            }
        }
    }

    public void searchPetByRace(String race) {
        List<PetEntitie> allPets = petRepository.findAllPets();
        int i = 1;
        for (PetEntitie pet : allPets) {
            if (pet.getRace().toUpperCase().contains(race.toUpperCase())) {
                System.out.println(i + " - " +pet);
                i++;
            }
        }
    }

    public void searchPetByGender(String gender) {
        List<PetEntitie> allPets = petRepository.findAllPets();
        int i = 1;
        for (PetEntitie pet : allPets) {
            if (pet.getPetGender().toString().toUpperCase().contains(gender.toUpperCase())) {
                System.out.println(i + " - " +pet);
                i++;
            }
        }
    }

    public void searchPetByAddress(String address) {
        List<PetEntitie> allPets = petRepository.findAllPets();
        int i = 1;
        for (PetEntitie pet : allPets) {
            if (pet.getAddress().fullAddress().toUpperCase().contains(address.toUpperCase())) {
                System.out.println(i + " - " +pet);
                i++;
            }
        }
    }

    public void searchPetByNameAndOrLastNameAndYear(String name, String lastName, double year) {
        List<PetEntitie> allPets = petRepository.findAllPets();
        int i = 1;
        for (PetEntitie pet : allPets) {
            if (pet.getName().toUpperCase().contains(name.toUpperCase()) && pet.getYears() == year) {
                System.out.println(i + " - " +pet);
                i++;
            }
        }
    }

    public void searchPetByWeightAndYear(double weight, double year) {
        List<PetEntitie> allPets = petRepository.findAllPets();
        int i = 1;
        for (PetEntitie pet : allPets) {
            if (pet.getWeight() == weight && pet.getYears() == year) {
                System.out.println(i + " - " +pet);
                i++;            }

        }
    }

    public void searchPet() {
        List<Integer> parametersChoice = new ArrayList<>();
        MenuService menuService = new MenuService(petRepository);
        parametersChoice = menuService.chooseOptionsSearchingPetMenu();
        try (Scanner input = new Scanner(System.in)) {
            for (int choice : parametersChoice) {
                switch (choice) {
                    case 1:
                        searchByType(input);
                        System.out.println("Digite o nome ou sobrenome do pet: ");
                        setName(input.nextLine());
                        searchPetByNameOrLastName(getName());
                        break;
                    case 2:
                        searchByType(input);
                        System.out.println("Digite o sexo do pet: ");
                        setPetGender(input.nextLine());
                        searchPetByGender(getPetGender());
                        break;
                    case 3:
                        searchByType(input);
                        System.out.println("Digite a idade do pet: ");
                        setYears(input.nextDouble());
                        searchPetByYear(getYears());
                        break;
                    case 4:
                        searchByType(input);
                        System.out.println("Digite o peso do pet: ");
                        setWeight(input.nextDouble());
                        searchPetByWeight(getWeight());
                        break;
                    case 5:
                        searchByType(input);
                        System.out.println("Digite a raça do pet: ");
                        setRace(input.nextLine());
                        searchPetByRace(getRace());
                        break;
                    case 6:
                        searchByType(input);
                        System.out.println("Digite o endereço do pet: ");
                        setAddress(input.nextLine());
                        searchPetByAddress(getAddress());
                        break;
                    case 7:
                        searchByType(input);
                        System.out.println("Digite o nome e/ou sobrenome e idade do pet: ");
                        setName(input.nextLine());
                        setLastName(input.nextLine());
                        setYears(input.nextDouble());
                        searchPetByNameAndOrLastNameAndYear(getName(), getLastName(), getYears());
                        break;
                    case 8:
                        searchByType(input);
                        System.out.println("Digite o peso e idade do pet: ");
                        setWeight(input.nextDouble());
                        setYears(input.nextDouble());
                        searchPetByWeightAndYear(getWeight(), getYears());
                        break;
                }
            }
        }
    }
}
