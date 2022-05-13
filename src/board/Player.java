package board;

import java.util.ArrayList;
import cards.*;

public class Player {
    private Hand h;
    private Display d;
    private int score;
    private int handlimit;
    private int sticks;

    public Player(){
        this.h = new Hand();
        this.d = new Display();
        this.addCardtoDisplay(new Pan());
        this.score = 0;
        this.sticks = 0;
        this.handlimit = 8;
    }

    public int getScore() {
        return this.score;
    }

    public int getHandLimit() {
        return this.handlimit;
    }

    public int getStickNumber() {
        return this.sticks;
    }

    public void addSticks(int num) {
        for (int i = 0; i < num; i++) {
            this.getDisplay().add(new Stick());
        }
        this.sticks += num;
    }

    public void removeSticks(int num) {
        this.sticks -= num;

        for (int i = 0; i < this.getDisplay().size(); i++) {
            if (num < 1) break;
            if (this.getDisplay().getElementAt(i).getType() == CardType.STICK) {
                this.getDisplay().removeElement(i);
                i--;
                num--;
            }
        }
    }

    public Hand getHand() {
        return this.h;
    }

    public Display getDisplay() {
        return this.d;
    }

    public void addCardtoHand(Card c) {
        if (c.getType() == CardType.BASKET) {
            this.handlimit += 2;
            this.addCardtoDisplay(c);
        }
        else{
            this.h.add(c);
        }
    }

    public void addCardtoDisplay(Card c) {
        this.d.add(c);
    }


    public boolean takeCardFromTheForest(int i) {
        if (i <= 0 || i > 8) {
            return false;
        }

        Card card = Board.getForest().getElementAt(8 - i);

        if (card.getType() != CardType.BASKET &&
            this.getHand().size() >= this.getHandLimit()) {
                return false;
        }

        if (i <= 2) {
            this.addCardtoHand(card);
            Board.getForest().removeCardAt(8 - i);
            return true;
        }
        else if (this.getStickNumber() >= i - 2) {
            this.removeSticks(i - 2);
            this.addCardtoHand(card);
            Board.getForest().removeCardAt(8 - i);
            return true;
        }


        return false;
    }

    public boolean takeFromDecay() {

        int numOfBaskets = 0;
        for (Card c : Board.getDecayPile()) {
            if (c.getType() == CardType.BASKET) {numOfBaskets += 1;}
        }

        if (this.getHand().size() + Board.getDecayPile().size() - numOfBaskets <= this.getHandLimit() + 2 * numOfBaskets) {
            while (Board.getDecayPile().size() > 0) {
                this.addCardtoHand(Board.getDecayPile().get(0));
                Board.getDecayPile().remove(0);
            }
            return true;
        }

        return false;
    }

    public boolean cookMushrooms(ArrayList<Card> list) {
        boolean displayPanExists = false, handPanExists = false;
        ArrayList<Card> mushrooms = new ArrayList<Card>();
        ArrayList<Card> additionals = new ArrayList<Card>();

        for (int i = 0; i < this.getDisplay().size(); i++) {
            if (this.getDisplay().getElementAt(i).getType() == CardType.PAN) {
                displayPanExists = true;
            }
        }
        for (Card c : list) {
            switch (c.getType()) {
                case PAN:
                    handPanExists = true;
                    break;
                case DAYMUSHROOM:
                    mushrooms.add(c);
                    break;
                case NIGHTMUSHROOM:
                    mushrooms.add(c); mushrooms.add(c);
                    break;
                case BUTTER:
                case CIDER:
                    additionals.add(c);
                    break;
                default:
                    return false;
            }
        }

        if (!(displayPanExists || handPanExists) || mushrooms.size() < 3) {
            return false;
        }

        String name = mushrooms.get(0).getName();
        for (Card c : mushrooms) {
            if (c.getName() != name) return false;
        }

        int mushroomsRequired = 0;
        for (Card additional : additionals) {
            if (additional.getType() == CardType.BUTTER) {
                mushroomsRequired += 4;
            }
            else {
                mushroomsRequired += 5;
            }
        }

        if (mushrooms.size() < mushroomsRequired) return false;

        for (Card mushroom : mushrooms) {
            this.score += ((EdibleItem) mushroom).getFlavourPoints();
        }
        for (Card additional : additionals) {
            this.score += ((EdibleItem) additional).getFlavourPoints();
        }

        for (Card cardToRemove : list) {
            for (int i = 0; i < this.getHand().size(); i++) {
                if (cardToRemove == this.getHand().getElementAt(i)) {
                    this.getHand().removeElement(i);
                    break;
                }
            }
        }

        if (!handPanExists) {
            for (int i = 0; i < this.getDisplay().size(); i++) {
                if (this.getDisplay().getElementAt(i).getType() == CardType.PAN) {
                     this.getDisplay().removeElement(i);
                     break;
                }
            }
        }
        return true;
    }

    public boolean sellMushrooms(String name, int num) {
        if (num <= 1) return false;
        name = name.toLowerCase().replaceAll("\\s", "");

        int sticksToAdd = 0, numOfType = 0;

        for (int i = 0; i < this.getHand().size(); i++) {
            if (this.getHand().getElementAt(i).getName().equals(name))
            {
                if (this.getHand().getElementAt(i).getType() == CardType.NIGHTMUSHROOM) {
                    numOfType++;
                }
                numOfType++;
            }
        }
        if (numOfType < 2 || numOfType < num) return false;

        for (int i = 0; i < this.getHand().size(); i++) {
            if (num < 1) break;
            if (this.getHand().getElementAt(i).getName().equals(name))
            {
                if (this.getHand().getElementAt(i).getType() == CardType.NIGHTMUSHROOM) {
                    sticksToAdd += ((Mushroom) this.getHand().getElementAt(i)).getSticksPerMushroom();
                    num--;
                }
                sticksToAdd += ((Mushroom) this.getHand().getElementAt(i)).getSticksPerMushroom();
                this.getHand().removeElement(i);
                i--;
                num--;
            }
        }

        this.addSticks(sticksToAdd);

        return true;
    }

    public boolean putPanDown() {
        for (int i = 0; i < this.getHand().size(); i++) {
            if (this.getHand().getElementAt(i).getType() == CardType.PAN) {
                this.getDisplay().add(this.getHand().removeElement(i));
                return true;
            }
        }

        return false;
    }
}
