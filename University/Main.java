package University;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(0, 3);
        Student student = new Student(10, 3.2, 10);
        Student student2 = new Student(10, 3.2, 2);

        int code = course.getCode();
        System.out.println(code);

        course.addCourse(code);

        student.enrollStudent(course);
        student2.enrollStudent(course);

        course.viewCourseEnrollment(code);

        student2.dropStudent(course);        

        course.viewCourseEnrollment(code);

    }
}
