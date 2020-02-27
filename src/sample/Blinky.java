package sample;

import javafx.scene.paint.Color;

public class Blinky extends Ghost {

    public Blinky() {
        super(Color.RED);
    }

    public Blinky(double xpos, double ypos) {
        super(xpos, ypos, Color.RED);
    }
}
