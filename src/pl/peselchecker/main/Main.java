package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import pl.peselchecker.model.DataBase;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        final String appName = "PeselChecker";
        try {
            Parent parent = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource(
                    "pl/peselchecker/view/Main.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setTitle(appName);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}


