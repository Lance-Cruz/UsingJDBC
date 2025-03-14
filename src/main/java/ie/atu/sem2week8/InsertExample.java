package ie.atu.sem2week8;

import java.sql.*;

public class InsertExample {
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/groupdatabase", "root", "password");

        try{

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO staff (first_name, last_name, email, phone_number," +
                    "office_location) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, "test1");
            stmt.setString(2, "test2");
            stmt.setString(3, "test@email.com");
            stmt.setString(4, "12345678");
            stmt.setString(5, "222");
            stmt.executeUpdate();

            stmt = conn.prepareStatement("INSERT INTO course (course_name, credits, level, semester, duration_weeks, " +
                    "max_students, staff_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, "Course 1");
            stmt.setString(2, "5");
            stmt.setString(3, "Level 8");
            stmt.setString(4, "Semester 1");
            stmt.setInt(5, 13);
            stmt.setInt(6, 80);
            stmt.setInt(7, getLastInsertId(conn));
            stmt.executeUpdate();

        } catch (SQLException ex) {

            System.out.println("Recorded input failed");
            ex.printStackTrace();
        }

        conn.close();
    }
    private static int getLastInsertId(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT LASTERT_ID()");
        rs.next();
        int id = rs.getInt(1);
        rs.close();
        stmt.close();
        return id;
    }
}
