package org.example.menu;

import org.example.JavaMovieStorage;
import org.example.Movie;
import org.example.Users;
import org.example.UsersSingleton;

import java.io.IOException;
import java.util.Scanner;

public class MovieMenu implements Menu {
    public void show(MenuManager menuManage) throws IOException {
        Scanner scanner = new Scanner(System.in);
        JavaMovieStorage one = new JavaMovieStorage();
        Users user = UsersSingleton.getUser();
        System.out.println("Выберете действие");
        System.out.println("1. Выбрать фильм");
        System.out.println("2. Показать избранное");
        System.out.println("3. Пополнить баланс");
        System.out.println("4. Выйти в главное меню");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            one.printFilms();
            System.out.println("Выберете фильм");
            String filmName = scanner.nextLine();
            Movie m = one.findFilms(filmName);
            if (m != null) {
                user.addFavorites(m);
            } else {
                System.out.println("Введите корректное название фильма");
            }

        }

        if (choice.equals("2")) {
            user.printFavorites();

        }

        if (choice.equals("3")) {
            Menu balanceMenu = new BalanceMenu();
            menuManage.changeMenu(balanceMenu);
        }
        if (choice.equals("4")) {
            Menu mainMenu = new MainMenu();
            menuManage.changeMenu(mainMenu);
        }
    }

}

