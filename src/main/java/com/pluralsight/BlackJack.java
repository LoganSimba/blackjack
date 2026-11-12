package com.pluralsight;

import java.util.ArrayList;
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
        ArrayList<Player> players = new ArrayList<>();

        players.add(player1);
        players.add(player2);



        //gave the players each one two cards
        handCardstoPlayers(player1.getHand(), player2.getHand(), deck);

        int biggerTotal = 0;
        Player winner = null;
        for(Player player : players){
            int total = player.getHand().getValue();
            System.out.println(player.getName() + ": " + total);

            //if a players total is less than 21 and greater than the others player, return the player
            if(total <= 21 && total > biggerTotal){
                total = biggerTotal;
                winner = player;
            }
        }
        //if all players are above 21
        if (winner == null) {
            System.out.println("No winner, everyone went over 21.");
        } else {//display who won the game
            System.out.println(winner.getName() + " wins with " + biggerTotal);
        }


        //initialize and add a method to hand players cards
    }   public static void handCardstoPlayers(Hand hand1, Hand hand2, Deck deck){
            for (int i = 0; i < 2; i++){
                hand1.deal(deck.deal());
                hand2.deal(deck.deal());

            }

        }

    }

