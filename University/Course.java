package University;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Course {
    private int code;
    private int capacity = 5;
    private int credits;
    private HashMap<Integer, ArrayList<Student>> ClassList;
    private Queue<Student> Waitlist;
    private int waitlistCapacity = 5;

    public Course(int code, int credits){
        this.code = code;
        this.credits = credits;
        this.ClassList = new HashMap<>();
        this.Waitlist = new LinkedList<>();
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

    public void getWaitlist(){
        for(Student student: Waitlist){
            System.out.println(student);
        }
    }

    public boolean getWaitlistCapacity(){
        return waitlistCapacity > Waitlist.size();
    }

    public boolean courseExists(int code){
        if(!ClassList.containsKey(code)){
            return false;
        }
        return true;
    }

    public boolean addCourse(int code){
        ArrayList<Student> studentList = new ArrayList<>();
        if(!courseExists(code)){
            ClassList.put(code, studentList);
            System.out.println("Class added to directory");
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

    public boolean addToWaitlist(Student student){
        if(!getWaitlistCapacity()){
            Waitlist.add(student);
            return true;
        }
        System.out.println("Waitlist at capacity");
        return false;
    }

    public boolean removeFromWaitlist(Student student){
        if(Waitlist.contains(student)){
            Waitlist.remove(student);
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
