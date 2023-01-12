package Domain;

public class Employee implements Human {

    int salary;
    String name;
    int age;
    String occupation;
    int ID;

    public Employee(int ID, String name, int age, String occupation, int salary) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.salary = salary;
    }

    public String getOccupation() {
        return this.occupation;
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public int getID() {
        return this.ID;
    }

    public void printEmployee() {
        String printingString = "Employee " + name + " aged " + age + " with the occupation of " + occupation + " has salary " + salary + '\n';
        System.out.print(printingString);
    }
}
