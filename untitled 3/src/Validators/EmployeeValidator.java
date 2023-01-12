package Validators;

import Domain.Employee;
import Exceptions.ValidationException;

public class EmployeeValidator {
    public static void validate(Employee employee) throws ValidationException {
        String errors = "";
        if (employee.getName().length() <= 3)
            errors += "Name must have at least 3 letters!\n";
        if (employee.getAge() < 18 || employee.getAge() > 75)
            errors += "Age must be between 18 and 75\n";
        if (employee.getOccupation().length() <= 3)
            errors += "Occupation must have at least 3 letters!\n";
        if (employee.getSalary() < 1300)
            errors += "Salary must be greater than 1300!\n";

        if (!errors.isEmpty())
            throw new ValidationException(errors);

    }
}
