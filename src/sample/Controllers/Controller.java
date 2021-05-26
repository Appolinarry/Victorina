package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Person.BDPerson;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {

    @FXML
    private Button WelcomeButton;

    @FXML
    private Button ReversButton;

    @FXML
    void WelcomeButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        WelcomeButton.getScene().getWindow().hide();
        Stage primaryStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/sample/Windows/ChoiseGameWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Выбор игры");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void ReversButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Stage stage = (Stage) ReversButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        BDPerson.connectionBDPerson();
        BDPerson.newTable();
    }
}
