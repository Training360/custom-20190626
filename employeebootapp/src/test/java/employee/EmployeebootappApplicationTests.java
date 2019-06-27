package employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EmployeebootappApplicationTests {

	@Autowired
	EmployeeService employeeService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateThenExits() {
		var created = employeeService.createEmployee("John", 1970);
		assertTrue(created);

		created = employeeService.createEmployee("John", 1980);
		assertFalse(created);
	}

}
