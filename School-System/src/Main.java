public class Main {
    public static void main(String[] args) throws InterruptedException {
        Student testStudent = new Student("Ian", "987 5th Ave, SomeCity AB, Canada");
        Teacher testTeacher = new Teacher("Eddie", "123 7th Street, SomeCity AB, Canada");

        // Automated test for student
        System.out.print("Beginning test for student in ");
        for (int i = 3; i > 0; i--) {
            System.out.print(" " + i);
            Thread.sleep(250);
            System.out.print(".");
            Thread.sleep(250);
            System.out.print(".");
            Thread.sleep(250);
            System.out.print(".");
            Thread.sleep(250);
        }
        // Add course for student
        System.out.println("\nAdding courses and grades for the student"); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); System.out.println();
        Thread.sleep(1000);
        testStudent.addCourse("Math", 89);
        testStudent.addCourse("Chemistry", 91);
        testStudent.addCourse("Physics", 88);
        testStudent.addCourse("English", 93);
        testStudent.addCourse("Social Studies", 92);
        Thread.sleep(1000);
        System.out.println("\nCalling the printGrades() method for the student"); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); System.out.println();
        Thread.sleep(1000);
        testStudent.printGrades();
        Thread.sleep(1000);
        System.out.println("\nGetting the average grade for the student"); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); System.out.println();
        Thread.sleep(1000);
        double averageGrade = testStudent.getAverageGrade();
        System.out.print("Average grade: " + averageGrade);
        // End of automated test for student

        // Automated test for teacher
        System.out.print("\n\nBeginning test for teacher in ");
        for (int i = 3; i > 0; i--) {
            System.out.print(" " + i);
            Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print(".");
            Thread.sleep(250);
        }
        System.out.println();

        System.out.println("\nAdding courses for the teacher"); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); System.out.println();
        Thread.sleep(1000);
        testTeacher.addCourse("Math");
        testTeacher.addCourse("Physics");
        testTeacher.addCourse("Chemistry");
        System.out.println("The teacher is teaching the following courses: ");
        testTeacher.printCourses();

        Thread.sleep(1000);
        System.out.println("\nRemoving a course for the teacher"); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); System.out.println();
        Thread.sleep(1000);
        testTeacher.removeCourse("Math");
        System.out.println("The teacher is now teaching the following courses: ");
        testTeacher.printCourses();

        Thread.sleep(1000);
        System.out.println("\nTesting adding a course that already exists"); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); System.out.println();
        Thread.sleep(1000);
        testTeacher.addCourse("Physics");
        System.out.println();

        Thread.sleep(1000);
        System.out.println("\nTesting removing a course that doesn't exist"); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); Thread.sleep(250); System.out.print("."); System.out.println();
        Thread.sleep(1000);
        testTeacher.removeCourse("English");
        // End of automated test for teacher
    }
}
