package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        GridPane gPane = new GridPane();
        GameMap map = new GameMap();
        Creature PacMan = new PacMan();
        System.out.println(Arrays.deepToString(map.accessMapArray()));
        gPane.setGridLinesVisible(true);
        for (int i=0; i<27;i++) {
            for (int j=0; j<21; j++) {
                if (!map.accessMapArray()[i][j].getPassable()) {
                    gPane.add(new Rectangle(20, 20, Color.BLUE), j, i);
                }
                else if (map.accessMapArray()[i][j].getDot()) {
                    gPane.add(new Circle(5, Color.WHITE), j, i);
                }
                else if (map.accessMapArray()[i][j].getStarterArea()) {
                    gPane.add(PacMan, j, i);
                }
            }
        }
        pane.setStyle("-fx-background-color: black;");
        gPane.setGridLinesVisible(true);
        System.out.println(gPane.isGridLinesVisible());

        pane.setCenter(gPane);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
