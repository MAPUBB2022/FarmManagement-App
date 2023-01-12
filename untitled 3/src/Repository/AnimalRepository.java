package Repository;

import Domain.Animal;
import Domain.Animal;
import Exceptions.RepositoryException;

import java.util.ArrayList;

public class AnimalRepository {
    private ArrayList<Animal> animals;

    public AnimalRepository() {
        animals = new ArrayList<>();
    }

    public void addElement(Animal animal) throws RepositoryException {
        boolean checker = checkIfElementExists(animal.getID());
        if (checker == false)
            animals.add(animal);
        else
            throw new RepositoryException("There is already an element with this ID!");
    }

    private boolean checkIfElementExists(int ID) {
        for (Animal animal : animals) {
            if (animal.getID() == ID)
                return true;
        }
        return false;
    }

    public Animal getElementById(int ID) {
        for (Animal animal : animals) {
            if (animal.getID() == ID)
                return animal;
        }
        return null;
    }

    public void deleteElement(int ID) throws RepositoryException {
        boolean checker = checkIfElementExists(ID);
        if (checker == true) {
            Animal animal = this.getElementById(ID);
            animals.remove(animal);
        } else
            throw new RepositoryException("The element with that ID doesn't exist in Animal Repository!");
    }

    public ArrayList getAllElementsbySpecies(String species) {
        ArrayList<Animal> nameList = new ArrayList<Animal>();
        for (Animal animal : animals) {
            if (animal.getClassName().equals(species))
                nameList.add(animal);
        }
        return nameList;
    }

    public ArrayList getElements() {
        return animals;
    }
}
