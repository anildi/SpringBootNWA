package ttl.larku.app;

import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author whynot
 */
public class MapApp {

    public static void main(String[] args) {
        MapApp ma = new MapApp();
//        ma.firstMap();
//        ma.secondMap();
        ma.thirdMap();
    }


    public void firstMap() {

        StudentService ss = new StudentService();
        StudentDB.initService(ss);

        List<Student> students = ss.getAll();

        List<String> result1 = badMap(students);

        for(String name: result1) {
            System.out.println(name);
        }
    }

    public void secondMap() {

        StudentService ss = new StudentService();
        StudentDB.initService(ss);

        List<Student> students = ss.getAll();
        NameExtractor ne = new NameExtractor();

        List<String> result1 = betterMap(students, ne);
        List<String> result2 = betterMap(students, s -> s.getName());

        for(String name: result2) {
            System.out.println(name);
        }
    }

    public void thirdMap() {

        StudentService ss = new StudentService();
        StudentDB.initService(ss);

        List<Student> students = ss.getAll();
        GenericNameExtractor gne = new GenericNameExtractor();

        List<String> result1 = almostBestMap(students, gne);
        List<String> result2 = almostBestMap(students, s -> s.getName());


        List<LocalDate> result3 = almostBestMap(students, s -> s.getDob());

        for(String name: result2) {
            System.out.println(name);
        }

        List<String> lstr = List.of("One", "Two", "threeeee");
        List<Integer> lengths = map(lstr, this::mapStringToIntegerInComplicatedWay);

//void accept(T t)

        lengths.forEach(this::prettyPrint);

//        for(Integer len: lengths) {
////            System.out.println(len);
//        }
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

    public <T, R> List<R> map(List<T> input, Function<T, R> extractor) {
        List<R> result = new ArrayList<>();
        for(T s : input) {
            result.add(extractor.apply(s));
        }

        return result;
    }

    public <T, R> List<R> almostBestMap(List<T> input, GenericExtractor<T, R> extractor) {
        List<R> result = new ArrayList<>();
        for(T s : input) {
            result.add(extractor.extract(s));
        }

        return result;
    }

    interface GenericExtractor<T, R> {
        R extract(T t);
    }

    interface Extractor
    {
        String extract(Student student);
    }

    public List<String> betterMap(List<Student> input, Extractor extractor) {
        List<String> result = new ArrayList<>();
        for(Student s : input) {
            result.add(extractor.extract(s));
        }

        return result;
    }

    class GenericNameExtractor implements GenericExtractor<Student, String>
    {
        @Override
        public String extract(Student student) {
            return student.getName();
        }
    }

    class NameExtractor implements Extractor
    {
        @Override
        public String extract(Student student) {
            return student.getName();
        }
    }

    public List<String> badMap(List<Student> input) {
       List<String> result = new ArrayList<>();
       for(Student s : input) {
           result.add(s.getName());
       }

       return result;
    }

    public List<Student.Status> badMapStatus(List<Student> input) {
        List<Student.Status> result = new ArrayList<>();
        for(Student s : input) {
            result.add(s.getStatus());
        }

        return result;
    }
}
