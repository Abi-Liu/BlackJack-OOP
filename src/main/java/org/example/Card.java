package org.example;

public class Card {
    private String value;
    private String suit;

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getNumericValue() {
        if(this.value.equals("Jack") || this.value.equals("Queen") || this.value.equals("King") ){
            return 10;
        } else if(this.value.equals("Ace")){
            return 11;
        } else {
            return Integer.parseInt(this.value);
        }
    }

    public String getValue(){
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String toString(){
        return this.value + " of " + this.suit;
    }
}