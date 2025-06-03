package com.universitylib;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        dbConnect db = new dbConnect();
        Connection conn = db.connect_to_db("postgres", "postgres", "");
        db.search_by_id(conn, "students",1);
        db.readData(conn, "students");
        db.createPersonTable(conn, "professors");
        db.createPersonTable(conn, "course");
    }
}
