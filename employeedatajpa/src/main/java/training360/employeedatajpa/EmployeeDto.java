package training360.employeedatajpa;

import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;

    private String name;

    public EmployeeDto(Employee employee) {
        id = employee.getId();
        name = employee.getName();
    }
}
