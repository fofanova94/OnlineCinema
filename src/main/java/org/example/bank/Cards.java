package org.example.bank;

import org.example.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cards {

    private String number;
    private String name;
    private LocalDate issueDate;
    private int cvv;
    private double ammount;


    public Cards(String n, String na, LocalDate isD, int cv, double a) {
        number = n;
        name = na;
        issueDate = isD;
        cvv = cv;
        ammount = a;
    }


    public String getNumber() {
        return number;
    }

    public String getNam() {
        return name;
    }

    public LocalDate getDate() {
        return issueDate;
    }

    public int getCvv() {
        return cvv;
    }

    public double getAmmount() {
        return ammount;
    }


}
