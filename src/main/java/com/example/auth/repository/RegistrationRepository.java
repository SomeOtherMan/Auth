package com.example.auth.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/shop";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String REGISTER = "insert into users(login, password) values (?, ?)";

    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean register(String login, String password) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(REGISTER);
            statement.setString(1, login);
            statement.setString(2, password);

            result = statement.executeUpdate() > 0;

            statement.close();
        } catch (SQLException e) {
            System.out.println("Сломались при регистрации нового Пользователя!");
        }
        return result;
    }


}
