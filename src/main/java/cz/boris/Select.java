package cz.boris;

import java.sql.*;

public class Select {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/luxor", "root", "");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

        while(resultSet.next()) {
            System.out.println(resultSet.getString("title"));
        }

        connection.close();
    }
}
