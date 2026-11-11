package com.pluralsight;

import java.util.ArrayList;

public class Player {
    private String name;
    private Hand hand;
    private ArrayList<Card> cards;


    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Hand getHand() {
        return hand;
    }


}
