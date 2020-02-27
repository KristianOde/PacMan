package sample;

import javafx.scene.paint.Color;

public class Pinky extends Ghost {

    public Pinky() {
        super(Color.PINK);
    }

    public Pinky(double xpos, double ypos) {
        super(xpos, ypos, Color.PINK);
    }
}
