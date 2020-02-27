package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {
    final int GRIDSIZE = 20;
    BorderPane bPane = new BorderPane();
    Pane pane = new Pane();
    GameMap map = new GameMap();
    Creature pacMan = new PacMan();
    Creature inky = new Inky();
    Creature blinky = new Blinky();
    Creature pinky = new Pinky();
    Creature clyde = new Clyde();
    int gridRows = map.accessMapArray().length;
    int gridColumns = map.accessMapArray()[0].length;
    private ArrayList<Shape> cellArrayList;
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Arrays.deepToString(map.accessMapArray()));
        bPane.setStyle("-fx-background-color: black;");
        bPane.setCenter(pane);
        cellArrayList = new ArrayList<>();
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
            checkBounds(pacMan);
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
                    cellArrayList.add(new Wall());
                    Wall w = (Wall) cellArrayList.get(cellArrayList.size()-1);
                    w.setX(j*GRIDSIZE);
                    w.setY(i*GRIDSIZE);
                    pane.getChildren().add(w);
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
                else if (map.accessMapArray()[i][j].getBStarterArea()) {
                    inky.setXY(j, i);
                    inky.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    inky.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                }
                else if (map.accessMapArray()[i][j].getPStarterArea()) {
                    blinky.setXY(j, i);
                    blinky.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    blinky.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                }
                else if (map.accessMapArray()[i][j].getIStarterArea()) {
                    pinky.setXY(j, i);
                    pinky.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    pinky.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                }
                else if (map.accessMapArray()[i][j].getCStarterArea()) {
                    clyde.setXY(j, i);
                    clyde.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    clyde.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                }
            }
        }
        pane.getChildren().addAll(pacMan, blinky, inky, pinky, clyde);
    }

    public void checkBounds(Creature block) {
        for (Shape static_bloc : cellArrayList) {
            if (static_bloc != block) {
                if (block.getBoundsInParent().intersects(static_bloc.getBoundsInParent())) {
                    block.setDirection(null);
                    System.out.println(block.getBoundsInParent());
                    System.out.println(static_bloc.getBoundsInParent());
                }
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
