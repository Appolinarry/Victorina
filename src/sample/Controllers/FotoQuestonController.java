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
import sample.Person.BDPerson;
import sample.Person.TitleCreator;
import sample.Questons.BDVictorin;
import sample.Questons.Facts;
import sample.Questons.Victorin;

public class FotoQuestonController {

    private  static ArrayList<Victorin> VictorinLits = new ArrayList<>();//List для считывания вопросов
    private  static ArrayList<Facts> FactsLits = new ArrayList<>();//List для считывания фактов
    private  static ArrayList<TitleCreator> TitleCreator = new ArrayList<>();//List для считывания титулов

    private int i = 0;
    private int count = 0;
    private int life = 0;
    private String title;
    private  int totallife;
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
    private Label LifeLabel;

    @FXML
    private Button AnswerButton1;

    @FXML
    void StartButtonAction(ActionEvent event) {
        if ((NickNameText.getText() == "")||(LifeText.getText() == "")){//проверяем заполнены ли поля
            Hellowlabel.setText("Заполните поля!");}else{//если поля не заполнены то просим заполнить
            if (convert(LifeText.getText()) < 1){
                Hellowlabel1.setText("Такого быть не может!");
                Text.clear();
            }else {//делаем видимыми скрытые элементы
                Commentary.setVisible(true);
                AnswerButton.setDisable(false);
                Text.setDisable(false);
                Commentary.setDisable(false);
                AnswerButton.setVisible(true);
                Text.setVisible(true);
                Hellowlabel.setText("Внимание вопрос");// устанавливаем новый текст на верхний Label
                Hellowlabel1.setDisable(true);//Скрываема часть видимых элементов
                Hellowlabel1.setVisible(false);
                StartButton.setDisable(true);
                StartButton.setVisible(false);
                NickNameText.setDisable(true);
                NickNameText.setVisible(false);
                LifeText.setVisible(false);
                LifeText.setDisable(true);
                LifeLabel.setText(LifeText.getText());// устанавливаем количество жизней
                life = convert(LifeText.getText());//количество жизней
                totallife = convert(LifeText.getText());//количество жизней
                //достаем спислк вопросов по теме
                VictorinLits = BDVictorin.getVictorinLits();
                Commentary.setText(VictorinLits.get(i).toString());//выводим вопрос на форму
            }
        }
    }
    @FXML
    void AnswerButtonAction(ActionEvent event) throws SQLException {
        if (Text.getText() == ""){
            Hellowlabel.setText("Введите ответ");
        }else {
            if ((convert(Text.getText()) == 3)||(convert(Text.getText()) == 2)||(convert(Text.getText()) == 1)){
                if (convert(Text.getText())==VictorinLits.get(i).getRightAnswer()) {
                    count+= VictorinLits.get(i).getCountQueston();
                    if (i < 10){
                        i++;}else {
                        try {
                            BDPerson.readDBTitle(VictorinLits.get(0).getNameTopic(), "Yes");
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        TitleCreator = BDPerson.getTitleCreator();
                        title = TitleCreator.get(0).getTitle();
                        Hellowlabel.setText("Вы победили!");
                        Commentary.setDisable(true);
                        Commentary.setVisible(false);
                        Hellowlabel1.setVisible(true);
                        Hellowlabel1.setDisable(false);
                        Hellowlabel1.setText("Вы можете прокомментировать игру в поле ответа\n" +
                                "Вы можете нажать получить приз нажав на кнопку");
                        AnswerButton1.setDisable(false);
                        AnswerButton1.setVisible(true);
                        AnswerButton.setVisible(false);
                        AnswerButton.setDisable(true);
                        Text.clear();
                        BDPerson.writeDB2(NickNameText.getText(),title,VictorinLits.get(i).getNameTopic(),count,
                                FactsLits.get(0).getNumber());
                    }
                    Commentary.setText(VictorinLits.get(i).toString());
                }else{
                    life--;
                    if (life == 0){
                        try {
                            BDPerson.readDBTitle(VictorinLits.get(0).getNameTopic(), "No");
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        TitleCreator = BDPerson.getTitleCreator();
                        title = TitleCreator.get(0).getTitle();
                        Hellowlabel.setText("Вы проиграли!");
                        Commentary.setDisable(true);
                        Commentary.setVisible(false);
                        Hellowlabel1.setVisible(true);
                        Hellowlabel1.setDisable(false);
                        Hellowlabel1.setText("Вы можете прокомментировать игру в поле ответа");
                        ReversButton.setVisible(true);
                        ReversButton.setDisable(false);
                        AnswerButton.setVisible(false);
                        AnswerButton.setDisable(true);
                        Text.clear();
                    }else {
                        i++;
                        Commentary.setText(VictorinLits.get(i).toString());
                        LifeLabel.setText(Integer.toString(life));
                    }
                }
            }else {Hellowlabel.setText("Такого ответа нет");
                System.out.println("Такого ответа нет");
            }
            Text.clear();
        }
    }

    @FXML
    void initialize() {
        ReversButton.setOnAction(e->{//переход на форму с выбором
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
            try {
                BDPerson.writeDB(NickNameText.getText(),VictorinLits.get(i).getNameTopic(), count, title,
                        Text.getText(),totallife, totallife - life);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //скрываем не нужные пока элементы на форме
        Commentary.setVisible(false);
        AnswerButton.setVisible(false);
        Text.setVisible(false);
        Commentary.setDisable(false);
        AnswerButton.setDisable(true);
        Text.setDisable(true);
        ReversButton.setVisible(false);
        ReversButton.setDisable(false);
        AnswerButton1.setDisable(false);
        AnswerButton1.setVisible(false);
        AnswerButton1.setOnAction(e->{
            AnswerButton1.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/FactWindow.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Приз игры");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDPerson.readDBTitle(VictorinLits.get(0).getNameTopic(), "Yes");
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
            TitleCreator = BDPerson.getTitleCreator();
            title = TitleCreator.get(0).getTitle();
            try {
                BDPerson.writeDB(NickNameText.getText(),VictorinLits.get(i).getNameTopic(), count, title,
                        Text.getText(),totallife, totallife - life);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        try {
            BDVictorin.readFact();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        FactsLits = BDVictorin.getFactsLits();

    }
    //перевод из текста в строку
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
