package org.example;

import org.example.menu.MainMenu;
import org.example.menu.Menu;
import org.example.menu.MenuManager;


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        Menu mainMenu = new MainMenu();

        MenuManager menuManager = new MenuManager();

        menuManager.changeMenu(mainMenu);
        while (true) {
            menuManager.excecuteMenu();
        }
    }
}
  