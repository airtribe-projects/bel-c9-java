package org.airtribe.AuthenticationAuthorization;

import java.sql.*;

public class SqlInjectionExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/RegistrationDB";
        String username = "root";

        String userInput = "123@gmail.com' OR 1=1 --";
        try (Connection connection = DriverManager.getConnection(url, username, "")) {
            // Unsafe SQL query with string concatenation (Vulnerable to SQL Injection)

            String query = "SELECT * FROM User WHERE email = '" + userInput;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

//            String query = "SELECT * FROM User WHERE email = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, userInput); // safely set the user input
//            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String pass = resultSet.getString("password");
                System.out.println("Email: " + email + ", Password: " + pass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
