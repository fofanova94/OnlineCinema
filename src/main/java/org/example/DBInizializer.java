package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInizializer {

    public static void main(String[] args) {
        String sql = "CREATE TABLE users (" +
                "id int auto_increment primary key," +
                "name varchar(30) not null," +
                "email varchar(50) not null," +
                "phone varchar(50) not null," +
                "password varchar(50) not null,"+
                "balance double )";

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            int updateNumbers = statement.executeUpdate(sql);
            System.out.println("Произошло изменений " + updateNumbers);
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
}
