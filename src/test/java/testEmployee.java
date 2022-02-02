import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AnyOf.anyOf;

public class testEmployee {
    Employee sut;

    @BeforeEach
    public void initSuite() {
        sut = new Employee("Petrov","Ivan", 30, "M", "School", "Manager", "IT");
    }

    @Test
    public void testEmployee_containAge() {
        // given:
        final int original = 30;

        // when:
        final int result = sut.getAge();

        // then:
        Assertions.assertEquals(original, result);
    }

    @Test
    public void testEmployee_conditionAge() {
        // arrange
        int startAge = 16;
        int stopAge = 80;

        // assert
        Assertions.assertTrue(
                // act
                () -> sut.getAge() > startAge && sut.getAge() < stopAge);
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
        String startWith = "Pe";
        String endWith = "ov";

        // act:
        final String result = sut.getLastName();

        // assert:
        assertThat(result, anyOf(containsString("Pe"), endsWith("ov")));
    }

    @Test
    public void testEmployee_conditionAge_hamcrest() {
        // arrange
        int startAge = 16;
        int stopAge = 80;

        // act
        int result = sut.getAge();

        // assert
        assertThat(result, allOf(greaterThan(startAge), lessThan(stopAge)));
    }

}
