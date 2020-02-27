package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.lang.reflect.Array;
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
    public ArrayList<Wall> wallArrayList;
    public ArrayList<Dot> dotArrayList;
    public ArrayList<Creature> creatureArrayList;
    private int score;
    @Override
    public void start(Stage primaryStage) throws Exception {
        // System.out.println(Arrays.deepToString(map.accessMapArray()));
        bPane.setStyle("-fx-background-color: black;");
        bPane.setCenter(pane);
        wallArrayList = new ArrayList<>();
        dotArrayList = new ArrayList<>();
        initializeGame();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        pane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT:
                case A:
                    pacMan.setDirection(Direction.LEFT);
                    pacMan.setStartAngle(220);
                    break;
                case RIGHT:
                case D:
                    pacMan.setDirection(Direction.RIGHT);
                    pacMan.setStartAngle(40);
                    break;
                case DOWN:
                case S:
                    pacMan.setDirection(Direction.DOWN);
                    pacMan.setStartAngle(310);
                    break;
                case UP:
                case W:
                    pacMan.setDirection(Direction.UP);
                    pacMan.setStartAngle(130);
                    break;
            }
        });
        checkBounds(pacMan);
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
                    wallArrayList.add(new Wall());
                    Wall w = (Wall) wallArrayList.get(wallArrayList.size()-1);
                    w.setX(j*GRIDSIZE);
                    w.setY(i*GRIDSIZE);
                    pane.getChildren().add(w);
                }
                else if (map.accessMapArray()[i][j].getBigDot()) {
                    dotArrayList.add(new Dot(true));
                    Dot bD = (Dot) dotArrayList.get(dotArrayList.size()-1);
                    // Dot bD = new Dot(true);
                    bD.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    bD.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                    pane.getChildren().add(bD);
                }
                else if (map.accessMapArray()[i][j].getDot()) {
                    dotArrayList.add(new Dot(false));
                    Dot dot = (Dot) dotArrayList.get(dotArrayList.size()-1);
                    // Dot dot = new Dot(false);
                    dot.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    dot.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                    pane.getChildren().add(dot);
                }
                else if (map.accessMapArray()[i][j].getStarterArea()) {
                    // creatureArrayList.add(pacMan);
                    pacMan.setXY(j, i);
                    pacMan.setCenterX((j*GRIDSIZE)+(GRIDSIZE/2)-0.0);
                    pacMan.setCenterY((i*GRIDSIZE)+(GRIDSIZE/2)-0.0);
                }
                else if (map.accessMapArray()[i][j].getBStarterArea()) {
                    // creatureArrayList.add(inky);
                    inky.setXY(j, i);
                    inky.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    inky.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                }
                else if (map.accessMapArray()[i][j].getPStarterArea()) {
                    // creatureArrayList.add(blinky);
                    blinky.setXY(j, i);
                    blinky.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    blinky.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                }
                else if (map.accessMapArray()[i][j].getIStarterArea()) {
                    // creatureArrayList.add(pinky);
                    pinky.setXY(j, i);
                    pinky.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    pinky.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                }
                else if (map.accessMapArray()[i][j].getCStarterArea()) {
                    // creatureArrayList.add(clyde);
                    clyde.setXY(j, i);
                    clyde.setCenterX((j*GRIDSIZE)+GRIDSIZE/2);
                    clyde.setCenterY((i*GRIDSIZE)+GRIDSIZE/2);
                }
            }
        }
        pane.getChildren().addAll(pacMan, blinky, inky, pinky, clyde);
    }
    public void checkBounds(Creature block) {
        for (Wall static_block : wallArrayList) {
            if (block.getBoundsInParent().intersects(static_block.getBoundsInParent())) {
                block.setDirection(null);
                System.out.println(block.getBoundsInParent());
                System.out.println(static_block.getBoundsInParent());
            }
        }
        for (Dot static_block : dotArrayList) {
            if (block.getBoundsInParent().intersects(static_block.getBoundsInParent())) {
                System.out.println(static_block);
                score += static_block.getScore();
                pane.getChildren().remove(static_block);
                dotArrayList.remove(static_block);
                System.out.println(score);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
