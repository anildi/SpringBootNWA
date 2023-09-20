package ttl.larku.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author whynot
 */
public class TestStudent {

    @Test
    public void testSimpleStudent() {
        Student student = new Student("Alex", LocalDate.of(1990, 2, 5), Student.Status.HIBERNATING);

//        System.out.println("student name: " + student.getName());

        assertEquals("Alex", student.getName());

        assertEquals(0, student.getId());

    }

}
