package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Person.BDPerson;
import sample.Person.Gamer;

import java.io.IOException;
import java.sql.SQLException;

public class PersonalTabbelController {

    private ObservableList<Gamer> PersonData = FXCollections.observableArrayList();

    @FXML
    private Button ReversButton;

    @FXML
    private TableView<Gamer> RecordCount;

    @FXML
    private TableColumn<Gamer, Integer> NumberPerson;

    @FXML
    private TableColumn<Gamer, String> Nicname;

    @FXML
    private TableColumn<Gamer, String> Title;

    @FXML
    private TableColumn<Gamer, String> NameGame;

    @FXML
    private TableColumn<Gamer, Integer> GameCount;

    @FXML
    private TableColumn<Gamer, Integer> FactColum;

    @FXML
    private TextField LifeText;

    @FXML
    private TableView<Gamer> TtlANG;

    @FXML
    private TableColumn<Gamer, String> Ttl2;

    @FXML
    private TableColumn<Gamer, String> G2;

    @FXML
    private TableView<Gamer> Nubr;

    @FXML
    private TableColumn<Gamer, Integer> FctNbr;

    @FXML
    private Label W;

    @FXML
    void SeachButtonActon(ActionEvent event) {
        try {

            if (LifeText.getText() == ""){
                W.setText("Заполните поле!");
            }else {
                BDPerson.SelecName(LifeText.getText());
                LifeText.clear();
                PersonData = BDPerson.getPersonData();//достаем считанные значения
                // Устанавливаем тип и значение которое должно хранится в колонке
                NumberPerson.setCellValueFactory(new PropertyValueFactory<Gamer, Integer>("Number"));
                Nicname.setCellValueFactory(new PropertyValueFactory<Gamer, String>("Nic"));
                Title.setCellValueFactory(new PropertyValueFactory<Gamer, String>("Title"));
                NameGame.setCellValueFactory(new PropertyValueFactory<Gamer, String>("NameGame"));
                GameCount.setCellValueFactory(new PropertyValueFactory<Gamer, Integer>("TotalCount"));
                FactColum.setCellValueFactory(new PropertyValueFactory<Gamer, Integer>("FactNumber"));
                // Заполняем таблицу данными
                RecordCount.setItems(PersonData);
                // Устанавливаем тип и значение которое должно хранится в колонке
                Ttl2.setCellValueFactory(new PropertyValueFactory<Gamer, String>("Title"));
                G2.setCellValueFactory(new PropertyValueFactory<Gamer, String>("NameGame"));
                // Заполняем таблицу данными
                TtlANG.setItems(PersonData);
                FctNbr.setCellValueFactory(new PropertyValueFactory<Gamer, Integer>("FactNumber"));
                Nubr.setItems(PersonData);
            }
        } catch (SQLException throwables) {
            W.setText("Такого игрока нет");
            LifeText.clear();
        }
    }
    @FXML
    void initialize() {
        ReversButton.setOnAction(e->{
            Stage stage = (Stage) ReversButton.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Windows/ChoiseTopic.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Parent root = loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Меню");
            stage.setResizable(false);
            stage.show();
        });
    }
}
