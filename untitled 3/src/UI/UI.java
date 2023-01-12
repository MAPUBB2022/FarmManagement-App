package UI;

import Exceptions.RepositoryException;
import Exceptions.ValidationException;
import Service.*;
import Domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    Service service;
    Scanner scanner = new Scanner(System.in);

    public UI(Service service) {
        this.service = service;
    }


    private void printStartMenu() {
        System.out.println("1. Administrator options");
        System.out.println("2. Employee options");
        System.out.println("3. Exit");
    }

    public void startApp() {
        boolean inApp = true;
        System.out.println("Welcome to the farm management app!\nSelect one of the options below");
        while (inApp) {
            this.printStartMenu();
            int option = scanner.nextInt();
            if (option == 1) {
                AdministratorUI AU = new AdministratorUI(service);
                AU.startApp();
            } else if (option == 2) {
                EmployeeUI EU = new EmployeeUI(service);
                EU.startApp();
            } else if (option == 3)
                inApp = false;
            else
                System.out.println("Give a valid option!");
        }
    }


}
