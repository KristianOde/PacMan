public class MapCell {
    boolean passable, dot, bigDot, starterArea;
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


}
