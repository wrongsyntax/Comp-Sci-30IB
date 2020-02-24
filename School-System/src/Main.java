import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student testStudent = new Student("Ian", "987 5th Ave, SomeCity AB, Canada");

        // Add course for student
        testStudent.addCourse("Math", 89);
        testStudent.addCourse("Chemistry", 91);
        testStudent.addCourse("Physics", 88);
        testStudent.addCourse("English", 93);
        testStudent.addCourse("Social Studies", 92);
        testStudent.printGrades();
        double averageGrade = testStudent.getAverageGrade();
        System.out.print("Average grade: " + averageGrade);
    }
}
