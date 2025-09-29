package pet.java.entities.services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void showMenu() {
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

    public static int chooseOptionsMenu() {
        int choice;
        Scanner input = new Scanner(System.in);
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
}
