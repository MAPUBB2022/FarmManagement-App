package Repository;

import Domain.*;
import Exceptions.RepositoryException;

import java.util.ArrayList;

public class EmployeeRepository {
    private ArrayList<Employee> employees;

    public EmployeeRepository() {
        employees = new ArrayList<>();
    }

    public void addElement(Employee employee) throws RepositoryException {
        boolean checker = checkIfElementExists(employee.getID());
        if (checker == false)
            employees.add(employee);
        else
            throw new RepositoryException("There is already an element with this ID!");
    }

    public Employee getElementbyID(int ID) {
        for (Employee employee : employees) {
            if (employee.getID() == ID)
                return employee;
        }
        return null;
    }

    private boolean checkIfElementExists(int ID) {
        for (Employee employee : employees) {
            if (employee.getID() == ID)
                return true;
        }
        return false;
    }

    public void deleteElement(int ID) throws RepositoryException {
        boolean checker = checkIfElementExists(ID);
        if (checker == true) {
            Employee employee = this.getElementbyID(ID);
            employees.remove(employee);
        } else
            throw new RepositoryException("The element with that ID doesn't exist in Animal Repository!");
    }

    public ArrayList getAllElementsbyName(String name) {
        ArrayList<Employee> nameList = new ArrayList<Employee>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name))
                nameList.add(employee);
        }
        return nameList;
    }

    public ArrayList getElements() {
        return employees;
    }

}
