package pl.peselchecker.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    private MenuItem importDataBase;

    @FXML
    private MenuItem exportDataBase;

    @FXML
    private MenuItem importBlackList;

    @FXML
    private Button goButton;


    @FXML
    private Label dataBaseFile;

    @FXML
    private Label dataBaseText;

    @FXML
    private Label blackListText;

    @FXML
    private Label blackListFile;

    @FXML
    private TableView<?> results;

    @FXML
    private TableColumn<?, ?> dataBaseResults;

    @FXML
    private TableColumn<?, ?> FalseListResults;

    @FXML
    private TableColumn<?, ?> blackListResults;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println(blackListFile.getText());
        blackListFile.setText("Load black list (optional)");
        blackListFile.setTextFill(Color.web("#ff0000"));

        System.out.println(dataBaseFile.getText());
        dataBaseFile.setText("Load file with data base");
        dataBaseFile.setTextFill(Color.web("#ff0000"));
    }

}

