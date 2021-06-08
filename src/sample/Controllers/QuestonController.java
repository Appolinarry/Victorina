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

public class QuestonController {
    //List для считывания вопросов
    private  static ArrayList<Victorin> VictorinLits = new ArrayList<>();
    //List для считывания фактов
    private  static ArrayList<Facts> FactsLits = new ArrayList<>();
    //List для считывания титулов
    private  static ArrayList<TitleCreator> TitleCreator = new ArrayList<>();
    //номер вопроса
    private int i = 0;
    //очки в игре
    private int count = 0;
    //количесвто возможностей ошибиться
    private int life = 0;
    //титул игрока
    private String title;
    //количество жизней заданное пользователем
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
    private Label LifeLabel1;

    @FXML
    private Button AnswerButton1;

    @FXML
    void StartButtonAction(ActionEvent event) {
        //проверяем заполнены ли поля
        if ((NickNameText.getText() == "")||(LifeText.getText() == "")){
            //если поля не заполнены то просим заполнить
            Hellowlabel.setText("Заполните поля!");
        }else{
            if ((convert(LifeText.getText()) == 0)){
                Hellowlabel1.setText("Такого быть не может!");
                LifeText.clear();
            }else {
                if ((convert(LifeText.getText()) < 1)||(convert(LifeText.getText())>10)){
                    //оповещаем пользователя
                    Hellowlabel1.setText("Такого быть не может!");
                    //очищаем поле
                    LifeText.clear();
                }else {
                    //делаем видимыми скрытые элементы
                    Commentary.setVisible(true);
                    AnswerButton.setDisable(false);
                    Text.setDisable(false);
                    Commentary.setDisable(false);
                    AnswerButton.setVisible(true);
                    Text.setVisible(true);
                    // устанавливаем новый текст на верхний Label
                    Hellowlabel.setText("Внимание вопрос");
                    //Скрываема часть видимых элементов
                    Hellowlabel1.setDisable(true);
                    Hellowlabel1.setVisible(false);
                    StartButton.setDisable(true);
                    StartButton.setVisible(false);
                    NickNameText.setDisable(true);
                    NickNameText.setVisible(false);
                    LifeText.setVisible(false);
                    LifeText.setDisable(true);
                    // устанавливаем количество жизней
                    LifeLabel.setText(LifeText.getText());
                    //количество жизней
                    life = convert(LifeText.getText());
                    //количество жизней
                    totallife = convert(LifeText.getText());
                    //достаем спислк вопросов по теме
                    VictorinLits = BDVictorin.getVictorinLits();
                    //выводим вопрос на форму
                    Commentary.setText(VictorinLits.get(i).toString());
                }
            }
        }
    }
    @FXML
    void AnswerButtonAction(ActionEvent event) throws SQLException {
        if (Text.getText() == ""){
            //проверяем заполнено ли поле
            Hellowlabel.setText("Введите ответ");
        }else {
            //проверяем ввели ли ответ корректно
            if ((convert(Text.getText()) == 3)||(convert(Text.getText()) == 2)||(convert(Text.getText()) == 1)){
                //проверяем правильный ли ответ
                if (convert(Text.getText())==VictorinLits.get(i).getRightAnswer()) {
                    //добавляем очки
                    count+= VictorinLits.get(i).getCountQueston();
                    if (i < 10){
                        //прибавляем номер вопроса
                        i++;
                    }else {
                        //поздравляем ирока и показываем часть скрытых элементов и скрываем часть видимых
                        Hellowlabel.setText("Вы победили!");
                        Commentary.setDisable(true);
                        Commentary.setVisible(false);
                        Hellowlabel1.setVisible(true);
                        Hellowlabel1.setDisable(false);
                        Hellowlabel1.setText("Вы можете прокомментировать игру в поле ответа\n" +
                                "Вы можете нажать получить приз, нажав на кнопку");
                        AnswerButton1.setDisable(false);
                        AnswerButton1.setVisible(true);
                        AnswerButton.setVisible(false);
                        AnswerButton.setDisable(true);
                        Text.clear();
                    }
                    //показываем новый вопрос
                    Commentary.setText(VictorinLits.get(i).toString());
                }else{
                    //отнимаем жизнь за неправильный ответ
                    life--;
                    LifeLabel.setText(Integer.toString(life));
                    if (life == 0){
                        //если жизни кончились, то достаем титул
                        try {
                            BDPerson.readDBTitle(VictorinLits.get(0).getNameTopic(), "No");
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        TitleCreator = BDPerson.getTitleCreator();
                        title = TitleCreator.get(0).getTitle();
                        //оповещаем игрока о приграше
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
                        //прибавляем номер вопроса
                        i++;
                        //выводим вопрос
                        Commentary.setText(VictorinLits.get(i).toString());
                        // устанавливаем новое количество жизней
                        LifeLabel.setText(Integer.toString(life));
                    }
                }
            }else {Hellowlabel.setText("Такого ответа нет");
            }
            Text.clear();
        }
    }

    @FXML
    void initialize() {
        //возврат на форму меню при нажатии на кнопку
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
            //запись результатов игры
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
            //считываем титулы по теме, при выйграше
            try {
                BDPerson.readDBTitle(VictorinLits.get(0).getNameTopic(), "Yes");
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
            //считываем полученные титулы в List
            TitleCreator = BDPerson.getTitleCreator();
            //достаем титул
            title = TitleCreator.get(0).getTitle();
            //записываем результаты игры в таблицу результатов
            try {
                BDPerson.writeDB(NickNameText.getText(),VictorinLits.get(i).getNameTopic(), count, title,
                        Text.getText(),totallife, totallife - life);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            //переход на форму интересный факт
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
            //запись данных в таблицу подедителей
            try {
                BDPerson.writeDB2(NickNameText.getText(),title,VictorinLits.get(i).getNameTopic(),count,
                        FactsLits.get(0).getNumber());
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
