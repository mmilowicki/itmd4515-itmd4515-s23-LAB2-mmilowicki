import edu.iit.sat.itmd4515.mmilowicki.Employee;

import java.time.LocalDate;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author maciej milowicki
 */
public class EmployeeValidationTest {

    public static Validator validator;

    /**
     * Get the validator from the validation package one time, at class
     * initialization before any test methods fire
     *
     */
    @BeforeAll
    public static void beforeAll() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @BeforeEach
    public void beforeEach() {
    }

    @Test
    public void employeeIsValid() {
        // first, create some data with which to test
        Employee e = new Employee(4, "Test", "Test ", "Test", "3", LocalDate.of(1947, 9, 19), LocalDate.of(2022, 4, 1), "Test", "Test", 12345, "Test", "Test");

        Set<ConstraintViolation<Employee>> violations = validator.validate(e);

        for (ConstraintViolation<Employee> violation : violations) {
            // I can use System.out.print line to help me with debugging
            System.out.println(violation.toString());
        }   
        assertEquals(0, violations.size());
    }

    @Test
    public void employeeIsInValid_malformedPostalCode() {
        // create data that is going to violate the constraints
        Employee e = new Employee(10, "Test", "Test ", "Test", "3", LocalDate.of(1947, 9, 19), LocalDate.of(2022, 4, 1), "Test", "Test", 1234-521, "Test", "");

        Set<ConstraintViolation<Employee>> violations = validator.validate(e);

        for (ConstraintViolation<Employee> violation : violations) {
            System.out.println(violation.toString());

        }
        // Should fail validation, but the test case itself passes 
        // because I wrote the postal code with more than 5 digits plus, I included a dash
        assertEquals(1, violations.size());

    }

    @AfterAll
    public static void afterAll() {
    }

    @AfterEach
    public void afterEach() {
    }

}
