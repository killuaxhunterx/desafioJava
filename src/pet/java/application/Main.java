package pet.java.application;

import pet.java.entities.Pet;
import pet.java.entities.services.Menu;
import pet.java.entities.services.PetRegistration;

public class Main {
    public static void main(String[] args) {
        int choice = Menu.chooseOptionsMenu();
        switch (choice) {
            case 1:
                PetRegistration petRegistration = new PetRegistration();
                petRegistration.registerPet();
        }
    }
}
