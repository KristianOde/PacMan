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
                switch (s) {
                    case "x":
                        cellArray[row][column] = new UnpassableCell();
                        break;
                    case "o":
                    case "y":
                        cellArray[row][column] = new DotCell();
                        break;
                    case "e":
                        cellArray[row][column] = new EmptyCell();
                        break;
                }
                column++;

            }
            row++;
        }
        return cellArray;
    }
}
