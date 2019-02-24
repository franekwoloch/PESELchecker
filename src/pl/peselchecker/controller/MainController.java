package pl.peselchecker.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import pl.peselchecker.model.DataBase;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

public class MainController implements Initializable{

    @FXML
    private MenuController menuController;

    @FXML
    private DataController dataController;

    @FXML
    private ResultsController resultsController;


    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println(menuController);
        System.out.println(dataController);
        System.out.println(resultsController);

        Button AppButton=menuController.getGoButton();
        AppButton.setOnAction(goButton->dataController.setDataBase(menuController.getDataBase()));
    }
}

