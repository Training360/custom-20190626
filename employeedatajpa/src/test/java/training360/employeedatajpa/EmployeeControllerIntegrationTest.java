package training360.employeedatajpa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("integration-test")
@SpringBootTest
@Sql("classpath:clear.sql")
public class EmployeeControllerIntegrationTest {

    @Autowired
    EmployeeController employeeController;

    @Test
    void testSaveAndList() {
        employeeController.createEmployee(new CreateEmployeeCommand("John Doe"));
        var employees = employeeController.listEmployees(PageRequest.of(0, 5));
        assertEquals(List.of("John Doe"),
                employees.stream().map(EmployeeDto::getName).collect(Collectors.toList()));
    }
}
