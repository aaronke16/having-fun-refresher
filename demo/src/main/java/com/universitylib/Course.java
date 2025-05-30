package com.universitylib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Course {
    private int code;
    private int capacity = 5;
    private int credits;
    private HashMap<Integer, ArrayList<Student>> ClassList;
    private HashMap<Integer, Queue<Student>> Waitlist;
    private int waitlistCapacity = 5;

    public Course(int code, int credits){
        this.code = code;
        this.credits = credits;
        this.ClassList = new HashMap<>();
        this.Waitlist = new HashMap<>();
    }

    public int getCode(){
        return code;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getCredits(){
        return credits;
    }

    public boolean isWaitlist(int code){
        return Waitlist.containsKey(code);
    }

    public boolean getWaitlist(int code){
        if(isWaitlist(code)){
            Queue<Student> waitListOfStudents = Waitlist.get(code);
            if(waitListOfStudents.size() < 1){
                System.out.println("Waitlist is empty");
                return false;
            }
            for(Student student: waitListOfStudents){
                System.out.println(student);
                return true;
            }
        }
        return false;
    }

    public boolean getWaitlistCapacity(int code){
        if(Waitlist.containsKey(code)){
            int waitlistSize = Waitlist.get(code).size();
            System.out.println( waitlistSize + " on the waitlist");
            return Waitlist.get(code).size() < waitlistCapacity;
        }
        System.out.println("Course does not exist");
        return false;
    }

    public boolean courseExists(int code){
        if(!ClassList.containsKey(code)){
            return false;
        }
        return true;
    }

    public boolean addCourse(int code){
        ArrayList<Student> studentList = new ArrayList<>();
        Queue<Student> waitList = new LinkedList<>();
        if(!courseExists(code)){
            ClassList.put(code, studentList);
            Waitlist.put(code, waitList);
            System.out.println("Class added to directory & waitlist");
            return true;
        }
        System.out.println("Course already in system");
        return false;
    }

    public boolean addToCourse(Student student, int code){
        if(courseExists(code)){
            int runningCapacity = ClassList.get(code).size();
            if(runningCapacity < capacity){
                ArrayList<Student> currList = ClassList.get(code);
                currList.add(student);
                ClassList.put(code, currList);
                return true;
            }else if(!getWaitlistCapacity(code)){
                
            }
            System.out.println("Class is currently at capacity");
            return false;
        }
        System.out.println("Course doesn't exist");
        return false;
    }

    public boolean removeFromCourse(Student student, int code){
        if(courseExists(code)){
            ArrayList<Student> listOfStudentsInCouse = ClassList.get(code);
            if(listOfStudentsInCouse.contains(student)){
                listOfStudentsInCouse.remove(student);
                return true;
            }else{
                System.out.println("Student could not be found in course!");
                return false;
            }
        }
        System.out.println("Couse does not exist!");
        return false;
    }

    public boolean addToWaitlist(Student student, int code){
        if(getWaitlistCapacity(code)){
            Queue<Student> waitlistOfStudents= Waitlist.get(code);
            waitlistOfStudents.add(student);
            Waitlist.put(code, waitlistOfStudents);
            System.out.println(student + " has been added to the waitlist");
            return true;
        }
        System.out.println("Waitlist at capacity");
        return false;
    }

    public boolean removeFromWaitlist(Student student){
        if(getWaitlistCapacity(code)){
            Queue<Student> waitlistOfStudents = Waitlist.get(code);
            waitlistOfStudents.remove(student);
            Waitlist.put(code, waitlistOfStudents);
            System.out.println(student + " removed from waitlist");
            return true;
        }
        System.out.println("Student not on waitlist");
        return false;
    }

    public boolean viewCourseEnrollment(int code){
        if(courseExists(code)){
            System.out.println("This class has " + ClassList.get(code).toString());
            return true;
        }
        System.out.println("Course doesn't exist");
        return false;
    }
}
