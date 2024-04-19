package org.example;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Deck deck;
    private Dealer dealer;
    private Hand player;

    public UserInterface(){
        this.deck = new Deck();
        this.scanner = new Scanner(System.in);
        this.dealer = new Dealer("Dealer");
        this.player = new Hand("Player");
    }

    public void start(){
        while(true){
            resetHands();
            System.out.println("Let's play Black Jack! (y/n)");
            String play = scanner.nextLine();
            if(play.toLowerCase().equals("n")){
                break;
            }
            initialDeal();
            System.out.println(dealer);
            System.out.println(player);

            if(checkBlackJack()){
                continue;
            }

            playerHit();
            if(player.isBust()){
                System.out.println("You busted! - value " + player.getSum());
                continue;
            }
            dealer.setShowSecondCard(true);
            System.out.println(dealer);
            while(dealer.shouldHit()){
                deck.deal(dealer);
                System.out.println(dealer);
            }
            if(dealer.isBust()){
                System.out.println("You win!");
                continue;
            }
            checkWinPlayerWin();
        }
    }

    public void checkWinPlayerWin(){
        if(player.getSum() > dealer.getSum()){
            System.out.println("You win!");
        } else if (player.getSum() < dealer.getSum()){
            System.out.println("You lost!");
        } else {
            System.out.println("Tie!");
        }
    }

    public boolean checkBlackJack(){
        if(dealer.isBlackJack() && player.isBlackJack()){
            System.out.println("Tie!");
            return true;
        } else if(dealer.isBlackJack() && !player.isBlackJack()){
            System.out.println("Dealer wins!");
            return true;
        } else if(dealer.isBlackJack() && !player.isBlackJack()){
            System.out.println("Player Wins!");
            return true;
        }
        return false;
    }

    public void resetHands(){
        this.dealer.reset();
        this.dealer.setShowSecondCard(false);
        this.player.reset();
    }

    public void playerHit(){
        while(true){
            System.out.println("Hit or Stay?");
            String choice = scanner.nextLine();
            if(choice.toLowerCase().equals("stay")){
                break;
            } else if(choice.toLowerCase().equals("hit")) {
               deck.deal(player);
               System.out.println(player);
               if(player.isBlackJack()){
                   break;
               } else if (player.isBust()){
                   System.out.println("You busted! - value: " + player.getSum());
               }
            } else {
                System.out.println("Command not recognized. `Hit` or `Stay` bozo");
            }
        }
    }

    public void initialDeal(){
        dealer.setShowSecondCard(false);
        for(int i = 0; i < 4; i ++){
            if(i % 2 == 0){
                this.deck.deal(this.player);
            } else {
                this.deck.deal(this.dealer);
            }
        }
    }
}
