package cz.boris;

import java.sql.*;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String title, author, glossary;
        int price;

        System.out.println("---DBS Luxor Insert---");

        System.out.println("Enter title: ");
        title = sc.nextLine();

        System.out.println("Enter author: ");
        author = sc.nextLine();

        System.out.println("Enter glossary: ");
        glossary = sc.nextLine();

        System.out.println("Enter price: ");
        price = sc.nextInt();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/luxor", "root", "");

        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO books VALUES (NULL, ?, ?, ?, ?)");
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setString(3, glossary);
        preparedStatement.setInt(4, price);

        preparedStatement.executeUpdate();

        connection.close();
    }
}
