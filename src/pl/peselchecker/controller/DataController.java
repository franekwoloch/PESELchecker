package pl.peselchecker.controller;


import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import lombok.Data;
import pl.peselchecker.model.DataBase;
import pl.peselchecker.model.Pesel;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

@Data
public class DataController {

    public void setDataBase(DataBase dataBase) {
        //this.dataBase = FXCollections.observableArrayList(Arrays.asList(dataBase.pesels));
    }

    ObservableList<Pesel> dataBase;
    TableView<Pesel> tableView = new TableView<Pesel>(dataBase);


    @FXML
    private TableView<String> dataBaseColumn;

    @FXML
    private TableColumn<Pesel,String> dataBaseResults;


    @FXML
    private TableView<String> falseListColumn;

    //@FXML
    //private TableColumn<Pesel,String> falseListResults;

    @FXML
    private TableView<String> blackListColumn;

    //@FXML
    //private TableColumn<Pesel,String> blackListResults;



    public void initialize() {
        TableColumn<Pesel,String> dataBaseResult = new TableColumn<Pesel,String>("DATABASE");
        dataBaseResult.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Pesel, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Pesel, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().toString());
            }
        });

        tableView.getColumns().add(dataBaseResult);
    }

}
