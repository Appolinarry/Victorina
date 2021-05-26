package sample.Controllers;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Questons.Victorin;

public class VictorinWindowController {
    private   static ArrayList<Victorin> VictorinLits = new ArrayList<>();
    private  int i = 0;
    private int count = 0;
    @FXML
    private Button WelcomeButton;

    @FXML
    private Button ReversButton;

    @FXML
    private TextField LoginTextFild;

    @FXML
    private Label Comment;

    @FXML
    private Label Queston;

    @FXML
    private Button AnswerButton;

    @FXML
    private TextField Answer;

    @FXML
    void AnswerButtonAction(ActionEvent event) {

    }

    @FXML
    void WelcomeButtonAction(ActionEvent event) {
    }
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
    void initialize() {
        AnswerButton.setDisable(true);
        Answer.setDisable(true);
        ReversButton.setDisable(true);
    }

    private static int convert (String str)
    {
        int change;
        try {
            change = Integer.parseInt(str);
        }
        catch (NumberFormatException nfe)
        {
            return 0;
        }
        return change;
    }
}
