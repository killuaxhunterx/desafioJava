package pet.java.application;

import pet.java.services.MenuService;
import pet.java.repository.PetRepository;
import pet.java.services.PetService;

public class Main {
    public static void main(String[] args) {
        PetRepository petRepository = new PetRepository();
        MenuService menuService = new MenuService(petRepository);
        PetService petService = new PetService(petRepository);
        int choice = menuService.chooseOptionsMenu();
        switch (choice) {
            case 1:
                menuService.readDataPet();
                menuService.registerPet();
                break;
            case 2:
                petService.searchPet();
                break;
        }
    }
}
