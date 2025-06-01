package com.universitylib;

class Professor extends Person {
    private int courseCode;
    
    public Professor(int id, String name, String email, int courseCode){
        super(id, name, email);
        this.courseCode = courseCode;
    }

    public int getCourseCode(){
        return courseCode;
    }

}
