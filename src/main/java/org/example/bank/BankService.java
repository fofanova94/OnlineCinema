package org.example.bank;

import org.example.Users;

import java.time.LocalDate;

public class BankService {
    public boolean isEnoughMoney(String number, LocalDate issueDate, int cvv, String name, double ammount) {


        String[] username = name.split(" ");
        if (number.length() == 4 && cvv > 99 && cvv < 999 && issueDate.isAfter(LocalDate.now()) && ammount > 0.10) {
            return true;

        } else
            return false;

    }
}
