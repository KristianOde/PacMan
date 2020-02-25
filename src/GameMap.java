import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameMap {
    MapCell[][] cellArray;
    {
        try {
            cellArray = generateMapArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private MapCell[][] generateMapArray() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("map.txt"));
        MapCell[][] cellArray = new MapCell[27][21];
        int row = 0;
        while (scanner.hasNextLine()) {
            int column = 0;
            while (scanner.hasNext()) {
                String s = scanner.next();
                cellArray[row][column] = new MapCell(s);
                column++;
            }
            row++;
        }
        return cellArray;
    }
}
