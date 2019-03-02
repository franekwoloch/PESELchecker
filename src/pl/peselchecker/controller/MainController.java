package pl.peselchecker.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import pl.peselchecker.model.Checker;
import pl.peselchecker.model.DataBase;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import pl.peselchecker.model.FileReaderUtil;
import pl.peselchecker.model.Pesel;

import lombok.Data;

@Data

public class MainController implements Initializable{

    File dataFile;

    DataBase dataBase=new DataBase();
    DataBase blackList =new DataBase();
    DataBase falseList = new DataBase();

    ObservableList<Pesel> dataBasePesel= FXCollections.observableArrayList(dataBase.pesels);
    TableView<Pesel> tableView = new TableView<Pesel>(dataBasePesel);



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
    private ResultsController resultsController;

    @FXML
    private TableView<String> dataBaseColumn;

    @FXML
    private TableColumn<Pesel,String> dataBaseResults;


    @FXML
    private TableView<String> falseListColumn;

    @FXML
    private TableColumn<Pesel,String> falseListResults;

    @FXML
    private TableView<String> blackListColumn;

    @FXML
    private TableColumn<Pesel,String> blackListResults;


    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println(resultsController);

        toImportDataBase();
        toImportBlackList();
        goApp();
        System.out.println("goApp");
        showData();
        showResult();
        blackExport();
        falseExport();

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
                System.out.println(dataBase.pesels.get(0).toString());

            } catch (Exception e) {
                e.printStackTrace(); //ignore
            }

            try {
                for (int i = 0; i <dataBasePesel.size(); i++) {
                    Pesel tempPesel = dataBase.pesels.get(i);
                    System.out.println("Zaimportowano pesel [wynik kontrolny]: "+tempPesel.getPeselBean(0));
                }
            } catch (Exception e) {
                System.err.println("Baza pusta");
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

    public void goApp(){

        goButton.setOnAction(event -> {
            System.out.println("GO task");
            System.out.println(event.getEventType());
        /**/
            int falseIndex=0;

            try {
                Checker checker = new Checker();
                for (int i = 0; i < 1000; i++) {
                    Pesel tempPesel = dataBase.pesels.get(i);
                    System.out.println("Sprawdzam pesel [cyfra kontrolna]: "+tempPesel.getPeselBean(2));

                    if (checker.check(tempPesel) == false) {
                        falseList.pesels.add(dataBase.pesels.get(i));
                        falseList.descriptions.add(dataBase.descriptions.get(i));
                        falseIndex++;
                    }

                }
            }
            catch (Exception e) {
                System.err.println("Baza pusta");
            }
        });
    }

    public void showData(){
        TableColumn<Pesel,String> dataBaseResult = new TableColumn<Pesel,String>("DATABASE");
        dataBaseResult.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Pesel, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Pesel, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().toString());
            }
        });

        tableView.getColumns().add(dataBaseResult);
    }


    public void showResult(){

    }

    public void blackExport(){

    }

    public void falseExport(){

    }
}

