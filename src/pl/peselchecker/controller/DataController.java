package pl.peselchecker.controller;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import lombok.Data;
import pl.peselchecker.model.Pesel;

@Data
public class DataController {

    @FXML
    private TableColumn<Pesel> dataBaseResults;

    @FXML
    private TableColumn<Pesel> falseListResults;

    @FXML
    private TableColumn<Pesel> blackListResults;

    public void initialize() {

    }

}
