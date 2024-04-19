package org.example;

public class Dealer extends Hand {
    private boolean showSecondCard;

    public Dealer(String name) {
        super(name);
        this.showSecondCard = false;
    }

    public boolean shouldHit(){
        return this.getSum() < 17;
    }

    public void setShowSecondCard(boolean show){
        this.showSecondCard = show;
    }

    public String toString() {
        StringBuilder hand = new StringBuilder();
        if(!this.showSecondCard){
            return this.getName() + "'s hand: [" + this.getCards().getFirst() + ", **]";
        }
        for (int i = 0; i < this.getCards().size(); i++) {
            hand.append(this.getCards().get(i).getValue());
            if (i != this.getCards().size() - 1) {
                hand.append(", ");
            }
        }
        return this.getName() + "'s hand: [" + hand + "] - value: " + this.getSum();
    }
}
