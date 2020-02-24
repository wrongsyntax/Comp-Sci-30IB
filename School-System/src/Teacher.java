import java.util.Arrays;

public class Teacher extends Person {
    // Instance variables
    int numOfCourses = 0;
    String[] courses = new String[0];

    // Constructor
    Teacher(String name, String address) {
        super(name, address);
    }

    // Method to check if the new course being added doesn't already exist
    boolean checkNewCourse(String newCourse) {
        return !Arrays.asList(courses).contains(newCourse);
    }
    // Method to add the course to courses taught
    void addCourse(String newCourse) {
        if (checkNewCourse((newCourse))) {
            String[] tempCourses = new String[courses.length + 1];
            System.arraycopy(courses, 0, tempCourses, 0, courses.length);
            tempCourses[tempCourses.length - 1] = newCourse;
            courses = tempCourses;
        } else {
            System.out.print("ERROR: That course already exists.");
        }
    }

    // Method to make sure the course exists before removing it
    boolean checkBeforeRemoving(String courseToRemove) {
        return Arrays.asList(courses).contains(courseToRemove);
    }

    // Method to remove a course being taught
    void removeCourse(String courseToRemove) {
        String[] tempCourses = new String[courses.length - 1];
        int index = 0;
        if (checkBeforeRemoving(courseToRemove)) {
            for (String course : courses) {
                if (!course.equals(courseToRemove)) {
                    tempCourses[index] = course;
                    index++;
                }
            }
        } else {
            System.out.println("ERROR: That course doesn't exist.");
        }
        courses = tempCourses;
    }

    void printCourses() {
        System.out.println(Arrays.toString(courses));
    }
}
