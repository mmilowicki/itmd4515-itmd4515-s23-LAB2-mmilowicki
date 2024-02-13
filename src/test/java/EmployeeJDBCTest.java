
import edu.iit.sat.itmd4515.mmilowicki.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
public class EmployeeJDBCTest {

    private Connection con;

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/northwind?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "itmd4515";
        String password = "itmd4515";

        return DriverManager.getConnection(url, username, password);
    }

    private void createAnEmployee(Employee e) throws SQLException {
        // Here I need to put in the fields from my table
        String query = "INSERT into employee "
                + "(employeeId, lastname, firstname, title, titleOfCourtesy, birthDate, hireDate, address, city, postalCode, country, phone)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try ( PreparedStatement ps = con.prepareStatement(query);) {

            ps.setInt(1, e.getId());
            ps.setString(2, e.getLast_name());
            ps.setString(3, e.getFirst_name());
            ps.setString(4, e.getTitle());
            ps.setString(5, e.getTitleOfCourtesy());
            ps.setObject(6, e.getBirthDate());
            ps.setObject(7, e.getHireDate());
            ps.setString(8, e.getAddress());
            ps.setString(9, e.getCity());
            ps.setInt(10, e.getPostalCode());
            ps.setString(11, e.getCountry());
            ps.setString(12, e.getPhone());

            ps.executeUpdate();
        }
    }

    private void updateAnEmployee(Employee e) throws SQLException {
        // Here I need to put in the fields from my table
        // Use table names, not Java property names
        String query = "UPDATE employee set "
                + "lastname = ? ,"
                + "firstname = ?,"
                + "title = ?,"
                + "titleOfCourtesy = ?,"
                + "birthDate = ?,"
                + "hireDate = ?,"
                + "address = ?,"
                + "city = ?,"
                + "postalCode = ?,"
                + "country = ?,"
                // for this last one, I don't want comma at the end
                + "phone = ? "
                + "where employeeId = ?";

        try ( PreparedStatement ps = con.prepareStatement(query);) {

            
            ps.setString(1, e.getLast_name());
            ps.setString(2, e.getFirst_name());
            ps.setString(3, e.getTitle());
            ps.setString(4, e.getTitleOfCourtesy());
            ps.setObject(5, e.getBirthDate());
            ps.setObject(6, e.getHireDate());
            ps.setString(7, e.getAddress());
            ps.setString(8, e.getCity());
            ps.setInt(9, e.getPostalCode());
            ps.setString(10, e.getCountry());
            ps.setString(11, e.getPhone());
            ps.setInt(12, e.getId());

            ps.executeUpdate();
        }
    }

    private Employee findAnEmployee(int id) throws SQLException {
        String query = "SELECT * from employee where employeeId = ?";

        Employee e = null;

        // how to build a domain object from the resultset - old school style
        try ( PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e = new Employee();
                e.setId(rs.getInt("employeeId"));
                e.setFirst_name(rs.getString("firstname"));
                e.setLast_name(rs.getString("lastname"));
                e.setTitle(rs.getString("title"));
                e.setTitleOfCourtesy(rs.getString("titleOfCourtesy"));
                e.setBirthDate(rs.getObject("birthDate", LocalDate.class));
                e.setHireDate(rs.getObject("hireDate", LocalDate.class));
                e.setAddress(rs.getString("address"));
                e.setCity(rs.getString("city"));
                e.setPostalCode(rs.getInt("postalCode"));
                e.setCountry(rs.getString("country"));
                e.setPhone(rs.getString("phone"));
            }
        }
        // if nothing found in database, null is returned
        return e;
    }

    private void deleteAnEmployee(Integer id) throws SQLException {
        String query = "DELETE from employee where employeeId = ?";
        try ( PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        }
    }

    @BeforeAll
    public static void beforeAll() {
    }

    @BeforeEach
    public void beforeEach() throws SQLException {
        con = getConnection();
        
        // could absolultely consider inserting a 999-style test row here
        //If you do, just make sure to delete it in afterEach
        
        // whatever you do in beforeEach you need to do in afterEach
    }

    @Test
    public void createTest() throws SQLException {
        // 1. Create an employee with which to test
        Employee e = new Employee(10, "Test", "Test ", "Test", "3", LocalDate.of(1947, 9, 19), LocalDate.of(2022, 4, 1), "Test", "Test", 12345, "Test", "Test");
        createAnEmployee(e);

        // 2. Read employee back from database
        // Note: there is no employee 10
        Employee readBackFromDatabase = findAnEmployee(10);

        // 3.Assert that what's been read back matches what I've created
        assertEquals(e.getId(), readBackFromDatabase.getId());

        // 4. Delete what's been created
        deleteAnEmployee(10);

    }

    @Test
    public void readTest() throws SQLException {
        // 1.Read an employee back from the database
        Employee readBackFromDatabase = findAnEmployee(3);
        
        // 2.Assert that what's been read back matches what I've created and wht I expect
        assertNotNull(readBackFromDatabase);
        assertEquals("Sales Manager", readBackFromDatabase.getTitle());
    }

    @Test
    public void updateTest() throws SQLException {
        // 1. Create an employee with which to test
        Employee e = new Employee(10, "Test", "Test ", "Test", "3", LocalDate.of(1947, 9, 19), LocalDate.of(2022, 4, 1), "Test", "Test", 12345, "Test", "Test");
        createAnEmployee(e);
        
        // 2. Update some properties of that employee and save to the database
        e.setFirst_name("fNewName");
        e.setLast_name("lNewName");
        updateAnEmployee(e);
        
        // 3. Read the employee back from the database
        Employee readBackFromDatabase = findAnEmployee(10);
        
        // 4. Assert that what reads back matches the changes I've made
        assertEquals("fNewName", readBackFromDatabase.getFirst_name());
        assertEquals("lNewName", readBackFromDatabase.getLast_name());
         
        // 5. Clean-up what's been modified - (WE ARE NOT TRYING TO
        // MAKE ANY LASTING CHANGES TO THE DATABASE.) These are just test cases.
        deleteAnEmployee(10);

    }

    @Test
    public void deleteTest() throws SQLException {
        // 1. Create an employee with which to test
         Employee e = new Employee(10, "Test", "Test ", "Test", "3", LocalDate.of(1947, 9, 19), LocalDate.of(2022, 4, 1), "Test", "Test", 12345, "Test", "Test");
        createAnEmployee(e);
        
        // 2. Delete employee
        deleteAnEmployee(10);
        
        // 3. Try and read employee back from database
        Employee readBackFromDatabase = findAnEmployee(10);
        
        // 4. Assert the cutomer has been deleted
        assertNull(readBackFromDatabase);
    }

    @AfterEach
    public void afterEach() throws SQLException {
        deleteAnEmployee(10);
        con.close();
    }

    @AfterAll
    public static void afterAll() {
    }
}
