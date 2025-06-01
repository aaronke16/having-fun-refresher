package com.universitylib;

public class App {
    public static void main(String[] args) {
        Student student = new Student(10, 10, 9, "Aaron", "Aaron");
        CourseActions course = new CourseActions(10, 5);
        // student.getId();
        System.out.println(student.getName());
    }

    public class CouseScenarios {

        public static CourseActions addingCourse(){
            CourseActions course = new CourseActions(1, 10);
            course.addCourse(course.getCode());
            return course;
        }

        public static CourseActions addingCourseToWaitlist(){
            CourseActions course = new CourseActions(10, 10);
            course.getWaitlist(course.getCode());
            return course;
        }
        
        public static CourseActions gettingWaitlistCapacity(){
            CourseActions course = new CourseActions(10, 10);
            course.addCourse(course.getCode());
            return course;
        }

        public static CourseActions maxOutCourseCapacity(){
            CourseActions course = new CourseActions(10, 10);
            Student Student0 = new Student(100, 3.2, 0, null, null);
            // Student Student1 = new Student(100, 3.2, 20);
            // Student Student2 = new Student(100, 3.2, 21);
            // Student Student3 = new Student(100, 3.2, 21);
            // Student Student4 = new Student(100, 3.2, 22);
            course.addCourse(course.getCode());
            // course.addToCourse(Student0, course.getCode());
            // course.addToCourse(Student1, course.getCode());
            // course.addToCourse(Student2, course.getCode());
            // course.addToCourse(Student3, course.getCode());
            // course.addToCourse(Student4, course.getCode());
            return course;
        }
    }
  
}
