package net.matez.pokeUniverseBiomeBuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("main.fxml"));
        controller = (Controller) fxmlLoader.getController();
        primaryStage.setTitle("PokeUniverse Biome Builder --- made by matez");
        primaryStage.setScene(new Scene(root, 1125, 830));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
