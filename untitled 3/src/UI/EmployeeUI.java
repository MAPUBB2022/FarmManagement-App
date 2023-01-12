package UI;

import Exceptions.RepositoryException;
import Exceptions.ValidationException;
import Service.*;
import Domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeUI extends UI {

    Scanner scanner = new Scanner(System.in);

    public EmployeeUI(Service service) {
        super(service);
    }


    public void printStartMenuE() {
        System.out.println("1. Animals options");
        System.out.println("2. Employee options");
        System.out.println("3. Exit");
    }

    public void startApp() {
        boolean inApp = true;
        System.out.println("Welcome Employee\nSelect one of the options below");
        while (inApp) {
            this.printStartMenuE();
            int option = scanner.nextInt();
            if (option == 1) {
                printAnimalsMenu();
            } else if (option == 2) {
                printEmployeeMenu();
            } else if (option == 3)
                inApp = false;
            else
                System.out.println("Give a valid option!");
        }
    }

    private void printAnimalsMenu() {
        System.out.println("1. Print all animals");
        System.out.println("2. Print all animals of a given species");
        System.out.println("3. Go back");
        boolean inApp = true;
        while (inApp) {
            int option = scanner.nextInt();
            if (option == 1) {
                printAllAnimals();
                break;

            } else if (option == 2) {
                printAnimalsBySpecies();
                break;
            } else if (option == 3)
                inApp = false;
            else
                System.out.println("Give a valid option!");

        }
    }

    private void printEmployeeMenu() {
        System.out.println("1. Print employee data");
        System.out.println("2. Go back");
        boolean inApp = true;
        while (inApp) {
            int option = scanner.nextInt();
            if (option == 1) {
                printEmployeeData();
                break;
            } else if (option == 2)
                inApp = false;
            else
                System.out.println("Give a valid option!");

        }
    }


    private void printAllAnimals() {
        ArrayList<Animal> animals = service.getAnimals();
        for (Animal animal : animals)
            animal.printAnimal();

    }

    private void printEmployeeData() {
        System.out.print("Give the ID of the employee: ");
        scanner.nextLine();
        int ID = scanner.nextInt();
        scanner.nextLine();
        Employee employees = service.getEmployeesByID(ID);
        employees.printEmployee();
    }


    private void printAnimalsBySpecies() {
        System.out.print("Give the species of the animal(pig, cow, chicken): ");
        scanner.nextLine();
        String species = scanner.nextLine();
        ArrayList<Animal> animals = service.getAnimalsBySpecies(species);
        for (Animal animal : animals)
            animal.printAnimal();

    }

}
