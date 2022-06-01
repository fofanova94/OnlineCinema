package org.example.menu;

import org.example.Users;
import org.example.storages.DataBaseStorage;
import org.example.storages.UsersStorage;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindUserMenu implements Menu {

    public void show(MenuManager menuManage) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        UsersStorage us = new DataBaseStorage();
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        Users user = us.findUsersByLogin(name);
        System.out.println(user);

    }
}
