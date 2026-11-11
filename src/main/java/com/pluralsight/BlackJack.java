package com.pluralsight;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();


        System.out.print("Enter player 1 name: ");
        String player1Name = scanner.nextLine().trim();

        System.out.print("Enter player 2 name: ");
        String player2Name = scanner.nextLine().trim();

        //create player object based off inputs from user
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        //gave the players each one two cards
        handCardstoPlayers(player1.getHand(), player2.getHand(), deck);



        //initialize and add a method to hand players cards
    }   public static void handCardstoPlayers(Hand hand1, Hand hand2, Deck deck){
            for (int i = 0; i < 2; i++){
                hand1.deal(deck.deal());
                hand2.deal(deck.deal());

            }

        }

    }

