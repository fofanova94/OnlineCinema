package org.example.storages;

import org.example.Users;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUsersStorage implements UsersStorage {

    private static final String path = "src/main/java/org/example/users/user";

    @Override
    public void addUsers(Users user) {
        try {
            PrintWriter writer = new PrintWriter((new FileWriter(path, true))); // TODO New PrintWriter

            String u = transform(user);
            writer.println(u);
            writer.close();
        } catch (IOException e) {
            System.out.println("Проблема с файлом");
            e.printStackTrace();
        }

    }

    @Override
    public void printUsers() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()) {
            String[] els = scanner.nextLine().split(";");
            Users user = new Users(els[0], els[1], els[2], els[3]);
            System.out.println(user);
        }
    }

    @Override
    public Users findUsersByLogin(String findUserName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException x) {
            System.out.println("Файл не найден");
            x.printStackTrace();
            return null;
        }
        while (scanner.hasNext()) {
            String[] els = scanner.nextLine().split(";");
            if (els[0].equals(findUserName)) {
                Users user = new Users(els[0], els[1], els[2], els[3]);
                return user;
            }


        }
        return null;
    }

    @Override
    public void addMoney(double ammount) throws IOException {
    }

    public void updateUser(Users user) { // TODO public void updateUser
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(path));
        } catch (IOException x) {
            System.out.println("Файл не найден");
            x.printStackTrace();
            return;
        }
        ArrayList<String> newUsers = new ArrayList<>();

        while (scanner.hasNext()) {
            String userData = scanner.nextLine();
            String[] els = userData.split(";");
            System.out.println(userData);
            if (els[0].equals(user.getName())) {
                String toFile = transform(user);
                newUsers.add(toFile);

            } else {
                newUsers.add(userData);

            }
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(path));
            for (int i =0;i<newUsers.size();i++){
                writer.println(newUsers.get(i));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();

        }
    }

    public String transform(Users user) {
        String u = user.getName() + ";" + user.getEmail() + ";" + user.getPhone() + ";" + user.getPassword() + ";" + user.getBalance();
        return u;
    }
}







