package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;

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
        gPane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT:
                    //Node node = getNodeByRowColumnIndex(pacMan.getY(), pacMan.getX(), gPane);
                    pacMan.setXY(pacMan.getX()-1, pacMan.getY());
                    break;
                case RIGHT:
                    gPane.add(pacMan, pacMan.getX()+1, pacMan.getY());
                    break;
            }
        });
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
                    gPane.add(new Wall(), j, i);
                }
                else if (map.accessMapArray()[i][j].getBigDot()) {
                    Dot bigDot = new Dot(true);
                    gPane.add(bigDot, j, i);
                    GridPane.setHalignment(bigDot, HPos.CENTER);
                }
                else if (map.accessMapArray()[i][j].getDot()) {
                    Dot dot = new Dot(false);
                    gPane.add(dot, j, i);
                    GridPane.setHalignment(dot, HPos.CENTER);
                }
                else if (map.accessMapArray()[i][j].getStarterArea()) {
                    pacMan.setXY(j, i);
                    gPane.add(pacMan, pacMan.getX(), pacMan.getY());
                    GridPane.setHalignment(pacMan, HPos.CENTER);
                }
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
