package board;

import java.util.ArrayList;
import cards.Card;

public class Hand implements Displayable {
    private ArrayList<Card> handList = new ArrayList<Card>();

    public void add(Card c) {
        this.handList.add(c);
    }

    public int size() {
        return this.handList.size();
    }

    public Card getElementAt(int index) {
        return this.handList.get(index);
    }

    public Card removeElement(int index) {
        Card removed = this.getElementAt(index);
        this.handList.remove(index);
        return removed;
    }
}
