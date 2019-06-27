package employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean createEmployee(String name, int yearOfBirth) {
        name = name.trim();
        var employee = employeeRepository.findEmployeeByName(name);
        if (employee.isPresent()) {
            return false;
        }
        else {
            employeeRepository.saveEmployee(new Employee(name, yearOfBirth));
            return true;
        }
    }
}
