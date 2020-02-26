package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {
    BorderPane bPane = new BorderPane();
    Pane pane = new Pane();
    GameMap map = new GameMap();
    Creature pacMan = new PacMan();
    int gridRows = map.accessMapArray().length;
    int gridColumns = map.accessMapArray()[0].length;
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Arrays.deepToString(map.accessMapArray()));
        initializeGame();
        bPane.setStyle("-fx-background-color: black;");
        bPane.setCenter(pane);
        System.out.println(gridRows " " + gridColumns);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(bPane);
        primaryStage.setTitle("PacMan");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void initializeGame() {
        for (int i=0; i<27;i++) {
            for (int j=0; j<21; j++) {
                if (!map.accessMapArray()[i][j].getPassable()) {
                    pane.add(new Wall(), j, i);
                }
                else if (map.accessMapArray()[i][j].getBigDot()) {
                    Dot bigDot = new Dot(true);
                    pane.add(bigDot, j, i);
                    Pane.setHalignment(bigDot, HPos.CENTER);
                }
                else if (map.accessMapArray()[i][j].getDot()) {
                    Dot dot = new Dot(false);
                    pane.add(dot, j, i);
                    Pane.setHalignment(dot, HPos.CENTER);
                }
                else if (map.accessMapArray()[i][j].getStarterArea()) {
                    pacMan.setXY(j, i);
                    pane.add(pacMan, pacMan.getX(), pacMan.getY());
                    GridPane.setHalignment(pacMan, HPos.CENTER);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
