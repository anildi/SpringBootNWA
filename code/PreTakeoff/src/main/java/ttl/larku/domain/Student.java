package ttl.larku.domain;

import java.time.LocalDate;

/**
 * @author whynot
 */
public class Student implements Comparable<Student>{


    public enum Status {
        FULL_TIME,
        PART_TIME,
        HIBERNATING
    }

    private int id;
    private String name;
    private LocalDate dob;

    //fulltime, parttime, hibernating
    private Status status;

    public Student() {}

    public Student(String name, LocalDate dob, Status status) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.status = status;

        //...

    }

    /**
     *
     * @param name
     * @param dob
     */
    public Student(String name, LocalDate dob) {
        this(name, dob, Status.FULL_TIME);
//        this.id = id;
//        this.name = name;
//        this.dob = dob;
//        this.status = Status.FULL_TIME;
    }

    private void init(int id, String name, LocalDate dob, Status status) {

        this.id = id;
        this.name = name;
        this.dob = dob;
        this.status = Status.FULL_TIME;

        //lots of other complicated initialization
        //lots of other complicated initialization
        //lots of other complicated initialization
        //lots of other complicated initialization
        //lots of other complicated initialization
        //lots of other complicated initialization
        //lots of other complicated initialization
        //lots of other complicated initialization
        //lots of other complicated initialization
        //lots of other complicated initialization
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", status=" + status +
                '}';
    }

    @Override
    public int compareTo(Student other) {
//        if(this.id < other.id) {
//            return -1;
//        }else if(this.id > other.id) {
//            return 1;
//        }else {
//            return 0;
//        }
        return Integer.compare(this.id, other.id);
    }
}
