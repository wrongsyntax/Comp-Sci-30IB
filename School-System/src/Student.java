import java.util.stream.IntStream;

public class Student extends Person {
    // Instance variables
    int numOfCourses = 0;
    int[] grades = new int[0];
    String[] courses = new String[0];

    // Constructor
    Student(String name, String address) {
        super(name, address);
    }

    // Method to add a grade for a course
    void addCourse(String newCourse, int newGrade) {
        // Increase the length of the courses and grades arrays
        String[] tempCourses = new String[courses.length + 1];
        int[] tempGrades = new int[grades.length + 1];
        System.arraycopy(courses, 0, tempCourses, 0, courses.length);
        System.arraycopy(grades, 0, tempGrades, 0, grades.length);
        courses = tempCourses;
        grades = tempGrades;

        // Add the new values to the arrays
        courses[courses.length - 1] = newCourse;
        grades[grades.length - 1] = newGrade;
        numOfCourses++;
    }

    // Print out the grades for each course
    void printGrades() {
        int index = 0;
        for (String course : courses) {
            System.out.println(course + ": " + grades[index]);
            index++;
        }
    }

    // Get the average grade for the student
    double getAverageGrade() {
        return IntStream.of(grades).sum() / (double)(grades.length);
    }
}
