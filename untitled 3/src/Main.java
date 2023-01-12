
import Repository.AnimalRepository;
import Repository.EmployeeRepository;
import Service.Service;
import UI.UI;

public class Main {

    public static void main(String[] args) {
        AnimalRepository animalRepository = new AnimalRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Service service = new Service(animalRepository, employeeRepository);
        UI ui = new UI(service);
        ui.startApp();
    }
}
