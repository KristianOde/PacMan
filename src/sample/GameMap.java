package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GameMap {
    private MapCell[][] cellArray;
    /** Konstruktøren for GameMap-objekter. Konstruktøren prøver å kjøre
     * metoden generateMapArray() for å gjøre at GameMap-objektet
     * inneholder en array av MapCell-objekter.
     */
    public GameMap() {
        try {
            cellArray = generateMapArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** Metode for å opprette et array av MapCell-objekter. Den henter inn
     * kartdataen fra en fil kalt 'map.txt', leser av bokstaver i den filen
     * som den sender videre til konstruktøren til MapCell-klassen, som avgjør
     * hvilken attributter objektet skal ha basert på bokstaven den mottar.
     */
    private MapCell[][] generateMapArray() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/sample/map.txt"));
        MapCell[][] cellArray = new MapCell[27][21];
        String[][] test = new String[27][21];
        int row = 0;
        while (scanner.hasNextLine()) {
            for (int i=0; i<cellArray.length; i++) {
                String[] line = scanner.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    cellArray[i][j] = new MapCell(line[j]);
                    test[i][j] = line[j];
                }
            }
        }
        System.out.println(Arrays.deepToString(test));
        return cellArray;
    }

    /** Access-metoden for å kunne lese av MapCell-arrayet til GameMap-objektet
     */
    public MapCell[][] accessMapArray() {
        return cellArray;
    }
}
