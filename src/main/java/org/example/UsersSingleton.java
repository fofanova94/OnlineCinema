package org.example;

public class UsersSingleton {

    private static Users loggedUser;


    public static Users getUser(){
        return loggedUser;
    }

    public static void setUser(Users user){
        loggedUser = user;

    }

}
