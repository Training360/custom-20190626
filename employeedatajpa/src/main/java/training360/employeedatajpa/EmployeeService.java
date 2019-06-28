package training360.employeedatajpa;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> listEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable)
                .stream().map(EmployeeDto::new)
                .collect(Collectors.toList());
    }

    public EmployeeDto createEmployee(CreateEmployeeCommand command) {
        var employee = new Employee(command.getName());
        employeeRepository.save(employee);
        return new EmployeeDto(employee);
    }

    public EmployeeDto findById(long id) {
        var employee = employeeRepository.findById(id).get();
        return new EmployeeDto(employee);
    }
}
