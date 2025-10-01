package pet.java.application;

import pet.java.services.Menu;
import pet.java.services.PetRegistration;

public class Main {
    public static void main(String[] args) {
        int choice = Menu.chooseOptionsMenu();
        switch (choice) {
            case 1:
                PetRegistration petRegistration = new PetRegistration();
                petRegistration.registerPet();
                petRegistration.writeRegisteredPetInFile();
                break;
            case 2:
                Menu.chooseOptionsSearchingPetMenu();
        }
    }
}
