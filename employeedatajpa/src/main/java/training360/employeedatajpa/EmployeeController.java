package training360.employeedatajpa;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/api/employees")
    public List<EmployeeDto> listEmployees(Pageable pageable) {
        return employeeService.listEmployees(pageable);
    }

    @PostMapping("/api/employees")
    public EmployeeDto createEmployee(@RequestBody CreateEmployeeCommand command) {
        return employeeService.createEmployee(command);
    }

    @GetMapping("/api/employees/{id}")
    public EmployeeDto findById(@PathVariable long id) {
        return employeeService.findById(id);
    }
}
