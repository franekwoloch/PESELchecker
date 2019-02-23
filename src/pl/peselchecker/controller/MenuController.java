package pl.peselchecker.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pl.peselchecker.model.Checker;
import pl.peselchecker.model.DataBase;
import pl.peselchecker.model.FileReaderUtil;
import pl.peselchecker.model.Pesel;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import lombok.Data;

@Data
public class MenuController {

    DataBase dataBase=new DataBase();
    DataBase blackList;
    DataBase blackBase;
    DataBase falseList;


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

    public void initialize() {


        blackList=new DataBase();
        blackBase=new DataBase();
        falseList=new DataBase();


        toImportDataBase();
        toImportBlackList();
        goApp();
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

            } catch (Exception e) {
                e.printStackTrace(); //ignore
            }

            try {
                for (int i = 0; i < 1000; i++) {
                    Pesel tempPesel = dataBase.pesels[i];
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
                    Pesel tempPesel = dataBase.pesels[i];
                    System.out.println("Sprawdzam pesel [cyfra kontrolna]: "+tempPesel.getPeselBean(2));

                    if (checker.check(tempPesel) == false) {
                        falseList.pesels[falseIndex] = dataBase.pesels[i];
                        falseList.descriptions[falseIndex] = dataBase.descriptions[i];
                        falseIndex++;
                    }

                }
            }
            catch (Exception e) {
                System.err.println("Baza pusta");
            }
        });
    }


    public void showResult(){

    }

    public void blackExport(){

    }

    public void falseExport(){

    }
}
