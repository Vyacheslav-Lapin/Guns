package com.epam.jf.ee02.t01.security;

import java.sql.*;

/**
 * UserChecker.
 *
 * @author Vyacheslav_Lapin
 */
public class UserChecker {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isUserCorrect(String login, String pwd) {

        if (login == null || pwd == null)
            return false;

        String sql = "select id from User where login = ? and password = ?";
        int result = 0;

        try (Connection connect = getConnection();
             PreparedStatement prepareStatement = connect.prepareStatement(sql)) {
            prepareStatement.setString(1, login);
            prepareStatement.setString(2, pwd);

            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next())
                result = resultSet.getInt("id");
            else
                return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result != 0;
    }

    private static Connection getConnection() throws SQLException {
        // TODO: Брать из JNDI`я, из Connection Pool`а
        String jdbcUrl = "jdbc:mysql://mysql47.1gb.ru:3306/gb_weapons";
        String jdbcUser = "gb_weapons";
        String jdbcPassword = "f7bae9a52z23";

        return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
    }

    public static boolean isUserTXTEnable(String login) {
        return true; //TODO: проверять по DB
    }
}
