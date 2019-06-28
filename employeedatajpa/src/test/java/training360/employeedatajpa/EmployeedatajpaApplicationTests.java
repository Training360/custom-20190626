package training360.employeedatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql("classpath:clear.sql")
public class EmployeedatajpaApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void testSaveThenList() {

		IntStream
				.range(0, 100)
				.mapToObj(i -> "John Doe " + i)
				.map(Employee::new)
				.forEach(e -> employeeRepository.save(e));

		var employees = employeeRepository.findAll();
		assertEquals(100, employees.size());
	}

}
