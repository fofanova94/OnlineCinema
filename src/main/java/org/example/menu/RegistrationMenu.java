package org.example.menu;

import org.example.Users;
import org.example.storages.DataBaseStorage;
import org.example.storages.FileUsersStorage;
import org.example.storages.UsersStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RegistrationMenu implements Menu {

    private static final String path = "src/main/java/org/example/users/user";

    public void show(MenuManager menuManage) throws IOException {
        UsersStorage us = new DataBaseStorage();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя:"); //TODO Проверить наличие пользователя
        String name = scanner.nextLine();
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        if (userIsExist(login)) {
            System.out.println("Такой пользователь уже есть");
        } else {
            System.out.println("Введите email:");
            String email = scanner.nextLine();
            System.out.println("Введите телефон:");
            String phone = scanner.nextLine();
            System.out.println("Введите пароль:");
            String password = scanner.nextLine();
            Users user = new Users(name, login, email, phone, password, 0.0);
            us.addUsers(user);
            System.out.println("Вы успешно зарегистрировались");
            menuManage.changeMenu(new UserMenu());
        }


    }


    private boolean userIsExist1(String name) throws FileNotFoundException {
        Scanner file = new Scanner(new File(path));
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] cols = line.split(";");

            if (cols[0].equals(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean userIsExist(String login) throws FileNotFoundException {
        UsersStorage us = new DataBaseStorage();
        Users users = us.findUsersByLogin(login);
        if (users == null){
            return false;
        }
        return true;
    }
}


