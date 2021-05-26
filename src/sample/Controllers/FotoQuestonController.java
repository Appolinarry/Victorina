package sample.Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FotoQuestonController {

    @FXML
    private Label Hellowlabel;

    @FXML
    private Button ReversButton;

    @FXML
    private TextField NickNameText;

    @FXML
    private Label Hellowlabel1;

    @FXML
    private TextField LifeText;

    @FXML
    private Button StartButton;

    @FXML
    private Label Commentary;

    @FXML
    private TextField Text;

    @FXML
    private Button AnswerButton;

    @FXML
    private ImageView Imagebox1;

    Image image = new Image("/sample/Arts/flag/i.jpg");

    @FXML
    void StartButtonAction(ActionEvent event) {
        if ((NickNameText.getText() == "")||(LifeText.getText() == "")){
            Hellowlabel.setText("Заполните поля!");
            if ((convert(LifeText.getText()) == 0)){
                Hellowlabel.setText("Вы неправильно ввели кол-во жизней");
            }
        }else {
            Imagebox1.setVisible(true);
            Commentary.setVisible(true);
            AnswerButton.setDisable(true);
            Text.setDisable(true);
            Imagebox1.setDisable(true);
            Commentary.setDisable(true);
            AnswerButton.setDisable(true);
            Text.setDisable(true);
            Hellowlabel.setVisible(false);
            Hellowlabel.setDisable(false);
            Hellowlabel1.setDisable(false);
            Hellowlabel1.setVisible(false);
            StartButton.setDisable(false);
            StartButton.setVisible(false);
            NickNameText.setDisable(false);
            NickNameText.setVisible(false);
            LifeText.setVisible(false);
            LifeText.setDisable(false);
        }
    }
    @FXML
    void AnswerButtonAction(ActionEvent event) {

    }
    @FXML
    void initialize() {
        ReversButton.setOnAction(e->{
            ReversButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/ChoiseTopic.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Меню");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        });
        Imagebox1.setVisible(false);
        Commentary.setVisible(false);
        AnswerButton.setDisable(false);
        Text.setDisable(false);
        Imagebox1.setDisable(false);
        Commentary.setDisable(false);
        AnswerButton.setDisable(false);
        Text.setDisable(false);
        ReversButton.setVisible(false);
        ReversButton.setDisable(false);
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
