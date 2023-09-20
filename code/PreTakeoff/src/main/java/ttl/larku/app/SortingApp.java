package ttl.larku.app;

import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author whynot
 */
public class SortingApp {

    public static void main(String[] args) {
        SortingApp app = new SortingApp();
//        app.sortNaturalOrder();
        app.sortWithComparator();
    }

    public void sortNaturalOrder() {

        StudentService ss = new StudentService();
        StudentDB.initService(ss);

        List<Student> students = ss.getAll();

        Collections.sort(students);

        for(Student student : students) {
            System.out.println(student);
        }

    }

    public void sortWithComparator() {

        StudentService ss = new StudentService();
        StudentDB.initService(ss);

        List<Student> students = ss.getAll();

        NameComparator nc = new NameComparator();
        Comparator<Student> anonComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Comparator<Student> lambdaComparator = (Student o1, Student o2) -> {
                return o1.getName().compareTo(o2.getName());
            };

        //Collections.sort(students, nc);
        //Collections.sort(students, anonComparator);
        //Collections.sort(students, lambdaComparator);

        Collections.sort(students, (o1, o2) -> o2.getName().compareTo(o2.getName()));

        for(Student student : students) {
            System.out.println(student);
        }

    }


    class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            return student1.getName().compareTo(student2.getName());
        }
    }

    public static <T extends Comparable<T>> void sort(List<T> list) {

    }

    public static <T> void sort(List<T> list, Comparator<T> c) {

    }
}
