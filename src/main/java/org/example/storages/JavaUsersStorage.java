package org.example.storages;

import org.example.Users;

import java.io.IOException;
import java.util.ArrayList;

public class JavaUsersStorage implements UsersStorage {

    private ArrayList<Users> users = new ArrayList<Users>();
    private ArrayList<Double> balance = new ArrayList<Double>();

    public JavaUsersStorage() {
        Users admin = new Users("admin", "12", "admin@email.ru", "+7......", "123", 0);
        Users user = new Users("user", "1","user@gmail.com", "+7888.....", "321", 0);
        addUsers(admin);
        addUsers(user);
    }

    @Override
    public void addUsers(Users user) {
        users.add(user);
    }

    public void printUsers() {
        for (int i = 0; i < users.size(); i++) {
            Users u = users.get(i);
            System.out.println(u);
        }
    }

    public Users findUsersByLogin(String findUserName) {
        for (Users user : users) {
            String name = user.getName();
            if (name.equals(findUserName)) {
                return user;
            }


        }
        return null;
    }

    @Override
    public void addMoney(double ammount) throws IOException {balance.add(ammount);
    }

    public void updateUser(Users user) {return;}

}
