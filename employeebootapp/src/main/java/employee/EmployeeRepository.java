package employee;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public void saveEmployee(Employee employee) {
        employees.add(employee);
    }

    public Optional<Employee> findEmployeeByName(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst();
    }
}
