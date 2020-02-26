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
    BorderPane pane = new BorderPane();
    GridPane gPane = new GridPane();
    GameMap map = new GameMap();
    Creature pacMan = new PacMan();
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Arrays.deepToString(map.accessMapArray()));
        initializeGame();
        pane.setStyle("-fx-background-color: black;");
        pane.setCenter(gPane);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(pane);
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
                    gPane.add(new EmptySpace(), j, i);
                }
                else if (map.accessMapArray()[i][j].getBigDot()) {
                    gPane.add(new Dot(true), j, i);
                }
                else if (map.accessMapArray()[i][j].getDot()) {
                    gPane.add(new Dot(false), j, i);
                }
                else if (map.accessMapArray()[i][j].getStarterArea()) {
                    pacMan.setXY(j, i);
                    gPane.add(pacMan, pacMan.getX(), pacMan.getY());
                }
            }
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
