package cards;

public class EdibleItem extends Card {
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
            case "morel":
            case "cider":
                flavourPoints = 5;
                break;
        }
    }

    public int getFlavourPoints() {
        return flavourPoints;
    }
}
