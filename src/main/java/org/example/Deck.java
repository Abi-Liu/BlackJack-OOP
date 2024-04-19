package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        // initialize the deck of cards
        ArrayList<Card> cards =  new ArrayList<>();
        String[] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};
        for(String suit: suits){
            for(int i = 2; i <= 14; i++){
                String card = "";
                if(i == 11){
                    card = "Jack";
                } else if (i == 12){
                    card = "Queen";
                } else if (i == 13){
                    card  = "King";
                } else if (i == 14){
                    card = "Ace";
                } else {
                    card += i;
                }
                cards.add(new Card(card, suit));
            }
        }
        this.deck = cards;
    }

    public boolean isEmpty(){
        return this.deck.isEmpty();
    }

    public void deal(Hand hand){
        if(this.deck.isEmpty()){
            // TODO maybe make it reshuffle the deck if it's empty
            return;
        }

        Random rand = new Random();
        int index = rand.nextInt(this.deck.size());
        hand.add(this.deck.remove(index));
    }
}
