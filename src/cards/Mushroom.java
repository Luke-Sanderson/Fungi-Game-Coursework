package cards;

public class Mushroom extends EdibleItem {
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
                this.sticksPerMushroom = 2;
                break;
            case "birchbolete":
            case "porcini":
                this.sticksPerMushroom = 3;
                break;
            case "chanterelle":
                this.sticksPerMushroom = 4;
                break;
            case "morel":
                this.sticksPerMushroom = 6;
                break;
        }
    }

    public int getSticksPerMushroom() {
        return this.sticksPerMushroom;
    }
}
