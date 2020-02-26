package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Dot extends Circle {
    private int score;
    private double radius = 3.5;

    public Dot(Boolean big) {
        if (!big) {
            score = 100;
            setRadius(radius);
        }
        else {
            score = 500;
            setRadius(radius*2);
        }
        setFill(Color.WHITE);
    }

    public int getScore() {
        return score;
    }
}
