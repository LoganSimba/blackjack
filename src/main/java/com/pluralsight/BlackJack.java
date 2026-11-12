package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        //call the method
        playGame(players, scanner);


        //initialize and add a method to hand players cards
    }   public static void handCardstoPlayers(Hand hand1, Hand hand2, Deck deck){
            for (int i = 0; i < 2; i++){
                hand1.deal(deck.deal());
                hand2.deal(deck.deal());

            }

        }

        public static void playGame(ArrayList<Player> players, Scanner scanner){

            boolean keepPlaying = true;
            while(keepPlaying) {
                System.out.print("Enter player 1 name: ");
                String player1Name = scanner.nextLine().trim();

                System.out.print("Enter player 2 name: ");
                String player2Name = scanner.nextLine().trim();

                //create player object based off inputs from user
                Player player1 = new Player(player1Name);
                Player player2 = new Player(player2Name);

                players.add(player1);
                players.add(player2);

                Deck deck = new Deck();
                deck.shuffle();

                //gave the players each one two cards
                handCardstoPlayers(player1.getHand(), player2.getHand(), deck);

                int biggerTotal = 0;//initialize total that will help check which player has more
                Player winner = null;//initializing an object that will store the winner
                for (Player player : players) {
                    System.out.println(player.getName() + "'s turn");

                    //call the method to ask them if they will hit or stand
                    hitOrStand(player.getHand(), scanner, deck);

                    int total = player.getHand().getValue();
                    System.out.println(player.getName() + ": " + total);

                    if(player.getHand().getValue() >= 21){//if they have more than 21, print a messafe
                        System.out.println("Game over for " + player.getName());
                        continue;
                    }

                    //if a players total is less than 21 and greater than the others player, return the player
                    if (total <= 21 && total > biggerTotal) {
                        biggerTotal = total;
                        winner = player;
                    }
                }
                //if all players are above 21
                if (winner == null) {
                    System.out.println("No winner, everyone went over 21.");
                } else {//display who won the game
                    System.out.println(winner.getName() + " wins with " + biggerTotal);
                }
                System.out.println("Play again? (X to exit)");
                String exit = scanner.nextLine().trim();
                if(exit.equalsIgnoreCase("x")){
                    System.out.println("Thank you!");
                    keepPlaying = false;
                }

            }
        }
        public static void hitOrStand(Hand hand, Scanner scanner, Deck deck) {
            System.out.println("Total: " + hand.getValue());

            //get in the while loop and prompt the player to either keep hitting or stand
            while (hand.getValue() < 21) {
                System.out.print("Hit or Stand: ");//ask user for what play they want
                String input = scanner.nextLine();//store the user input in the variable

                if (input.equalsIgnoreCase("Hit")) {
                    hand.deal(deck.deal());
                    System.out.println("current total: " + hand.getValue());
                }//if they type stand, exit out the loop
                if (input.equalsIgnoreCase("stand")) {
                    break;
                }
                //if the cvalue of cards is above 21, print a message to let them know them are busted
                if (hand.getValue() > 21) {
                    System.out.println("Bust!");

                }
            }

        }
}






