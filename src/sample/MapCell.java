package sample;

public class MapCell {
    private boolean passable, dot, bigDot, starterArea;
    public MapCell () {
        passable = true; dot = false; bigDot = false; starterArea = false;
    }

    public MapCell (String s) {
        switch (s) {
            case "x":
                passable = false;
                break;
            case "o":
                passable = true;
                dot = true;
                break;
            case "y":
                passable = true;
                dot = true;
                bigDot = true;
                break;
            case "e":
                passable = true;
                break;
            case "s":
                passable = true;
                starterArea = true;
                break;
        }
    }

    public void setDotFalse() {
        this.dot = false;
    }

    public boolean getPassable() {
        return passable;
    }

    public boolean getDot() {
        return dot;
    }

    public boolean getBigDot() {
        return bigDot;
    }

    public boolean getStarterArea() {
        return starterArea;
    }

    public void eatDot() {
        this.dot = false; this.bigDot = false;
    }


}
