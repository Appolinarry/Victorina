package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Person.BDPerson;
import sample.Person.Person;

import java.io.IOException;
import java.sql.SQLException;

public class TableWindowController {

    private ObservableList<Person> PersonData = FXCollections.observableArrayList();
    @FXML
    private Button ReversButton;

    @FXML
    private TableView<Person> RecordCount;

    @FXML
    private TableColumn<Person, Integer> NumberPerson;

    @FXML
    private TableColumn<Person, String> Nicname;

    @FXML
    private TableColumn<Person, String> NameGame;

    @FXML
    private TableColumn<Person, Integer> GameCount;

    @FXML
    void ReversButtonAction(ActionEvent event) {
        ReversButton.getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/sample/Windows/ChoiseGameWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Выбор игры");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        //BDPerson.readDB();
        PersonData = BDPerson.getPersonData();
        NumberPerson.setCellValueFactory(new PropertyValueFactory<Person,Integer>("NumberPerson"));
        Nicname.setCellValueFactory(new PropertyValueFactory<Person, String>("Nicname"));
        NameGame.setCellValueFactory(new PropertyValueFactory<Person, String>("NameGame"));
        GameCount.setCellValueFactory(new PropertyValueFactory<Person, Integer>("GameCount"));
        // Заполняем таблицу данными
        RecordCount.setItems(PersonData);
    }
}
