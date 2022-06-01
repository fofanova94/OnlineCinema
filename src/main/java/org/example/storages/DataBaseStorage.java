package org.example.storages;

import com.mysql.cj.jdbc.interceptors.ResultSetScannerInterceptor;
import org.example.ConnectionFactory;
import org.example.Users;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class DataBaseStorage implements UsersStorage {


    @Override
    public void addUsers(Users user) {
        String sql = "INSERT INTO users (name, login, email, phone, password, balance) value (?,?, ?,?,?,?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2,user.getLogin());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setDouble(6, user.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    @Override
    public void printUsers() {
        String sql = "SELECT * FROM users";
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String password = resultSet.getString("password");
                double balance = resultSet.getDouble("balance");

                Users users = new Users(name, login, email, phone, password, balance);
                System.out.println(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    @Override
    public void addMoney(double userBalance) {

    }

    @Override
    public void updateUser(Users user) {

    }

    @Override
    public Users findUsersByLogin(String findLogin) {
        String sql = "SELECT name, login, email, phone, password, balance FROM users WHERE (login LIKE '" + findLogin + "%')";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            ResultSet result = preparedStatement.executeQuery(sql);
            while (result.next()) {
                String name = result.getString("name");
                String login = result.getString("login");
                String email = result.getString("email");
                String phone = result.getString("phone");
                String password = result.getString("password");
                double balance = result.getDouble("balance");
                Users users = new Users(name, login, email, phone,password,balance);
                return users;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }


        return null;
    }
}

