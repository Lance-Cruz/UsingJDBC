package ie.atu.sem2week8;

import java.sql.*;

public class SelectExample {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/groupdatabase";
        String username = "root";
        String password = "password";

        String selectSQL = "SELECT id, course_name, credits, level, semester, duration_weeks, max_students, staff_id FROM course";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String courseName = resultSet.getString("course_name");
                int credits = resultSet.getInt("credits");
                String level = resultSet.getString("level");
                String semester = resultSet.getString("semester");
                int durationWeeks = resultSet.getInt("duration_weeks");
                int maxStudents = resultSet.getInt("max_students");
                int staffId = resultSet.getInt("staff_id");

                System.out.println("Course ID: " + id + " | Name: " + courseName + " | Credits: " + credits +
                        " | Level: " + level + " | Semester: " + semester +
                        " | Duration: " + durationWeeks + " weeks | Max Students: " + maxStudents +
                        " | Staff ID: " + staffId);
                System.out.println("------------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
