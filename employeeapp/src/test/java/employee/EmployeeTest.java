package employee;

import org.junit.jupiter.api.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@DisplayName("Tests on employee")
public class EmployeeTest {

    Employee employee;

    @BeforeEach
    void init() {
        employee = new Employee("John Doe", 1970);
    }

    @Test
    @DisplayName("Test getting the age of the employee")
    void testGetAge() {
//        // Given
//        var employee = new Employee("John Doe", 1970);
//
//        // When
//        var age = employee.getAge(2019);
//
//        // Then
//        assertEquals(49, age);

        assertEquals(49, employee.getAge(2019), () -> "Ennek 49-nek kell lennie");
    }

    @Test
    void testGetAgeWith2050() {
        assertEquals(80, employee.getAge(2050));
        employee.setYearOfBirth(1960);
    }

    @Nested
    class IllegalArguments {

        @Test
        @Tag("rare")
        @Tag("long-running")
//    @LongRunningTest
//    @VeryBigFeature
        void testYearBefore1900() {
            var iae = assertThrows(IllegalArgumentException.class,
                    () -> new Employee("John Doe", 1800));
            assertEquals("Invalid year: 1800", iae.getMessage());

//        try {
//            var employee = new Employee("John Doe", 1800);
//            fail("Must be exception!");
//        }
//        catch (IllegalArgumentException iae) {
//            assertEquals("Invalid year: 1800", iae.getMessage());
//        }
        }
    }

    @TestFactory
    Stream<DynamicTest> testGetAgeWithLotsOfData() {
        return Stream.of(new Integer[][]{{2000, 0}, {2010, 10}, {2015, 15}, {2050, 50}, {1990, -10}})
                .map(item -> dynamicTest("In year " + item[0] + "must be " + item[1] + "years old",
                        () -> assertEquals((int) item[1], new Employee("John", 2000).getAge(item[0]))));

    }

}
