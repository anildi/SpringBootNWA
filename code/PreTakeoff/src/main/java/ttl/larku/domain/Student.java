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

public class Student {

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
}
