package sample;

import javafx.scene.shape.Circle;

public class Creature extends Circle {
    protected int x, y;
    public Creature() {}
    public void setXY(int x, int y) {
        this.x = x; this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

