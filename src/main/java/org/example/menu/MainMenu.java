package org.example.menu;

import org.example.JavaMovieStorage;
import org.example.Movie;
import org.example.Users;
import org.example.storages.DataBaseStorage;
import org.example.storages.FileUsersStorage;
import org.example.storages.UsersStorage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu implements Menu {
    public void show(MenuManager menuManage) throws IOException {
        UsersStorage us = new DataBaseStorage();
        JavaMovieStorage one = new JavaMovieStorage();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберете действие:");
        System.out.println("1. Регистрация");
        System.out.println("2. Показать пользователей");
        System.out.println("3. Выход");
        System.out.println("4. Поиск пользователя по имени");
        System.out.println("5. Войти в личный кабинет");
        String num = scanner.nextLine();

        if (num.equals("1")) {


            Menu registrationMenu = new RegistrationMenu();
            menuManage.changeMenu(registrationMenu);

        } else if (num.equals("2")) {

            us.printUsers();

        } else if (num.equals("3")) {

            return;
        } else if (num.equals("4")) {
       Menu findUserMenu = new FindUserMenu();
       menuManage.changeMenu(findUserMenu);


        } else if (num.equals("5")) {
            Menu userMenu = new UserMenu();
            menuManage.changeMenu(userMenu);
        }
    }
}
