package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Dot extends Circle {
    private int score;
    private double radius = 2.5;

    public Dot(Boolean big) {
        if (!big) {
            score = 100;
            setRadius(radius);
        }
        else {
            score = 500;
            setRadius(radius*1.75);
        }
        setFill(Color.ORANGE);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
