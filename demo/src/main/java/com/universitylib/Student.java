package com.universitylib;

class Student extends Person{
    private int credits;
    private double gpa;

    public Student(int credits, double gpa, int id, String name, String email){
        super(id, name, email);
        this.credits = credits;
        this.gpa = gpa;
    }

}