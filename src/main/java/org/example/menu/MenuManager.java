package org.example.menu;

import org.example.menu.Menu;

import java.io.IOException;

public class MenuManager {

    private Menu activeMenu;

    public void changeMenu(Menu menu) {
        activeMenu = menu;
    }

    public void excecuteMenu() throws IOException {
        activeMenu.show(this);
    }
}
