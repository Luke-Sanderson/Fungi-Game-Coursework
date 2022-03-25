class Player {
    private Hand h;
    private Display d;
    private int score;
    private int handlimit;
    private int sticks;

    public Player(){
        this.h = new Hand();
        this.d = new Display();
        this.score = 0;
        this.sticks = 0;
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
        this.sticks += num;
    }

    public void removeSticks(int num) {
        this.sticks -= num;
    }

    public Hand getHand() {
        return this.h;
    }

    public Display getDisplay() {
        return this.d;
    }

    public void addCardtoHand(Card c) {
        this.h.add(c);
    }

    public void addCardtoDisplay(Card c) {
        this.d.add(c);
    }


    public boolean takeCardFromTheForest(int i) {

    }

    public boolean takeFromDecay() {

    }

    public boolean cookMushrooms(ArrayList<Card> list) {

    }

    public boolean sellMushooms(String name, int num) {

    }

    public boolean putPanDown() {

    }
}
