package sample;

import javafx.scene.shape.Circle;

public class Creature extends Circle {
    protected int x, y;
    protected Direction dir;
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

    public void setDirection(Direction dir) {
        this.dir = dir;
    }

    public Direction getDirection() {
        return dir;
    }

    public void move() {
        if (this.getDirection() == Direction.LEFT) {
            this.setCenterX(this.getCenterX() - 1);
        }
        if (this.getDirection() == Direction.RIGHT) {
            this.setCenterX(this.getCenterX() + 1);
        }
    }
}

