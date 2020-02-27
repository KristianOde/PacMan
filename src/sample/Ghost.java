package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Ghost extends Creature {

    private boolean vulnerable= false;
    private boolean dying= false;
    private boolean dead= false;

    public Ghost() {
        setType(ArcType.OPEN);
        setRadiusX(7);
        setRadiusY(10);
        setStartAngle(310);
        setLength(280);
        setStroke(Color.BLACK);
        setFill(Color.LIGHTGREY);
    }

    public Ghost(Color color) {
        setType(ArcType.OPEN);
        setRadiusX(7);
        setRadiusY(10);
        setStartAngle(310);
        setLength(280);
        setStroke(Color.BLACK);
        setFill(color);
    }

    public Ghost(double xpos, double ypos) {
        setCenterX(xpos);
        setCenterY(ypos);
        setType(ArcType.OPEN);
        setRadiusX(7);
        setRadiusY(10);
        setStartAngle(310);
        setLength(280);
        setStroke(Color.BLACK);
        setFill(Color.LIGHTGREY);
    }

    public Ghost(double ypos, double xpos, Color color) {
        setCenterX(xpos);
        setCenterY(ypos);
        setType(ArcType.OPEN);
        setRadiusX(7);
        setRadiusY(10);
        setStartAngle(310);
        setLength(280);
        setStroke(Color.BLACK);
        setFill(color);
    }

    /*get-set-is methods below*/
    protected boolean isVulnerable() {
        return vulnerable;
    }

    protected void setVulnerable(boolean trueOrFalse) {
        this.vulnerable = trueOrFalse;
    }

    protected boolean isDying() {
        return dying;
    }

    protected void setDying(boolean trueOrFalse) {
        this.dying = trueOrFalse;
    }

    protected boolean isDead() {
        return dead;
    }

    protected void setDead(boolean trueOrFalse) {
        this.dead = trueOrFalse;
    }

    protected Color getColor() {
        return (Color) getFill();
    }

    protected void setColor(Color color) {
        setFill(color);
    }
}
