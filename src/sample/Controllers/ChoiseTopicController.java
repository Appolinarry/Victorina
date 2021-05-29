package sample.Controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Person.BDPerson;
import sample.Questons.BDVictorin;
import java.io.IOException;
import java.sql.SQLException;

public class ChoiseTopicController {

    @FXML
    private Button ResultButton;

    @FXML
    private Button ReversButton;

    @FXML
    private Button WhereButton;

    @FXML
    private Button Unicbutton;

    @FXML
    private Button RandomButton;
    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        BDVictorin.connectionBDVictorin();
        BDVictorin.newTable1();
        BDVictorin.newTable3();
        ReversButton.setOnAction(e->{
            ReversButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/sample.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Hellow world!");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        });
        ResultButton.setOnAction(e->{
            ResultButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/TableWindow.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Результаты игр");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        });
        Unicbutton.setOnAction(e->{
            Unicbutton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/PersonalTabel.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Результаты игр");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        });
        RandomButton.setOnAction(e->{
            RandomButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/FotoQueston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Случайные вопросы");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDB0();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}


