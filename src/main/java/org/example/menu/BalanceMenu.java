package org.example.menu;

import org.example.Users;
import org.example.UsersSingleton;
import org.example.bank.BankService;
import org.example.bank.Cards;
import org.example.storages.CardStorage;

import org.example.storages.CardsStorage;
import org.example.storages.FileUsersStorage;
import org.example.storages.UsersStorage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class BalanceMenu implements Menu {
    private static final String path = "src/main/java/org/example/users/user";
    private BankService bankService = new BankService();

    public void show(MenuManager menuManage) throws IOException {
        CardStorage cardsStorage = new CardsStorage();
        UsersStorage us = new FileUsersStorage();
        Users users = UsersSingleton.getUser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер карты");
        String number = scanner.next();
        System.out.println("Введите срок действия карты");
        LocalDate date = LocalDate.parse(scanner.next());
        System.out.println("Введите CVV");
        int cvv = scanner.nextInt();
        System.out.println("Введите имя");
        String name = scanner.next();
        System.out.println("Введите сумму");
        double ammount = scanner.nextDouble();
        if (bankService.isEnoughMoney(number, date, cvv, name, ammount)) {
            users.addMoney(ammount);
            us.updateUser(users);
            Cards card = new Cards(number, name, date, cvv, ammount);
            cardsStorage.addCards(card);
            System.out.println("Баланс пополнен");
            System.out.println("Ваш баланс" + ammount);

            Menu userMenu = new UserMenu();
            menuManage.changeMenu(userMenu);
        } else {

            System.out.println("Неверно введены данные");
        } //TODO сделать карты апдейт
    }
}
// TODO: пополнение баланса пользователя, занесение его в файл, сохранение карты




