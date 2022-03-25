class CardList {
    private ArrayList<Card> cList;

    public CardPile(){
        this.cList = new ArrayList<Card>();
    }

    public void add(Card c) {
        this.cList.add(c);
    }

    public int size() {
        return this.cList.size();
    }

    public Card getElementAt(int index) {
        return this.cList[index];
    }

    public Card removeCardAt(int index) {
        this.cList.remove(index)
    }
}
