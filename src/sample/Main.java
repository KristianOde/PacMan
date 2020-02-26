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
        bPane.setStyle("-fx-background-color: black;");
        bPane.setCenter(pane);
        System.out.println(gridRows + " " + gridColumns);
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

    public static void main(String[] args) {
        launch(args);
    }
}
