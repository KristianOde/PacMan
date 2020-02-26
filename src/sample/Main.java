package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
    int gridRows = map.accessMapArray().length;
    int gridColumns = map.accessMapArray()[0].length;
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Arrays.deepToString(map.accessMapArray()));
        bPane.setStyle("-fx-background-color: black;");
        bPane.setCenter(pane);
        initializeGame();
        System.out.println(gridRows + " " + gridColumns);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        pane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT:
                case A:
                    pacMan.setDirection(Direction.LEFT);
                    pacMan.setStartAngle(220);
                    System.out.println(pacMan.getDirection());
                    break;
                case RIGHT:
                case D:
                    pacMan.setDirection(Direction.RIGHT);
                    pacMan.setStartAngle(40);
                    System.out.println(pacMan.getDirection());
                    break;
                case DOWN:
                case S:
                    pacMan.setDirection(Direction.DOWN);
                    pacMan.setStartAngle(310);
                    System.out.println(pacMan.getDirection());
                    break;
                case UP:
                case W:
                    pacMan.setDirection(Direction.UP);
                    pacMan.setStartAngle(130);
                    System.out.println(pacMan.getDirection());
                    break;
            }
            pacMan.move();
        });
        Scene scene = new Scene(bPane);
        System.out.println(pacMan.getDirection());
        primaryStage.setTitle("PacMan");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
        pane.requestFocus();
    }

    public void initializeGame() {
        for (int i=0; i<gridRows;i++) {
            for (int j=0; j<gridColumns; j++) {
                if (!map.accessMapArray()[i][j].getPassable()) {
                    Wall wall = new Wall();
                    wall.setX(j*GRIDSIZE);
                    wall.setY(i*GRIDSIZE);
                    pane.getChildren().add(wall);
                }
                else if (map.accessMapArray()[i][j].getBigDot()) {
                    Dot bigDot = new Dot(true);
                    bigDot.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    bigDot.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                    pane.getChildren().add(bigDot);
                }
                else if (map.accessMapArray()[i][j].getDot()) {
                    Dot dot = new Dot(false);
                    dot.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    dot.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                    pane.getChildren().add(dot);
                }
                else if (map.accessMapArray()[i][j].getStarterArea()) {
                    pacMan.setXY(j, i);
                    pacMan.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    pacMan.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                }
            }
        }
        pane.getChildren().add(pacMan);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
