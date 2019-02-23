package pl.peselchecker.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import lombok.Data;

@Data
public class ResultsController {

    @FXML
    private TableView<?> results;

    public void initialize() {

    }
}
