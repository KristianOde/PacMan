package sample;

import javafx.scene.paint.Color;

public class PacMan extends Creature {

    /** Default-konstruktør for PacMan
     *
     */
    public PacMan() {
        setRadius(10);
        setFill(Color.YELLOW);
    }

    public PacMan(int x, int y) {
        setRadius(10); setFill(Color.YELLOW);
        this.x = x; this.y = y;
    }
}
