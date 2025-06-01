package com.universitylib;

public class Student {
    private int credits;
    private double gpa;
    private int id;

    public Student(int credits, double gpa, int id){
        this.credits = credits;
        this.gpa = gpa;
        this.id = id;
    }

    public void getCredits(){
        System.out.println(credits);
    }

    public void getGpa(){
        System.out.println(gpa);
    }

    public void getId(){
        System.out.println(id);
    }

    public boolean enrollStudent(Course course){
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

    public boolean dropStudent(Course course){        
        if(course.removeFromCourse(this, course.getCode())){
            credits+=course.getCredits();
            return true;
        }
        return false;
    }

    public boolean addToWaitlist(Course course, int courseId){
        return course.addToWaitlist(this, courseId);
    }

}