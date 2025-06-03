package com.universitylib;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        dbConnect db = new dbConnect();
        Connection conn = db.connect_to_db("postgres", "postgres", "");
        // db.createPersonTable(conn, "students");
    }
}
