package com.pluralsight;

public class BlackJack {
    public static void main(String[] args) {

        Deck deck = new Deck();
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        deck.shuffle();



        //initialize and add a method to hand players cards
    }   public static void handCardstoPlayers(Hand hand1, Hand hand2, Deck deck){
            for (int i = 0; i < 5; i++){
                hand1.deal(deck.deal());
                hand2.deal(deck.deal());

            }

        }

    }

