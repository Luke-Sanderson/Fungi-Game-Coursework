class Hand implements Displayable {
    private ArrayList<Card> handList;

    public void add(Card c) {
        this.handList.add(c);
    }

    public int size() {
        return this.handList.size();
    }

    public Card getElementAt(int index) {
        return this.handList[index];
    }

    public Card removeCardAt(int index) {
        this.handList.remove(index);
    }
}
