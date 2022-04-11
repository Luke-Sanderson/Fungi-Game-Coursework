package board;

import java.util.ArrayList;
import cards.Card;

public class CardList {
    private ArrayList<Card> cList;

    public CardList() {
        this.cList = new ArrayList<Card>();
    }

    public void add(Card c) {
        this.cList.add(0, c);
    }

    public int size() {
        return this.cList.size();
    }

    public Card getElementAt(int index) {
        return this.cList.get(index);
    }

    public Card removeCardAt(int index) {
        Card removed = this.getElementAt(index);
        this.cList.remove(index);
        return removed;    }
}
