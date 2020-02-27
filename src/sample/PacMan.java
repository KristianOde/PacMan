package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class PacMan extends Creature {

    /** Default-konstruktør for PacMan
     *
     */
    public PacMan() {
        setType(ArcType.ROUND);
        setRadiusX(8.5);
        setRadiusY(8.5);
        setStartAngle(40);
        setLength(280);
        setStroke(Color.BLACK);
        setFill(Color.YELLOW);
    }

    public PacMan(int x, int y) {
        setRadiusX(10);
        setRadiusY(10);
        setStartAngle(40);
        setLength(280);
        setFill(Color.YELLOW);
        this.x = x; this.y = y;
    }
}
