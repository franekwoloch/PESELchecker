package pl.peselchecker.controller;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import lombok.Data;
import pl.peselchecker.model.Pesel;

@Data
public class DataController {

    @FXML
    private TableColumn<Pesel,String> dataBaseResults;

    @FXML
    private TableColumn<Pesel,String> falseListResults;

    @FXML
    private TableColumn<Pesel,String> blackListResults;

    public void initialize() {

    }

}
