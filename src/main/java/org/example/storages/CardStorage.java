package org.example.storages;

import org.example.Users;
import org.example.bank.Cards;

import java.io.IOException;

public interface CardStorage {

    public void addCards(Cards cards) throws IOException;

}
