package pet.java.application;

import pet.java.services.MenuService;
import pet.java.repository.PetRepository;
import pet.java.services.PetService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PetRepository petRepository = new PetRepository();
        MenuService menuService = new MenuService(petRepository);
        PetService petService = new PetService(petRepository);
        int choice = menuService.chooseOptionsMenu(input);
        switch (choice) {
            case 1:
                menuService.readDataPet(input);
                menuService.registerPet();
                break;
            case 2:
                try {
                    petService.updatePet(input);
                    break;
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            case 4:
                petService.searchPet(input);
                break;
        }
    }
}
