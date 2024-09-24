package ttl.larku.domain;

/*
The Student class should have at least the following properties:
1. An integer id
2. A name
3. A date of Birth
3. A status, which can have the following values:
• Full time
• Part time
• Hibernating
 */

import java.time.LocalDate;
import java.util.Objects;

public class Student implements Comparable<Student>{



   public enum Status {
      FULL_TIME,
      PART_TIME,
      HIBERNATING
   }

   private int id;
   private String name;
   private LocalDate dob;
   private String phoneNumber;
   private Status status = Status.FULL_TIME;

   public Student(int id, String name, LocalDate dob, String phoneNumber, Status status) {
      this.id = id;
      this.name = name;
      this.dob = dob;
      this.phoneNumber = phoneNumber;
      this.status = status;
   }

   public Student(String name, LocalDate dob, String phoneNumber, Status status) {
      this(0, name, dob, phoneNumber, status);
   }

   public Student(String name, LocalDate dob) {
      this(0, name, dob, null, Status.FULL_TIME);
   }

   public Student() {
     int stop = 0;
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

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   @Override
   public String toString() {
      return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", dob=" + dob +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", status=" + status +
            '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Student student)) return false;
      return getId() == student.getId() && Objects.equals(getName(), student.getName()) && Objects.equals(getDob(), student.getDob()) && Objects.equals(getPhoneNumber(), student.getPhoneNumber()) && getStatus() == student.getStatus();
   }

   @Override
   public int hashCode() {
      return Objects.hash(getId(), getName(), getDob(), getPhoneNumber(), getStatus());
   }

   @Override
   public int compareTo(Student other) {
      return Integer.compare(id, other.id);

//      if(this.id < other.getId()) {
//         return -1;
//      }else if(this.id > other.getId()) {
//         return 1;
//      }
//      return 0;
   }
}
