package pet.java.services;

import pet.java.entities.PetEntitie;
import pet.java.entities.enums.PetType;
import pet.java.exceptions.PetEntitieNotFoundException;
import pet.java.repository.PetRepository;
import pet.java.utils.FileUtil;
import pet.java.utils.StringUtil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.time.LocalDateTime;
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

    public List<PetEntitie> searchByType() {
        Scanner input = new Scanner(System.in);
        List<PetEntitie> foundPets = new ArrayList<>();
        String petType;
        int i = 1;
        System.out.println("Digite o tipo de pet: (Gato/Cachorro)");
        petType = input.nextLine();
        List<PetEntitie> allPets = petRepository.findAllPets();
        for (PetEntitie pet : allPets) {
            if (pet.getPetType().toString().toUpperCase().contains(petType.toUpperCase())) {
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<PetEntitie> searchPetByNameOrLastName(String nameOrLastName) {
        List<PetEntitie> foundPetsByType = searchByType();
        List<PetEntitie> foundPets = new ArrayList<>();
        int i = 1;
        for (PetEntitie pet : foundPetsByType) {
            if (pet.getName().toUpperCase().contains(nameOrLastName.toUpperCase())) {
                System.out.println(i + " - " + pet);
                i++;
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<PetEntitie> searchPetByYear(double years) {
        List<PetEntitie> foundPetsByType = searchByType();
        List<PetEntitie> foundPets = new ArrayList<>();
        int i = 1;
        for (PetEntitie pet : foundPetsByType) {
            if (pet.getYears() == years) {
                System.out.println(i + " - " + pet);
                i++;
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<PetEntitie> searchPetByWeight(double weight) {
        List<PetEntitie> foundPetsByType = searchByType();
        List<PetEntitie> foundPets = new ArrayList<>();
        int i = 1;
        for (PetEntitie pet : foundPetsByType) {
            if (pet.getWeight() == weight) {
                System.out.println(i + " - " + pet);
                i++;
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<PetEntitie> searchPetByRace(String race) {
        List<PetEntitie> foundPetsByType = searchByType();
        List<PetEntitie> foundPets = new ArrayList<>();
        int i = 1;
        for (PetEntitie pet : foundPetsByType) {
            if (pet.getRace().toUpperCase().contains(race.toUpperCase())) {
                System.out.println(i + " - " + pet);
                i++;
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<PetEntitie> searchPetByGender(String gender) {
        List<PetEntitie> foundPetsByType = searchByType();
        List<PetEntitie> foundPets = new ArrayList<>();
        int i = 1;
        for (PetEntitie pet : foundPetsByType) {
            if (pet.getPetGender().toString().toUpperCase().contains(gender.toUpperCase())) {
                System.out.println(i + " - " + pet);
                foundPets.add(pet);
                i++;
            }
        }
        return foundPets;
    }

    public List<PetEntitie> searchPetByAddress(String address) {
        List<PetEntitie> foundPetsByType = searchByType();
        List<PetEntitie> foundPets = new ArrayList<>();
        int i = 1;
        for (PetEntitie pet : foundPetsByType) {
            if (pet.getAddress().fullAddress().toUpperCase().contains(address.toUpperCase())) {
                System.out.println(i + " - " + pet);
                foundPets.add(pet);
                i++;
            }
        }
        return foundPets;
    }

    public List<PetEntitie> searchPetByNameAndOrLastNameAndYear(String name, String lastName, double year) {
        List<PetEntitie> foundPetsByType = searchByType();
        List<PetEntitie> foundPets = new ArrayList<>();
        int i = 1;
        for (PetEntitie pet : foundPetsByType) {
            if (pet.getName().toUpperCase().contains(name.toUpperCase())
                    || pet.getLastName().toUpperCase().contains(lastName.toUpperCase()) && pet.getYears() == year) {
                System.out.println(i + " - " + pet);
                foundPets.add(pet);
                i++;
            }
        }
        return foundPets;
    }

    public List<PetEntitie> searchPetByWeightAndYear(double weight, double year) {
        List<PetEntitie> foundPetsByType = searchByType();
        List<PetEntitie> foundPets = new ArrayList<>();
        int i = 1;
        for (PetEntitie pet : foundPetsByType) {
            if (pet.getWeight() == weight && pet.getYears() == year) {
                System.out.println(i + " - " + pet);
                foundPets.add(pet);
                i++;
            }
        }
        return foundPets;
    }

    public List<PetEntitie> searchPet(Scanner input) {
        List<PetEntitie> foundPets = new ArrayList<>();
        int choice;
        MenuService menuService = new MenuService(petRepository);
        choice = menuService.chooseOptionsSearchingPetMenu(input);
        switch (choice) {
            case 1:
                System.out.println("Digite o nome ou sobrenome do pet: ");
                input.nextLine();
                setName(input.nextLine());
                return searchPetByNameOrLastName(getName());
            case 2:
                System.out.println("Digite o sexo do pet: ");
                setPetGender(input.nextLine());
                return searchPetByGender(getPetGender());
            case 3:
                System.out.println("Digite a idade do pet: ");
                setYears(input.nextDouble());
                return searchPetByYear(getYears());
            case 4:
                System.out.println("Digite o peso do pet: ");
                setWeight(input.nextDouble());
                return searchPetByWeight(getWeight());
            case 5:
                System.out.println("Digite a raça do pet: ");
                setRace(input.nextLine());
                return searchPetByRace(getRace());
            case 6:
                System.out.println("Digite o endereço do pet: ");
                setAddress(input.nextLine());
                return searchPetByAddress(getAddress());
            case 7:
                System.out.println("Digite o nome e/ou sobrenome e idade do pet: ");
                setName(input.nextLine());
                setLastName(input.nextLine());
                setYears(input.nextDouble());
                return searchPetByNameAndOrLastNameAndYear(getName(), getLastName(), getYears());
            case 8:
                System.out.println("Digite o peso e idade do pet: ");
                setWeight(input.nextDouble());
                setYears(input.nextDouble());
                return searchPetByWeightAndYear(getWeight(), getYears());
        }
        return foundPets;
    }

    public void updatePet(Scanner inputUdpate) throws IOException {
        List<String> lines = new ArrayList<>();
        List<PetEntitie> foundPets = new ArrayList<>();
        FileUtil fileUtil = new FileUtil();
        StringUtil stringUtil = new StringUtil();
        foundPets = searchPet(inputUdpate);
        if (petRepository.files != null) {
            for (File files : petRepository.files) {
                String fileName = files.getName().split("-")[1];
                String fileNameNormalized = stringUtil.normalizeString(fileName);
                for (PetEntitie pet : foundPets) {
                    String petNameNormalized = stringUtil.normalizeString(pet.getName());
                    boolean fileNameContainsPetName = fileNameNormalized.toUpperCase().contains(petNameNormalized.toUpperCase().replaceAll("\\s+", ""));
                    boolean petNameContainsFileName = petNameNormalized.toUpperCase().contains(fileNameNormalized.toUpperCase().replaceAll("\\s+", ""));
                    if (fileNameContainsPetName || petNameContainsFileName) {
                        lines = Files.readAllLines(files.toPath());
                        for (int i = 0; i < lines.size(); i++) {
                            switch (i) {
                                case 0:
                                    assert lines.get(i).contains(pet.getName()) : "False";
                                    System.out.println("Digite o novo nome e sobrenome: ");
                                    String name = inputUdpate.next();
                                    setName(name);
                                    lines.set(i, "1 - " + getName());
                                    break;
                                case 3:
                                    assert lines.get(i).startsWith(pet.getAddress().fullAddress()) : "False";
                                    System.out.println("Digite o novo endereço: ");
                                    inputUdpate.nextLine();
                                    setAddress(inputUdpate.nextLine());
                                    lines.set(i, "4 - " + getAddress());
                                    break;
                                case 4:
                                    assert lines.get(i).startsWith(String.valueOf(pet.getYears())) : "False";
                                    System.out.println("Digite a nova idade: ");
                                    setYears(inputUdpate.nextDouble());
                                    lines.set(i, "5 - " + getYears() + " anos");
                                    break;
                                case 5:
                                    assert lines.get(i).startsWith(String.valueOf(pet.getWeight())) : "False";
                                    System.out.println("Digite o novo peso: ");
                                    setWeight(inputUdpate.nextDouble());
                                    lines.set(i, "6 - " + getWeight() + "kg");
                                    break;
                                case 6:
                                    assert lines.get(i).startsWith(pet.getRace()) : "False";
                                    System.out.println("Digite a nova raça: ");
                                    inputUdpate.nextLine();
                                    setRace(inputUdpate.nextLine());
                                    lines.set(i, "7 - "  + getRace());
                                    break;
                            }
                        }
                        fileUtil.updateContentInFile(files.toPath(), lines);
                        Path oldPath = Paths.get(files.getPath());
                        Path newPath = Paths.get( petRepository.pathToWrite + fileUtil.getPath(getName()));
                        fileUtil.renameFile(oldPath, newPath);
                    }
                }
            }
        }
    }

    public void deletePet(Scanner input) throws IOException{
        List<PetEntitie> pets = new ArrayList<>();
        FileUtil fileUtil = new FileUtil();
        StringUtil stringUtil = new StringUtil();
        String fileName;
        String fileNameNormalized;
        pets = petRepository.findAllPets();
        int i = 1;
        if (petRepository.files != null) {
            for(PetEntitie pet : pets) {
                String petString = i + " - " + pet;
                System.out.println(petString);
                i++;
            }
            i = 1;
            System.out.println("Escolha o número do pet que deseja excluir: ");
            int choice = input.nextInt();
            for (PetEntitie pet : pets) {
                String petString = i + " - " + pet;
                if (petString.startsWith(String.valueOf(choice))) {
                    System.out.println("Entrou: ");
                    for(File files : petRepository.files) {
                        fileName = files.getName().split("-")[1];
                        fileNameNormalized = stringUtil.normalizeString(fileName);
                        String petNameNormalized = stringUtil.normalizeString(pet.getName());
                        boolean fileNameContainsPetName = fileNameNormalized.toUpperCase().contains(petNameNormalized.toUpperCase().replaceAll("\\s+", ""));
                        boolean petNameContainsFileName = petNameNormalized.toUpperCase().contains(fileNameNormalized.toUpperCase().replaceAll("\\s+", ""));
                        System.out.println(petNameNormalized.toUpperCase() + " " + fileNameNormalized);
                        if (fileNameContainsPetName || petNameContainsFileName) {
                            fileUtil.deleteFile(files.toPath());
                            break;
                        }
                    }
                }
                i++;
            }
        }
    }
}
