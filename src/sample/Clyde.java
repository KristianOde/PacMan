package sample;

import javafx.scene.paint.Color;

public class Clyde extends Ghost {
    public Clyde() {
        super(Color.ORANGE);
    }

    public Clyde(double xpos, double ypos) {
        super(xpos, ypos, Color.ORANGE);
    }
}
