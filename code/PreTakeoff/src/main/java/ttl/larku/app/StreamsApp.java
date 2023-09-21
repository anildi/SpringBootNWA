package ttl.larku.app;

import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author whynot
 */
public class StreamsApp {

    public static void main(String[] args) {
        StreamsApp ma = new StreamsApp();
        ma.filterMapStreams();
    }

    public void filterMapAwkward() {
        StudentService ss = new StudentService();
        StudentDB.initService(ss);

        List<Student> students = ss.getAll();

        List<Student> partTime = filter(students, s -> s.getStatus() == Student.Status.PART_TIME);
        List<String> partTimeNames = map(partTime, Student::getName);
        List<String> partTimeNames2 = map(filter(students, s -> s.getStatus() == Student.Status.PART_TIME),
                Student::getName);

    }

    public void filterMapByHand() {
        StudentService ss = new StudentService();
        StudentDB.initService(ss);

        List<Student> students = ss.getAll();
        List<String> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getStatus() == Student.Status.PART_TIME) {
                result.add(student.getName());
            }
        }

        result.forEach(System.out::println);
    }

    public void filterMapStreams() {
        StudentService ss = new StudentService();
        StudentDB.initService(ss);

        List<Student> students = ss.getAll();

        List<String> partTimeNames = students.stream()
                .peek(s -> System.out.println("In Peek 1 with: " + s))
                .filter(s -> s.getStatus() == Student.Status.PART_TIME)
                .peek(s -> System.out.println("In Peek 2 with: " + s))
                .map(s -> s.getName())
                .peek(s -> System.out.println("In Peek 3 with: " + s))
                .collect(Collectors.toList());

        Set<String> setOfNames = students.stream()
                .peek(s -> System.out.println("In Peek 1 with: " + s))
                .filter(s -> s.getStatus() == Student.Status.PART_TIME)
                .peek(s -> System.out.println("In Peek 2 with: " + s))
                .map(s -> s.getName())
                .peek(s -> System.out.println("In Peek 3 with: " + s))
                .collect(Collectors.toSet());

        var stream1 = students.stream()
                .peek(s -> System.out.println("In Peek 1 with: " + s))
                .filter(s -> s.getStatus() == Student.Status.PART_TIME)
                .peek(s -> System.out.println("In Peek 2 with: " + s))
                .map(s -> s.getName())
                .peek(s -> System.out.println("In Peek 3 with: " + s));

//        partTimeNames.forEach(System.out::println);

    }


    public <T, R> List<R> map(List<T> input, Function<T, R> extractor) {
        List<R> result = new ArrayList<>();
        for (T s : input) {
            result.add(extractor.apply(s));
        }

        return result;
    }

    public <T> List<T> filter(List<T> input, Predicate<T> chooser) {
        List<T> result = new ArrayList<>();
        for (T s : input) {
            if (chooser.test(s)) {
                result.add(s);
            }
        }
        return result;
    }


    public void prettyPrint(Integer arg) {
        System.out.println("[[ " + arg + "]]");
    }

    public Integer mapStringToIntegerInComplicatedWay(String arg) {
        //Go do DB Operations
        //Go talk to a web service
        //Do complicated calculations
        return 42;
    }
}
