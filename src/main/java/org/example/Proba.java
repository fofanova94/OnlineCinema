package org.example;

import org.example.storages.FileUsersStorage;

import java.io.IOException;

public class Proba{

    public static void main(String[] args) throws IOException {
     FileUsersStorage one = new FileUsersStorage();
        //one.printUsers();
     one.addUsers(new Users("user", "user@gmail.com", "+7888.....", "321"));

     Users u = one.findUsersByLogin("admin");
     System.out.println(u);
    }


    // java -classpath .:target/dependency/* Proba
}
