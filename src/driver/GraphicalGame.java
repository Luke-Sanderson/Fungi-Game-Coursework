package driver;

import javafx.application.Application;
import javafx.stage.Stage;
import board.Player;

public class GraphicalGame extends Application {
    private static Player p1;
    private static Player p2;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Fungi");

        stage.show();
    }
}
