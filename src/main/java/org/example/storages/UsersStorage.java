package org.example.storages;

import org.example.Users;
import org.example.bank.Cards;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UsersStorage {

    public void addUsers(Users user) throws IOException;

    public void printUsers () throws FileNotFoundException;

    public Users findUsersByLogin(String findUserName) throws FileNotFoundException;

    public void addMoney (double userBalance) throws IOException;

    public void updateUser(Users user) throws IOException;

}

