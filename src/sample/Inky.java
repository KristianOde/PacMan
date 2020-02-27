package sample;

import javafx.scene.paint.Color;

public class Inky extends Ghost {
    public Inky() {
        super(Color.CYAN);
    }

    public Inky(double xpos, double ypos) {
        super(xpos, ypos, Color.CYAN);
    }
}
