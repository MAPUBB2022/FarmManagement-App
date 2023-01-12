package UI;

import Exceptions.RepositoryException;
import Exceptions.ValidationException;
import Service.*;
import Domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class AdministratorUI extends UI {
    Scanner scanner = new Scanner(System.in);

    public AdministratorUI(Service service) {
        super(service);
    }


    public void printStartMenuA() {
        System.out.println("1. Animals options");
        System.out.println("2. Employee options");
        System.out.println("3. Exit");

    }

    public void startApp() {
        boolean inApp = true;
        System.out.println("Welcome Administrator\nSelect one of the options below");
        while (inApp) {
            this.printStartMenuA();
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
        System.out.println("1. Add an animal");
        System.out.println("2. Delete an animal");
        System.out.println("3. Print all animals");
        System.out.println("4. Print all animals of a given species");
        System.out.println("5. Go back");
        boolean inApp = true;
        while (inApp) {
            int option = scanner.nextInt();
            if (option == 1) {
                addAnimal();
                break;
            } else if (option == 2) {
                deleteAnimal();
                break;
            } else if (option == 3) {
                printAllAnimals();
                break;
            } else if (option == 4) {
                printAnimalsBySpecies();
            } else if (option == 5)
                inApp = false;
            else
                System.out.println("Give a valid option!");

        }
    }


    private void printEmployeeMenu() {
        System.out.println("1. Add an employee");
        System.out.println("2. Delete an employee");
        System.out.println("3. Print all employee");
        System.out.println("4. Print all employees with a given name");
        System.out.println("5. Print administrator menu");
        System.out.println("6. Go back");
        boolean inApp = true;
        while (inApp) {
            int option = scanner.nextInt();
            if (option == 1) {
                addEmployee();
                break;
            } else if (option == 2) {
                deleteEmployee();
                break;
            } else if (option == 3) {
                printAllEmployees();
                break;
            } else if (option == 4) {
                printEmployeesByName();
            } else if (option == 5) {
                printAdministratorDetails();
            } else if (option == 6)
                inApp = false;
            else
                System.out.println("Give a valid option!");

        }
    }

    private void addAnimal() {
        double weight = 0;
        int ID = 0;
        System.out.println("What type of animal do you want to add?");
        System.out.println("1. Pig");
        System.out.println("2. Cow");
        System.out.println("3. Chicken");
        int command = scanner.nextInt();
        if (command != 1 && command != 2 && command != 3) {
            System.out.println("Give a valid option");
            return;
        }
        System.out.print("Give the ID of the animal: ");
        try {
            ID = scanner.nextInt();
        } catch (Exception exception) {
            System.out.println("Please enter a number!");
            return;
        }
        System.out.print("Give the name of the animal: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Give the colour of the animal: ");
        String colour = scanner.nextLine();
        System.out.print("Give the weight of the animal: ");
        try {
            weight = scanner.nextDouble();
        } catch (Exception exception) {
            System.out.println("Please enter a number!");
            return;
        }
        if (command == 1) {
            try {
                service.addPig(ID, colour, name, weight);
            } catch (ValidationException exception) {
                System.out.println(exception.getMessage());
            } catch (RepositoryException exception) {
                System.out.println(exception.getMessage());
            }
        } else if (command == 2) {
            try {
                service.addChicken(ID, colour, name, weight);
            } catch (ValidationException exception) {
                System.out.println(exception.getMessage());
            } catch (RepositoryException exception) {
                System.out.println(exception.getMessage());
            }

        } else if (command == 3) {
            try {
                service.addCow(ID, colour, name, weight);
            } catch (ValidationException exception) {
                System.out.println(exception.getMessage());
            } catch (RepositoryException exception) {
                System.out.println(exception.getMessage());
            }
        }

    }

    private void printAllAnimals() {
        ArrayList<Animal> animals = service.getAnimals();
        for (Animal animal : animals)
            animal.printAnimal();


    }

    private void deleteAnimal() {
        System.out.print("Give the ID of the animal you want to delete: ");
        int ID = scanner.nextInt();
        try {
            service.deleteAnimal(ID);
        } catch (RepositoryException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void printAnimalsBySpecies() {
        System.out.print("Give the species of the animal(pig, cow, chicken): ");
        scanner.nextLine();
        String species = scanner.nextLine();
        ArrayList<Animal> animals = service.getAnimalsBySpecies(species);
        for (Animal animal : animals)
            animal.printAnimal();

    }

    private void addEmployee() {
        int ID = 0, salary = 0;
        System.out.print("Give the ID of the employee: ");
        try {
            ID = scanner.nextInt();
        } catch (Exception exception) {
            System.out.println("Please enter a number!");
            return;
        }
        System.out.print("Give the name of the employee: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Give the sector of work of the employee: ");
        String occupation = scanner.nextLine();
        System.out.print("Give the age of the employee: ");
        int age = scanner.nextInt();
        System.out.print("Give the salary of the employee: ");
        try {
            salary = scanner.nextInt();
        } catch (Exception exception) {
            System.out.println("Please enter a number!");
            return;
        }
        try {
            service.addEmployee(ID, name, age, occupation, salary);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        } catch (RepositoryException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void deleteEmployee() {
        System.out.print("Give the ID of the employee you want to delete: ");
        int ID = scanner.nextInt();
        try {
            service.deleteEmployee(ID);
        } catch (RepositoryException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void printAllEmployees() {
        ArrayList<Employee> employees = service.getEmployees();
        for (Employee employee : employees)
            employee.printEmployee();

    }

    private void printEmployeesByName() {
        System.out.print("Give the name of employees you want to search: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        ArrayList<Employee> employees = service.getEmployeesByName(name);
        for (Employee employee : employees)
            employee.printEmployee();
    }

    private void printAdministratorDetails() {
        Administrator admin = Administrator.getInstance();
        String adminPrintable = "The administrator name is " + admin.getName() + " aged " + admin.getAge();
        System.out.println(adminPrintable);
    }


}
