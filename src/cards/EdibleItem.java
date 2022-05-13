package cards;

public abstract class EdibleItem extends Card {
    protected int flavourPoints;

    public EdibleItem(CardType type, String n) {
        super(type, n);

        switch(n) {
            case "honeyfungus":
            case "treeear":
                flavourPoints = 1;
                break;
            case "lawyerswig":
            case "shiitake":
                flavourPoints = 2;
                break;
            case "butter":
            case "henofwoods":
            case "birchbolete":
            case "porcini":
                flavourPoints = 3;
                break;
            case "chanterelle":
                flavourPoints = 4;
                break;
            case "cider":
                flavourPoints = 5;
                break;
            case "morel":
                flavourPoints = 6;
        }
    }

    public int getFlavourPoints() {
        return flavourPoints;
    }
}
