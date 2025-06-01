package com.universitylib;

abstract class StudentActions extends CourseActions {
    private int credits;
    private double gpa;

    public StudentActions(int credits, double gpa, int id, String name, String email, int code){
        super(code, credits);
        this.credits = credits;
        this.gpa = gpa;
    }

    public void getGpa(){
        System.out.println(gpa);
    }

    public boolean enrollStudent(CourseActions course){
        if(credits < course.getCredits()){
            System.out.println("Don't not have credits to enroll");
            return false;
        }
        
        if(course.getCapacity() < 1){
            System.out.println("Class is full");
            return false;
        }
        credits-=course.getCredits();
        course.addToCourse(this, course.getCode());
        System.out.println("Student enrolled");
        return true;
    }

    public boolean dropStudent(CourseActions course){        
        if(course.removeFromCourse(this, course.getCode())){
            credits+=course.getCredits();
            return true;
        }
        return false;
    }

    public boolean addToWaitlist(CourseActions course, int courseId){
        return course.addToWaitlist(this, courseId);
    }
}
