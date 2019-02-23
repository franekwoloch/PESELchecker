package pl.peselchecker.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

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

    }



}

