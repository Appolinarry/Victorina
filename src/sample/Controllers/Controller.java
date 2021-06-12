package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Person.BDPerson;
import java.io.IOException;
import java.sql.SQLException;

public class Controller {

    @FXML
    private Label label1;
    @FXML
    private Button WelcomeButton;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        //Подключаем БД Person
        BDPerson.connectionBDPerson();
        //создание таблички person
        BDPerson.newTablePerson();
        //создание таблички winner
        BDPerson.newTableWinner();
        //создание таблицы титулов
        BDPerson.newTableTitle();
        //Переход на форму с категориями вопросов
        WelcomeButton.setOnAction(e->{
            WelcomeButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/ChoiseTopic.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Основное меню");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        });
    }
}
