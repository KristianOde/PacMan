package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Creature extends Circle {
    protected int x, y;
    protected Direction dir;
    protected Timeline animation;

    public Creature() {
        animation = new Timeline(new KeyFrame(Duration.millis(5), e -> move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
    }
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
        }else if (this.getDirection() == Direction.RIGHT) {
            this.setCenterX(this.getCenterX() + 1);
        }else if (this.getDirection() == Direction.UP) {
            this.setCenterY(this.getCenterY() - 1);
        }else if (this.getDirection() == Direction.DOWN) {
            this.setCenterY(this.getCenterY() + 1);
        }
    }
}

