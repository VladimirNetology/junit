import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EmployeeTests {
    Employee sut;

    @BeforeEach
    public void initSuite() {
        sut = new Employee("Petrov","Ivan", 30, "M", "School", "Manager", "IT");
    }

    @Test
    public void testEmployee_checkCreateObjects() {
        // given:
        List<Employee> employeeList = new ArrayList<>();
        Employee sut2 = new Employee("Test2","Ivan", 30, "M", "School", "Manager", "IT");
        Employee sut3 = new Employee("Test3","Petya", 40, "M", "School", "Manager", "IT");
        Employee sut4= new Employee("Test4","Vasya", 50, "M", "School", "Manager", "IT");
        employeeList.add(sut);
        employeeList.add(sut2);
        employeeList.add(sut3);
        employeeList.add(sut4);
        final int original = 4;

        // when:
        final int result = employeeList.size();

        // then:
        Assertions.assertEquals(original, result);
    }

    @Test
    public void testEmployee_checkSearchByName() {
        // given
        List<Employee> employeeList = new ArrayList<>();
        Employee sut2 = new Employee("Test2","Ivan", 30, "M", "School", "Manager", "IT");
        Employee sut3 = new Employee("Test3","Petya", 40, "M", "School", "Manager", "IT");
        Employee sut4= new Employee("Test4","Vasya", 50, "M", "School", "Manager", "IT");
        employeeList.add(sut);
        employeeList.add(sut2);
        employeeList.add(sut3);
        employeeList.add(sut4);
        Employee original = sut3;

        // when:
        Employee result = Employee.searchBySurname("Test3", "Petya", employeeList);

        // assert
        Assertions.assertTrue(original.getFistName().equals(result.getFistName()) && original.getLastName().equals(result.getLastName()));
    }

    @Test
    public void testEmployee_exceptionGetWorkerName() {
        // arrange
        int index = 5;
        var expected = ArrayIndexOutOfBoundsException.class;

        // assert
        Assertions.assertThrows(expected,
            // act
            () -> sut.getWorkerName(index));
    }

    @Test
    public void testEmployee_whenConditions_thenCorrect() {
        // arrange:
        List<Employee> employeeList = new ArrayList<>();
        Employee sut2 = new Employee("Namuka","Ivan", 30, "M", "School", "Manager", "IT");
        Employee sut3 = new Employee("Kuibeshovskii","Petya", 40, "M", "School", "Manager", "IT");
        Employee sut4= new Employee("Petrovish","Vasya", 50, "M", "School", "Manager", "Director");
        employeeList.add(sut2);
        employeeList.add(sut3);
        employeeList.add(sut4);
        String startWith = "Namuka";
        String endWith = "Director";

        // act:
        final String result = Employee.listPrint(employeeList);

        // assert:
        assertThat(result, allOf(containsString(startWith), endsWith(endWith)));
    }

    @Test
    public void testEmployee_conditionAge_hamcrest() {
        // arrange
        Employee sut3 = new Employee("Test3","Petya", 40, "M", "School", "Manager", "IT");
        Employee sut4= new Employee("Test4","Vasya", 50, "M", "School", "Manager", "IT");
        int original1 = 12;
        int original2 = 89;
        int minAge = 16;
        int maxAge = 75;

        // act
        sut3.setAge(original1);
        sut4.setAge(original2);
        int result1 = sut3.getAge();
        int result2 = sut4.getAge();

        // assert
        assertThat(result1, allOf(greaterThan(minAge), lessThan(maxAge)));
        assertThat(result2, allOf(greaterThan(minAge), lessThan(maxAge)));
    }

}
