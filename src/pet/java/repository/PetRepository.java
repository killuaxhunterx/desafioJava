package pet.java.repository;

import pet.java.entities.AddressEntitie;
import pet.java.entities.PetEntitie;
import pet.java.entities.enums.PetGender;
import pet.java.entities.enums.PetType;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class PetRepository {
    private List<PetEntitie> petList = new ArrayList<>();
    public final String pathToWrite = "/home/arthur/IdeaProjects/Desafio/petsCadastrados/";
    public final String pathToRead = "src/pet/java/repository/formulario.txt";
    public final File path = new File(pathToWrite);
    public final File[] files = path.listFiles(File::isFile);

    public PetRepository() {
    }

    public PetRepository(List<PetEntitie> petList) {
        this.petList = petList;
    }

    public List<PetEntitie> getPetList() {
        return petList;
    }

    public void setPetList(List<PetEntitie> petList) {
        this.petList = petList;
    }

    public void registerPet(PetEntitie pet) {
        getPetList().add(pet);
    }

    public void deletePet(PetEntitie pet) {
        getPetList().remove(pet);
    }

    public BufferedReader readFile() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(pathToRead));
        return reader;
    }

    public BufferedWriter writeFile(String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathToWrite + path));
        return writer;
    }

    public void writeRegisteredPetInFile() {
        String path = "";

        LocalDateTime timeNow = LocalDateTime.now();
        for (PetEntitie pet : getPetList()) {
            path = String.valueOf(
                timeNow.getYear()) +
                String.valueOf(timeNow.getMonth().getValue()) + String.valueOf(timeNow.getDayOfMonth() +
                "T" + String.valueOf(timeNow.getHour()) + String.valueOf(timeNow.getMinute()) +
                "-" + pet.getName()
                + pet.getLastName().replaceAll("\\s", "")
            );
            try (BufferedWriter bufferedWriter = writeFile(path)) {
                bufferedWriter.write(1 + " - " + pet.getName() + " " + pet.getLastName());
                bufferedWriter.newLine();
                bufferedWriter.write(2 + " - " + pet.getPetType());
                bufferedWriter.newLine();
                bufferedWriter.write(3 + " - " + pet.getPetGender());
                bufferedWriter.newLine();
                bufferedWriter.write(4 + " - Rua " + pet.getAddress().getStreet() + ", " + pet.getAddress().getHouseNumber() + ", " + pet.getAddress().getCity());
                bufferedWriter.newLine();
                bufferedWriter.write(5 + " - " + pet.getYears() + " anos");
                bufferedWriter.newLine();
                bufferedWriter.write(6 + " - " + pet.getWeight() + "kg");
                bufferedWriter.newLine();
                bufferedWriter.write(7 + " - " + pet.getRace());
            } catch (IOException e) {
                System.out.print("Error: " + e.getMessage());
            }
        }
    }

    public List<PetEntitie> findAllPets() {
        String lines = "";
        List<PetEntitie> allPets = new ArrayList<>();
        int j = 1;
        if (files != null) {
            for (File file : files) {
                PetEntitie petEntitie = new PetEntitie();
                AddressEntitie addressEntitie = new AddressEntitie();
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                    lines = bufferedReader.readLine();
                    for (int i = 0; i <= 7 && lines != null; i++) {
                        switch (i) {
                            case 1:
                                petEntitie.setName(lines.replaceFirst("\\d+ - ", ""));
                                lines = bufferedReader.readLine();
                                break;
                            case 2:
                                petEntitie.setTipoPet(PetType.valueOf(lines.replaceFirst("\\d+ - ", "")));
                                lines = bufferedReader.readLine();
                                break;
                            case 3:
                                petEntitie.setPetGender(PetGender.valueOf(lines.replaceFirst("\\d+ - ", "")));
                                lines = bufferedReader.readLine();
                                break;
                            case 4:
                                String [] addressString = lines.split(",");
                                addressEntitie.setHouseNumber(addressString[0]);
                                addressEntitie.setStreet(addressString[1]);
                                addressEntitie.setCity(addressString[2]);
                                petEntitie.setAddress(addressEntitie);
                                lines = bufferedReader.readLine();
                                break;
                            case 5:
                                lines = lines.replaceFirst("\\d+ - ", "");
                                lines = lines.replaceFirst("anos", "");
                                petEntitie.setYears(Double.valueOf(lines));
                                lines = bufferedReader.readLine();
                                break;
                            case 6:
                                lines = lines.replaceFirst("\\d+ - ", "");
                                lines = lines.replaceFirst("kg", "");
                                petEntitie.setWeight(Double.valueOf(lines));
                                lines = bufferedReader.readLine();
                                break;
                            case 7:
                                lines = lines.replaceFirst("\\d+ - ", "");
                                petEntitie.setRace(lines);
                                lines = bufferedReader.readLine();
                                break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                allPets.add(petEntitie);
            }
        }
        return allPets;
    }

}
