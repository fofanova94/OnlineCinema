package org.example.menu;

import org.example.Users;
import org.example.UsersSingleton;
import org.example.storages.FileUsersStorage;
import org.example.storages.UsersStorage;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserMenu implements Menu {
    public void show(MenuManager menuManage) throws FileNotFoundException {

        UsersStorage us = new FileUsersStorage();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        Users user = us.findUsersByLogin(name);
        System.out.println(user);
        if (user == null) {

            System.out.println("Такого пользователя не существует");
            Menu mainMenu = new MainMenu();
            menuManage.changeMenu(mainMenu);

        } else if (!user.getPassword().equals(password)) {
            System.out.println("Вы ввели неправильный пароль");
            Menu mainMenu = new MainMenu();
            menuManage.changeMenu(mainMenu);
        } else {
            UsersSingleton.setUser(user);
            System.out.println("Привет, " + user.getName());
            Menu movieMenu = new MovieMenu();
            menuManage.changeMenu(movieMenu);



        }
    }
}
