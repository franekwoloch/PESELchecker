package pl.peselchecker.controller;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import lombok.Data;

@Data
public class DataController {

    @FXML
    private TableColumn<?, ?> dataBaseResults;

    @FXML
    private TableColumn<?, ?> falseListResults;

    @FXML
    private TableColumn<?, ?> blackListResults;

    public void initialize() {

    }

}
