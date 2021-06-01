package sample.Controllers;

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
    void initialize() throws SQLException, ClassNotFoundException {
        BDPerson.connectionBDPerson();//Подключаем БД Person
        BDPerson.newTablePerson();//создание таблички person
        BDPerson.newTableWinner();//создание таблички winner
        BDPerson.newTableTitle();//создание таблицы титулов
        ReversButton.setOnAction(e->{//закрытие формы м приложения
            Stage stage = (Stage) ReversButton.getScene().getWindow();
            stage.close();
        });
        WelcomeButton.setOnAction(e->{//Переход на форму с котегориями вопросов
            WelcomeButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/ChoiseTopic.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Выбор игры");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        });
    }
}
