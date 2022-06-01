package org.example;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private long id;
    private String login;
    private String name;
    private String email;
    private String phone;
    private double balance;
    private String password;
    private List<Movie> favorites;

    public Users(String n, String l, String e, String ph, String pass, double base) {
        name = n;
        login = l;
        email = e;
        phone = ph;
        password = pass;
        favorites = new ArrayList<Movie>();
        balance = base;
    }

    public Users(String el, String el1, String el2, String el3) {
        name = el;
        email = el1;
        phone = el2;
        password = el3;
        balance = 0;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getBalance() {
        return balance;
    }

    public void addMoney(double money) {
        balance = balance + money;
    }
    //TODO посмотреть чуть позже этот код

    public String getPassword() {
        return password;
    }

    public String getLogin(){return login;}

    public long getId(){return id;}

    public void addFavorites(Movie m) {
        favorites.add(m);
    }

    public void printFavorites() {
        for (int i = 0; i < favorites.size(); i++) {
            System.out.println(favorites.get(i));
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ".  Email: " + email + ". Phone: " + phone + ". Баланс: " + balance;
    }

}
