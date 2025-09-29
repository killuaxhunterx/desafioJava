package pet.java.application;

import pet.java.entities.services.Menu;

public class Main {
    public static void main(String[] args) {
        int choice = Menu.chooseOptionsMenu();
        System.out.println(choice);
    }
}
