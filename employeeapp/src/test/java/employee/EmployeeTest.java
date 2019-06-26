package employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    void testGetAge() {
        // Given
        var employee = new Employee("John Doe", 1970);

        // When
        var age = employee.getAge(2019);

        // Then
        assertEquals(49, age);
    }
}
