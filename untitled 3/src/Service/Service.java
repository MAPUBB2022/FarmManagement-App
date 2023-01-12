package Service;

import Exceptions.RepositoryException;
import Exceptions.ValidationException;
import Repository.*;
import Domain.*;

import Repository.AnimalRepository;
import Validators.AnimalValidator;
import Validators.EmployeeValidator;

import java.util.ArrayList;

public class Service {
    private AnimalRepository aRepo;
    private EmployeeRepository eRepo;

    public Service(AnimalRepository repositoryAnimals, EmployeeRepository repositoryEmployees) {
        this.aRepo = repositoryAnimals;
        this.eRepo = repositoryEmployees;
    }

    public void addCow(int ID, String colour, String name, double weight) throws RepositoryException, ValidationException {
        Cow cow = new Cow(ID, colour, name, weight);
        try {
            AnimalValidator.validate(cow);
            aRepo.addElement(cow);
        } catch (ValidationException exception) {
            throw exception;
        } catch (RepositoryException exception) {
            throw exception;
        }

    }

    public void addPig(int ID, String colour, String name, double weight) throws RepositoryException, ValidationException {
        Pig pig = new Pig(ID, colour, name, weight);
        try {
            AnimalValidator.validate(pig);
            aRepo.addElement(pig);
        } catch (ValidationException exception) {
            throw exception;
        } catch (RepositoryException exception) {
            throw exception;
        }
    }

    public void addChicken(int ID, String colour, String name, double weight) throws RepositoryException, ValidationException {
        Chicken chicken = new Chicken(ID, colour, name, weight);
        try {
            AnimalValidator.validate(chicken);
            aRepo.addElement(chicken);
        } catch (ValidationException exception) {
            throw exception;
        } catch (RepositoryException exception) {
            throw exception;
        }
    }

    public void addEmployee(int ID, String name, int age, String occupation, int salary) throws RepositoryException, ValidationException {
        Employee employee = new Employee(ID, name, age, occupation, salary);
        try {
            EmployeeValidator.validate(employee);
            eRepo.addElement(employee);
        } catch (ValidationException exception) {
            throw exception;
        } catch (RepositoryException exception) {
            throw exception;
        }
    }

    public void deleteAnimal(int ID) throws RepositoryException {
        try {
            aRepo.deleteElement(ID);
        } catch (RepositoryException exception) {
            throw exception;
        }
    }

    public void deleteEmployee(int ID) throws RepositoryException {
        try {
            eRepo.deleteElement(ID);
        } catch (RepositoryException exception) {
            throw exception;
        }
    }

    public ArrayList<Animal> getAnimals() {
        return aRepo.getElements();
    }

    public ArrayList<Employee> getEmployees() {
        return eRepo.getElements();
    }

    public ArrayList<Animal> getAnimalsBySpecies(String species) {
        return aRepo.getAllElementsbySpecies(species);
    }

    public ArrayList<Employee> getEmployeesByName(String name) {
        return eRepo.getAllElementsbyName(name);
    }

    public Employee getEmployeesByID(int ID) {
        return eRepo.getElementbyID(ID);
    }


}
