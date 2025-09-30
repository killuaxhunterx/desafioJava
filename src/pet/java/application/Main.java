package pet.java.application;

import pet.java.entities.services.Menu;
import pet.java.entities.services.PetRegistration;

public class Main {
    public static void main(String[] args) {
//        int choice = Menu.chooseOptionsMenu();
//        System.out.println(choice);
        PetRegistration petRegistration = new PetRegistration();
        petRegistration.registration();
    }
}
