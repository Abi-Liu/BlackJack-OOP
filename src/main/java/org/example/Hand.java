package org.example;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    private int sum;
    private final String name;

    public Hand(String name){
        this.cards = new ArrayList<>();
        this.sum = 0;
        this.name = name;
    }

    public boolean isBlackJack(){
        return this.sum == 21;
    }

    public void add(Card card){
        this.cards.add(card);
        this.sum += card.getNumericValue();
    }

    public boolean isBust(){
        return this.sum > 21;
    }

    public void reset(){
        this.cards.clear();
        this.sum = 0;
    }

    public int getSum(){
        return this.sum;
    }

    public ArrayList<Card> getCards(){
        return this.cards;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        StringBuilder hand = new StringBuilder();
        for(int i = 0; i < this.cards.size(); i++){
            hand.append(cards.get(i).getValue());
            if(i != cards.size() - 1) {
                hand.append(", ");
            }
        }
        return this.name + "'s hand: [" + hand + "] - value: " + this.sum;
    }
}
