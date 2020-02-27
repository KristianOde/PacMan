package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Creature extends Arc {
    protected int x, y;
    protected Direction dir;
    protected Timeline animation;

    public Creature() {
        animation = new Timeline(new KeyFrame(Duration.millis(10), e -> move()));
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
        /* Warping mechanic: if you reach the end of the map
         * you warp to the opposite side
         */
        if(getCenterX() > 21*20/*20=GRIDSIZE*/) {
            this.setCenterX(0);
        }else if(getCenterX() < 0 /*20=GRIDSIZE*/) {
            this.setCenterX(21*20);
        }else if(getCenterY() > 27*20/*20=GRIDSIZE*/){
            this.setCenterY(0);
        }else if(getCenterY() < 0/*20=GRIDSIZE*/){
            this.setCenterY(27*20);
        }

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

