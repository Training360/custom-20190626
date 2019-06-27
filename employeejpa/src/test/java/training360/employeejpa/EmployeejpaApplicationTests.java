package training360.employeejpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Sql(statements = {"delete from skill", "delete from employee"})
public class EmployeejpaApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void saveThenList() {
		employeeRepository.save(new Employee("Jane Doe"));
		employeeRepository.save(new Employee("Jack Doe"));

		var employees = employeeRepository.listEmployees();

		assertEquals(List.of("Jack Doe", "Jane Doe"),
				employees.stream().map(Employee::getName).collect(Collectors.toList())
				);
	}

	@Test
	public void testUpdate() {
		var employee = new Employee("John Doe");
		employeeRepository.save(employee);

		employeeRepository.updateEmployee(employee.getId(), "Jack Doe");

		var employees = employeeRepository.listEmployees();
		assertEquals(1, employees.size());
		assertEquals("Jack Doe", employees.get(0).getName());
	}

	@Test
	void testSaveSkills() {
		var employee = new Employee("John Doe");
		employee.addAllSkills(List.of(
				new Skill("Java", 5),
				new Skill("JavaScript", 3),
				new Skill("Cobol", 2),
				new Skill("PHP", 10)
				));
		employeeRepository.save(employee);

		var employees = employeeRepository.listEmployees();

		assertTrue(employees.get(0).getSkills().stream().anyMatch(s -> s.getName().equals("Cobol")
				&& s.getLevel() == 2 ));

//		assertTrue(employees.get(0).getSkills().contains("Python"));
	}

	@Test
	void testAddSkills() {
		var employee = new Employee("John Doe");
		employeeRepository.save(employee);

		employeeRepository.addSkills(employee.getId(), List.of(new Skill("Java", 5)));

		var employees = employeeRepository.listEmployees();

		assertEquals("Java", employees.get(0).getSkills().get(0).getName());
	}

}
