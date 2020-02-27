package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Ghost extends Creature {
    public Ghost() {
        setType(ArcType.OPEN);
        setRadiusX(8);
        setRadiusY(11);
        setStartAngle(310);
        setLength(280);
        setStroke(Color.BLACK);
        setFill(Color.LIGHTGREY);
    }

    public Ghost(Color color) {
        setType(ArcType.OPEN);
        setRadiusX(8);
        setRadiusY(11);
        setStartAngle(310);
        setLength(280);
        setStroke(Color.BLACK);
        setFill(color);
    }

    public Ghost(double xpos, double ypos) {
        setCenterX(xpos);
        setCenterY(ypos);
        setType(ArcType.OPEN);
        setRadiusX(8);
        setRadiusY(11);
        setStartAngle(310);
        setLength(280);
        setStroke(Color.BLACK);
        setFill(Color.LIGHTGREY);
    }

    public Ghost(double ypos, double xpos, Color color) {
        setCenterX(xpos);
        setCenterY(ypos);
        setType(ArcType.OPEN);
        setRadiusX(8);
        setRadiusY(11);
        setStartAngle(310);
        setLength(280);
        setStroke(Color.BLACK);
        setFill(color);
    }
}
