package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Dot extends Circle {
    private int score;

    public Dot(Boolean big) {
        if (!big) {
            score = 100;
            setRadius(5);
        }
        else {
            score = 500;
            setRadius(8);
        }
        setFill(Color.WHITE);
    }

    public int getScore() {
        return score;
    }
}
