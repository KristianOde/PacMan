package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {
    final int GRIDSIZE = 20;
    BorderPane bPane = new BorderPane();
    Pane pane = new Pane();
    GameMap map = new GameMap();
    Creature pacMan = new PacMan();
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Arrays.deepToString(map.accessMapArray()));
        initializeGame();
        bPane.setStyle("-fx-background-color: black;");
        bPane.setCenter(pane);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        /*pane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT:
                    //Node node = getNodeByRowColumnIndex(pacMan.getY(), pacMan.getX(), pane);
                    pacMan.setXY(pacMan.getX()-1, pacMan.getY());
                    break;
                case RIGHT:
                    pane.add(pacMan, pacMan.getX()+1, pacMan.getY());
                    break;
            }
        });*/

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
                    Wall wall = new Wall();
                    wall.setX(j*GRIDSIZE);
                    wall.setY(i*GRIDSIZE);
                    pane.getChildren().add(wall);
                }/*
                else if (map.accessMapArray()[i][j].getBigDot()) {
                    Dot bigDot = new Dot(true);
                    pane.add(bigDot, j, i);
                    GridPane.setHalignment(bigDot, HPos.CENTER);
                }
                else if (map.accessMapArray()[i][j].getDot()) {
                    Dot dot = new Dot(false);
                    pane.add(dot, j, i);
                    GridPane.setHalignment(dot, HPos.CENTER);
                }
                else if (map.accessMapArray()[i][j].getStarterArea()) {
                    pacMan.setXY(j, i);
                    pane.add(pacMan, pacMan.getX(), pacMan.getY());
                    GridPane.setHalignment(pacMan, HPos.CENTER);
                }*/
            }
        }
    }

    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }



    public static void main(String[] args) {
        launch(args);
    }
}
