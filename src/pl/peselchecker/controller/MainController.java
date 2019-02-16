package pl.peselchecker.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pl.peselchecker.model.DataBase;
import pl.peselchecker.model.FileReaderUtil;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    DataBase dataBase=new DataBase();
    DataBase blackList=new DataBase();

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



    public void initialize(URL arg0, ResourceBundle arg1) {


        toImportDataBase();


        System.out.println(blackListFile.getText());
        blackListFile.setText("Load black list (optional)");
        blackListFile.setTextFill(Color.web("#ff0000"));

        System.out.println(dataBaseFile.getText());
        dataBaseFile.setText("Load file with data base");
        dataBaseFile.setTextFill(Color.web("#ff0000"));
    }

    public void toImportDataBase(){
        importDataBase.setOnAction(event -> {
            System.out.println("Task import");
            System.out.println(event.getEventType());


            FileReaderUtil fileReader=new FileReaderUtil();
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter(".txt", "*.txt"));
            File file = fc.showOpenDialog(new Stage());
            try {
                dataBase=fileReader.readFile(file);
                dataBaseFile.setText("Loaded file with data base: "+file.toString());
                dataBaseFile.setTextFill(Color.web("#00ff00"));

                } catch (Exception e) {
                    e.printStackTrace(); //ignore
                }
            });
    }

    public void toImportBlackList(){
        importBlackList.setOnAction(event -> {
            System.out.println("Task import");
            System.out.println(event.getEventType());


            FileReaderUtil fileReader=new FileReaderUtil();
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter(".txt", "*.txt"));
            File file = fc.showOpenDialog(new Stage());
            try {
                blackList=fileReader.readFile(file);
                blackListFile.setText("Loaded file with blacklist: "+file.toString());
                blackListFile.setTextFill(Color.web("#00ff00"));

            } catch (Exception e) {
                e.printStackTrace(); //ignore
            }
        });
    }
}

