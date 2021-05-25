package sample.Controllers;
import java.io.IOException;
import java.sql.SQLException;
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
import sample.Databases.BDPerson;
import sample.Databases.BDVictorin;
import sample.Databases.Victorin;

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
        if ((convert(Answer.getText()) == 1)||(convert(Answer.getText()) == 2)||(convert(Answer.getText()) == 3)){
            if (convert(Answer.getText()) == VictorinLits.get(i).getRightAnswer()){
                count += 10;
                System.out.println("+");
                if (VictorinLits.size()-1 == i){
                    Queston.setText("\t\t\t\t\t\tВЫ ПОБЕДИЛИ!");
                    try {
                        BDPerson.writeDBPerson(LoginTextFild.getText(),"Виктроина",count+10000);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    Answer.clear();
                    ReversButton.setDisable(false);
                    Answer.setDisable(true);
                    AnswerButton.setDisable(true);
                }else{
                    i++;
                    Queston.setText(String.valueOf(VictorinLits.get(i)));
                    Answer.clear();
                }
            }else{
                try {
                    BDPerson.writeDBPerson(LoginTextFild.getText(),"Виктроина",count);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                Queston.setText("\t\t\t\t\t\tВы проиграли!");
                Answer.clear();
                ReversButton.setDisable(false);
                Answer.setDisable(true);
                AnswerButton.setDisable(true);
            }
        }else {
            Comment.setText("\tВведите ответ в виде одной цифры");
            Answer.clear();
        }
    }

    @FXML
    void WelcomeButtonAction(ActionEvent event) {
        if (LoginTextFild.getText() == ""){
            Comment.setText("\t\tВы не ввели имя игрока.\n Введите имя игрока для начала игры");
        }else {
            Comment.setText("\t\t\tИгра начинается!\n Ответ на вопрос номер варианта ответа");
            AnswerButton.setDisable(false);
            Answer.setDisable(false);
            LoginTextFild.setDisable(true);
            WelcomeButton.setDisable(true);
            try {
                BDVictorin.connectionBDVictorin();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            try {
                BDVictorin.newTable();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            try {
                BDVictorin.readDB();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            VictorinLits = BDVictorin.getVictorinLits();
            Queston.setText(String.valueOf(VictorinLits.get(0)));
        }
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
