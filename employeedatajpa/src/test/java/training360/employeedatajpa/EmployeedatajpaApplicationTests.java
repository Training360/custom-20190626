package training360.employeedatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql("classpath:clear.sql")
public class EmployeedatajpaApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void testSaveThenList() {
		employeeRepository.saveAll(List.of(new Employee("John Doe"),
				new Employee("Jack Doe")));

		var employees = employeeRepository.findAll();
		assertEquals(2, employees.size());
	}

}
