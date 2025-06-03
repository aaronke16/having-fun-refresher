package com.universitylib;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbConnect {
    public Connection connect_to_db(String dbname, String user, String pass){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if(conn != null){
                System.out.println("Connection established");
            }else{
                System.out.println("Connection failed");
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT version();");

            if (rs.next()) {
                System.out.println("Connected to: " + rs.getString(1));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return conn;
    }

    public void createPersonTable(Connection conn, String table_name){
        Statement statement;
        try {
            String query = "create table person (id SERIAL, name varchar(200), address varchar(200), primary key (id));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void createCourseTable(Connection conn){
        Statement statement;
        try {
            String query = "create table course(course_id SERIAL, student_id varchar(200), course_name, primary key (course_id));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Course Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void createEnrollmentsTable(Connection conn){
        Statement statement;
        try {
            String query = "create table enrollments(course_id INTEGER REFERENCES course(course_id), student_id INTEGER REFERENCES students(id), PRIMARY KEY(student_id, course_id));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Enrollments Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void addEnrollments(Connection conn, int course_id, int student_id){
        Statement statement;
        try {
            String query = String.format("insert into enrollments (course_id, student_id) values(%s, %s)", student_id, course_id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println(String.format("Student %d added to course %d", student_id, course_id));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readEnrollmentsData(Connection conn){
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("Select * from enrollments");
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("course_id") + " ");
                System.out.print(rs.getString("student_id"));
            }       
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void addCourse(Connection conn, String course_name){
        Statement statement;
        try {
            String query = String.format("insert into course (course_name) values ('%s');", course_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println(String.format(course_name, " added to course"));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRow(Connection conn, String table_name, String name, String address){
        Statement statement;
        try {
            String query = String.format("insert into %s(name, address) values('%s', '%s');", table_name, name, address);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readData(Connection conn, String table_name){
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.println(rs.getString("Address"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readCourseData(Connection conn){
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from course");
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("course_id") + " ");
                System.out.print(rs.getString("course_name"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void updateData(Connection conn, String table_name, String new_name, String old_name){
        Statement statement;
        try {
            String query = String.format("update %s set name='%s' where name='%s'", table_name, new_name, old_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void search_by_name(Connection conn, String table_name, String name){
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s where name ='%s'", table_name, name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.println(rs.getString("Address"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void search_by_id(Connection conn, String table_name, int id){
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s where id = %s", table_name, id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.println(rs.getString("Address"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_row_by_combination(Connection conn, String table_name, int course_id, int student_id){
        Statement statement;
        try {
            String query = String.format("delete from %s where course_id = %s and id = %s", table_name, course_id, student_id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Information deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
