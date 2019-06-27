package employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository repo;

    @InjectMocks
    EmployeeService service;

    @Test
    void testSaveEmployee() {
        // Given
        when(repo.findEmployeeByName(anyString())).thenReturn(Optional.empty());

        // When
        var created = service.createEmployee("        Jack          ", 1970);
        assertTrue(created);

        // Assert
        var employee = ArgumentCaptor.forClass(Employee.class);
        verify(repo).saveEmployee(employee.capture());

        assertEquals("Jack", employee.getValue().getName());
        assertEquals(1970, employee.getValue().getYearOfBirth());
    }

    @Test
    void testExistingEmployee() {
        when(repo.findEmployeeByName(anyString()))
                .thenReturn(Optional.of(new Employee("John", 1970)));

        var created = service.createEmployee("John", 1970);
        assertFalse(created);

        verify(repo, never()).saveEmployee(any());
    }
}
