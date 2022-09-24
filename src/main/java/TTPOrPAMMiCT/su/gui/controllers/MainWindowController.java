package TTPOrPAMMiCT.su.gui.controllers;

import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.model.Student;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainWindowController extends FxController {

    public Button editSquad;
    public ChoiceBox boxSquad;
    @FXML
    private TableColumn surname;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn middleName;
    @FXML
    private TableColumn grade;
    @FXML
    private TableColumn score;
    @FXML
    private TableColumn total;
    private EditSquadController editSquadController = new EditSquadController();
    private List<Squad> squads = new ArrayList<>();
    private ObservableList<Squad> squadObservableList;
    private ObservableList<Student> studentObservableList;

    @Override
    void initialize() {
        setCellFactory();
        setValueChoiceBox();
    }

    private void setValueChoiceBox() {
        
    }

    private void setCellFactory() {
        surname.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        middleName.setCellFactory(TextFieldTableCell.forTableColumn());
        grade.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void clickEditListStudent(ActionEvent actionEvent) {

    }

    public void clickEditSquad(ActionEvent actionEvent) {
        if (!editSquadController.isAliveWindow()) {
            editSquadController.createWindow(new ActionEvent(), "editSquad.fxml", "Редактор групп");
            /*while (editSquadController.isAliveWindow()) {
                if (!editSquadController.isAliveWindow()) {
                    //todo
                }
            }*/
        }
    }

    @Override
    public void createWindow(ActionEvent actionEvent, String nameFile, String nameWindow) {
        Parent parent;
        try {
            parent = FXMLLoader.load(getClass().getResource("/windows/fxml/" + nameFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setScene(new Scene(parent));
        getStage().setScene(getScene());
        getStage().setTitle(nameWindow);
        getStage().show();
        setAliveWindow(true);
        getStage().setOnCloseRequest(event -> {
            setAliveWindow(false);
            System.exit(0);
        });
    }
}
