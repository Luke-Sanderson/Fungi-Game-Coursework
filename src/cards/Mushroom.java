package cards;

public abstract class Mushroom extends EdibleItem {
    protected int sticksPerMushroom;

    public Mushroom(CardType type, String n) {
        super(type, n);

        switch(n) {
            case "honeyfungus":
            case "lawyerswig":
            case "henofwoods":
                this.sticksPerMushroom = 1;
                break;
            case "treeear":
            case "shiitake":
            case "birchbolete":
            case "chanterelle":
                this.sticksPerMushroom = 2;
                break;
            case "porcini":
                this.sticksPerMushroom = 3;
                break;
            case "morel":
                this.sticksPerMushroom = 4;
                break;
        }
    }

    public int getSticksPerMushroom() {
        return this.sticksPerMushroom;
    }
}
