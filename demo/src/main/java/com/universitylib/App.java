package com.universitylib;

public class App {
    public static void main(String[] args) {
        
    }

    public class CouseScenarios {

        public static Course addingCourse(){
            Course course = new Course(1, 10);
            course.addCourse(course.getCode());
            return course;
        }

        public static Course addingCourseToWaitlist(){
            Course course = new Course(10, 10);
            course.getWaitlist(course.getCode());
            return course;
        }
        
        public static Course gettingWaitlistCapacity(){
            Course course = new Course(10, 10);
            course.addCourse(course.getCode());
            return course;
        }

        public static Course maxOutCourseCapacity(){
            Course course = new Course(10, 10);
            Student Student0 = new Student(100, 3.2, 19);
            Student Student1 = new Student(100, 3.2, 20);
            Student Student2 = new Student(100, 3.2, 21);
            Student Student3 = new Student(100, 3.2, 21);
            Student Student4 = new Student(100, 3.2, 22);
            course.addCourse(course.getCode());
            course.addToCourse(Student0, course.getCode());
            course.addToCourse(Student1, course.getCode());
            course.addToCourse(Student2, course.getCode());
            course.addToCourse(Student3, course.getCode());
            course.addToCourse(Student4, course.getCode());
            return course;
        }
    }
  
}