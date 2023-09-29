package ttl.larku.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author whynot
 */
@ExtendWith(MockitoExtension.class)
public class StudentControllerUnitTest {

    @Mock
    private StudentService studentService;

    @Mock
    private UriCreator uriCreator;

    @InjectMocks
    private StudentController studentController;

    private List<Student> dummyList = List.of(
            new Student("Jake", "282 939 9393",
                    LocalDate.of(2000, 10, 7), Student.Status.FULL_TIME),

            new Student("Sarah", "578585 939 9393",
                    LocalDate.of(969, 10, 7), Student.Status.FULL_TIME)

    );

    @Test
    public void testGetAllStudents() {
        Mockito.when(studentService.getAllStudents()).thenReturn(dummyList);

        List<Student> students = studentController.getAllStudents();

        assertEquals(2, students.size());

        Mockito.verify(studentService).getAllStudents();
    }

    @Test
    public void testGetOneStudentGoodId() {

        Mockito.when(studentService.getStudent(1)).thenReturn(dummyList.get(0));

        ResponseEntity<?> response = studentController.getStudent(1);
        HttpStatusCode status = response.getStatusCode();

        assertEquals(HttpStatus.OK, status);

        Mockito.verify(studentService).getStudent(1);
    }

    @Test
    public void testGetOneStudentBadId() {
        int id = 1000;

        Mockito.when(studentService.getStudent(id)).thenReturn(null);

        ResponseEntity<?> response = studentController.getStudent(id);
        HttpStatusCode status = response.getStatusCode();

        assertEquals(HttpStatus.BAD_REQUEST, status);

        Mockito.verify(studentService).getStudent(id);
    }

    @Test
    public void testAddStudent() throws URISyntaxException {
        Mockito.when(studentService.createStudent(dummyList.get(0))).thenReturn(dummyList.get(0));

        URI fakeURI = new URI("http://localhost:8080/track/0");
        Mockito.when(uriCreator.getURI(0)).thenReturn(fakeURI);

        ResponseEntity<?> response = studentController.addStudent(dummyList.get(0));
        HttpStatusCode status = response.getStatusCode();

        assertEquals(HttpStatus.CREATED, status);

        Mockito.verify(studentService).createStudent(dummyList.get(0));
        Mockito.verify(uriCreator).getURI(0);
    }
}
