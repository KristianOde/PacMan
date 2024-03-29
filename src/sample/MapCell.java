package sample;

public class MapCell {
    private boolean passable, dot, bigDot, starterArea, bStarterArea, pStarterArea, iStarterArea, cStarterArea;
    private String warpArea;
    /** Default-konstruktør for MapCell-objekter
     */
    public MapCell () {
        passable = true; dot = false; bigDot = false; starterArea = false;
        bStarterArea = false; pStarterArea = false; iStarterArea = false; cStarterArea = false;
    }

    /** Konstruktør for MapCell-objekter som leser inn en String og
     * oppretter et objekt med ulike verdier basert på String-verdien
     */
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
            case "d":
                passable = true;
                warpArea = "west";
                break;
            case "f":
                passable = true;
                warpArea = "east";
            case "b":
                bStarterArea = true;
                passable = true;
            case "p":
                pStarterArea = true;
                passable = true;
            case "i":
                iStarterArea = true;
                passable = true;
            case "c":
                cStarterArea = true;
                passable = true;

        }
    }

    /** Ulike get- og set-metoder
     *
     */
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

    public boolean getBStarterArea() {
        return bStarterArea;
    }

    public boolean getPStarterArea() {
        return pStarterArea;
    }

    public boolean getIStarterArea() {
        return iStarterArea;
    }

    public boolean getCStarterArea() {
        return cStarterArea;
    }

    public String getWarpArea() {
        return warpArea;
    }

    public void eatDot() {
        this.dot = false; this.bigDot = false;
    }

}
