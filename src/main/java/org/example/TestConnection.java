package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.sql.*;

public class TestConnection {

    public static final String USER_NAME = "root";
    public static final String PASSWORD = "trickymove";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static Connection connection;
    public static Statement statement;


    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
Class.forName("com.mysql.cj.jdbc.Driver");

statement.executeUpdate("CREATE TABLE usersStorage (" +
        "id int auto_increment primary key," +
        "name varchar(30) not null,"+
        "name1  varchar(10) not null,"+
        "name2 varchar(10) not null,"+
        "name3 varchar(10) not null)");
statement.executeUpdate("INSERT INTO usersStorage (name, email, phone, password, balance) value ('Tom','test@mail',567,123,0.0)");

ResultSet resultSet = statement.executeQuery("SELECT * FROM usersStorage");

while (resultSet.next()){
    System.out.println(resultSet.getString(2) + " "+
            resultSet.getString(3)+ " "+
            resultSet.getString(4)+ " "+
            resultSet.getString(5)+ " "+
            resultSet.getString(6));
}
    }
}
