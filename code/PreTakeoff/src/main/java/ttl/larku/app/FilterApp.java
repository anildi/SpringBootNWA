package ttl.larku.app;

import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author whynot
 */
public class FilterApp {

    public static void main(String[] args) {
        FilterApp fa = new FilterApp();
        //fa.badFilter();
        fa.betterFilter();
    }

    public void badFilter() {
        StudentService ss = new StudentService();
        StudentDB.initService(ss);

        List<Student> students = ss.getAll();


        List<Student> result1 = startsWithM(students, "M");
        for(Student s : result1) {
            System.out.println(s);
        }
    }

    public void betterFilter() {
        StudentService ss = new StudentService();
        StudentDB.initService(ss);

        List<Student> students = ss.getAll();
        StartsWithChooser swc = new StartsWithChooser();
        Chooser chooser1 = new Chooser() {
            @Override
            public boolean choose(Student student) {
                return student.getName().startsWith("M");
            }
        };

        Chooser chooser2 = (Student student) -> {
                return student.getName().startsWith("M");
            };

        Chooser chooser3 = (student) -> {
            return student.getName().startsWith("M");
        };

        Chooser chooser4 = (student) -> student.getName().startsWith("M");

        Chooser chooser5 = student -> student.getName().startsWith("M");

        List<Student> result1 = soSoChooser(students, chooser5);

        List<Student> fullTime = soSoChooser(students, s -> s.getStatus() == Student.Status.FULL_TIME);

        for(Student s : fullTime) {
            System.out.println(s);
        }

        List<String> strings = List.of("one", "two", "threeee");
        StrLengthChooser slc = new StrLengthChooser();
        StatusChooser statusChooser = new StatusChooser();
        List<String> lresult = betterChooser(strings, slc);

    }

    public void evenBetterFilter() {
        StudentService ss = new StudentService();
        StudentDB.initService(ss);

        List<Student> students = ss.getAll();

        List<Student> partTime = bestChooser(students, s -> s.getStatus() == Student.Status.PART_TIME);


        List<String> strings = List.of("one", "two", "threeee");
        List<String> lenghtGt3 = bestChooser(strings, s -> s.length() > 3);

    }

    public <T> List<T> bestChooser(List<T> input, Predicate<T> chooser) {
        List<T> result = new ArrayList<>();
        for(T s : input) {
            if(chooser.test(s)) {
                result.add(s);
            }
        }
        return result;
    }

    @FunctionalInterface
    interface GenericChooser<T> {
        boolean choose(T t);
    }

    public <T> List<T> betterChooser(List<T> input, GenericChooser<T> chooser) {
        List<T> result = new ArrayList<>();
        for(T s : input) {
            if(chooser.choose(s)) {
                result.add(s);
            }
        }
        return result;
    }

    class StatusChooser implements GenericChooser<Student> {

        @Override
        public boolean choose(Student student) {
            return false;
        }
    }

    class StrLengthChooser implements GenericChooser<String> {

        @Override
        public boolean choose(String str) {
            return str.length() > 3;
        }
    }

    interface Chooser {
        boolean choose(Student student);
    }

    public List<Student> soSoChooser(List<Student> input, Chooser chooser) {
        List<Student> result = new ArrayList<>();
        for(Student s : input) {
            if(chooser.choose(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public List<Student> startsWithM(List<Student> input, String prefix) {
        List<Student> result = new ArrayList<>();
        for(Student s : input) {
            if(s.getName().startsWith(prefix)) {
                result.add(s);
            }
        }
        return result;
    }

    public List<Student> studentWithStatus(List<Student> input, Student.Status prefix) {
        List<Student> result = new ArrayList<>();
        for(Student s : input) {
            if(s.getStatus() == prefix) {
                result.add(s);
            }
        }
        return result;
    }

    class StartsWithChooser implements Chooser{
        @Override
        public boolean choose(Student student) {
            return student.getName().startsWith("M");
        }
    }
}
