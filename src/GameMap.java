import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameMap {
    private MapCell[][] generateMapArray() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("map.txt"));
        MapCell[][] cellArray = new MapCell[9][9];
        int row = 0;
        while (scanner.hasNextLine()) {
            int column = 0;
            while (scanner.hasNext()) {
                String s = scanner.next();
                if (s == "x")
                    cellArray[row][column] = new UnpassableCell();
                else if (s == "o" || s == "y")
                    cellArray[row][column] = new DotCell();
                else if (s == "e")
                    cellArray[row][column] = new
            }
            row++;
        }
        return cellArray;
    }
}
