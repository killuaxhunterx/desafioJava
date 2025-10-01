package pet.java.services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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

    public static void showSearchingPetMenu() {
        System.out.println("------ SEARCHING PET MENU BY ----");
        System.out.println(
            "1 - Nome ou sobrenome\n" +
            "2 - Sexo\n" +
            "3 - Idade\n" +
            "4 - Peso\n" +
            "5 - Raça\n" +
            "6 - Endereço\n" +
            "7 - Nome e/ou sobrenome e idade\n" +
            "8 - Idade e peso"
        );
    }

    public static List<Integer> chooseOptionsSearchingPetMenu() {
        int choice;
        List<Integer> choicesList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha os criterios para procurar pelo seu pet: ");
        System.out.print("(Digite zero para sair do menu após escolher)");
        showSearchingPetMenu();
        choice = input.nextInt();
        choicesList.add(choice);
        try {
            while (choice != 0) {
                showSearchingPetMenu();
                choice = input.nextInt();
                choicesList.add(choice);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return choicesList;
    }
}
