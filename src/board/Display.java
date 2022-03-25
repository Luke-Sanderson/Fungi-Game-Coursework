class Display implements Displayable {
    private ArrayList<Card> displayList;

    public add(Card c){
        this.displayList.add(c);
    }

    public int size() {
        return this.displayList.size();
    }

    public Card getElementAt(int index) {
        return this.displayList[index];
    }

    public Card removeCardAt(int index) {
        this.displayList.remove(index);
    }
}
