package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        GridPane gPane = new GridPane();
        GameMap map = new GameMap();
        gPane.setGridLinesVisible(true);
        for(int i=0; i<=GameMap.cellArray.length(); i++ ) {

        }
        gPane.add(new Circle(50, 50, 50), 0, 0);
        System.out.println(gPane.isGridLinesVisible());

        pane.setCenter(gPane);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
