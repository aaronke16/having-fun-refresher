package com.universitylib;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        dbConnect db = new dbConnect();
        Connection conn = db.connect_to_db("postgres", "postgres", "142536");
        // db.createPersonTable(conn, "students");
        // db.insertRow(conn, "students", "Aaron", "myemail@email.com");
        // db.readData(conn, "students");
        // db.updateData(conn, "students", "Kufre", "Aaron");
        // db.readData(conn, "students");
        // db.search_by_id(conn, "students",1);
        // db.search_by_name(conn, "students","Kufre");
        // db.delete_row_by_combination(conn, "students","Kufre", 2);
        // db.readData(conn, "students");
        // db.createPersonTable(conn, "professors");
        // db.createPersonTable(conn, "course");
        // db.createCourseTable(conn);
        // db.createEnrollmentsTable(conn);
        // db.addCourse(conn, "Biology");
        // db.readCourseData(conn);
        // db.addEnrollments(conn, 1, 1);
        db.readEnrollmentsData(conn);
    }
}
