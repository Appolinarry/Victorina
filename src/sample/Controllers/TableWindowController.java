package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Person.BDPerson;
import sample.Person.Gamer;

import java.io.IOException;
import java.sql.SQLException;

public class TableWindowController {

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
    private TableColumn<Gamer, String> NameGame;

    @FXML
    private TableColumn<Gamer, Integer> GameCount;

    @FXML
    private TableColumn<Gamer, String> Title;

    @FXML
    private TableColumn<Gamer, String> Comment;

    @FXML
    private TableColumn<Gamer, Integer> LifeCount;

    @FXML
    private TableColumn<Gamer, Integer> OurCount;

    @FXML
    private Label label3;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        BDPerson.readDB();//Считываем значения с базы данных
        PersonData = BDPerson.getPersonData();//достаем считанные значения
        // Устанавливаем тип и значение которое должно хранится в колонке
        NumberPerson.setCellValueFactory(new PropertyValueFactory<Gamer,Integer>("NumberPerson"));
        Nicname.setCellValueFactory(new PropertyValueFactory<Gamer, String>("Nicname"));
        NameGame.setCellValueFactory(new PropertyValueFactory<Gamer, String>("NameGame"));
        GameCount.setCellValueFactory(new PropertyValueFactory<Gamer, Integer>("GameCount"));
        Title.setCellValueFactory(new  PropertyValueFactory<Gamer,String>("Title"));
        Comment.setCellValueFactory(new PropertyValueFactory<Gamer,String>("Comment"));
        LifeCount.setCellValueFactory(new PropertyValueFactory<Gamer,Integer>("LifeCount"));
        OurCount.setCellValueFactory(new PropertyValueFactory<Gamer,Integer>("OurCount"));
        // Заполняем таблицу данными
        RecordCount.setItems(PersonData);
        ReversButton.setOnAction(e->{
            //возврат на форму меню при нажатии на кнопку
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
