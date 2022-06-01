package org.example.storages;


import org.example.bank.Cards;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CardsStorage implements CardStorage {
    private static final String path = "src/main/java/org/example/users/cards";


    @Override
    public void addCards(Cards cards) throws IOException {
        PrintWriter writer = new PrintWriter((new FileWriter(path, true)));
        String u = cards.getNam() + ";" + cards.getNumber() + ";" + cards.getDate() + ";" + cards.getCvv() + ";" + cards.getAmmount();
        writer.println(u);
        writer.close();

    }

    public void updateCards(Cards cards) throws IOException {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(path));
        } catch (IOException x) {
            System.out.println("Файл не найден");
            x.printStackTrace();
            return;
        }
        ArrayList<String> newCards = new ArrayList<>();

        while (scanner.hasNext()) {
            String cardData = scanner.nextLine();
            String[] els = cardData.split(";");
            System.out.println(cardData);
            if (els[1].equals(cards.getNumber())) {
                String toFile = transform(cards);
                newCards.add(toFile);

            } else {
                newCards.add(cardData);

            }
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(path));
            for (int i = 0; i < newCards.size(); i++) {
                writer.println(newCards.get(i));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();

        }


    }

    public String transform(Cards cards) {
        String u = cards.getNam() + ";" + cards.getNumber() + ";" + cards.getCvv() + ";" + cards.getAmmount() + ";" + cards.getDate();
        return u;
    }
}




