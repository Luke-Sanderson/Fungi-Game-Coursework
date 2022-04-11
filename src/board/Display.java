package board;

import java.util.ArrayList;
import cards.Card;

public class Display implements Displayable {
    private ArrayList<Card> displayList = new ArrayList<Card>();

    public void add(Card c) {
        this.displayList.add(c);
    }

    public int size() {
        return this.displayList.size();
    }

    public Card getElementAt(int index) {
        return this.displayList.get(index);
    }

    public Card removeElement(int index) {
        Card removed = this.getElementAt(index);
        this.displayList.remove(index);
        return removed;    }
}
