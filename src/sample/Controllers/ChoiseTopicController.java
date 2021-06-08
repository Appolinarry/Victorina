package sample.Controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Questons.BDVictorin;
import java.io.IOException;
import java.sql.SQLException;

public class ChoiseTopicController {

    @FXML
    private Button ResultButton;

    @FXML
    private Button ReversButton;

    @FXML
    private Button Unicbutton;

    @FXML
    private Button FishButton;

    @FXML
    private Button WormButton;

    @FXML
    private Button SpiderButton;

    @FXML
    private Button TreeButton;

    @FXML
    private Button BrdButton;

    @FXML
    private Button TravelButton;

    @FXML
    private Button DiviseButton;

    @FXML
    private Button WhereTownButton;

    @FXML
    private Button AstronomyButton;

    @FXML
    private Button XlghtButton;

    @FXML
    private Button GalaksyButton;

    @FXML
    private Button ChemicalButton;

    @FXML
    private Button AnothomyButton;

    @FXML
    private Button PeopleButton;

    @FXML
    private Button GeografyButton;

    @FXML
    private Label label2;

    @FXML
    void initialize(){
        try {
            //Подключение к баде занных
            BDVictorin.connectionBDVictorin();
            //если таблицы нет то создаем
            BDVictorin.newTableVictorin();
            //если таблицы нет то создаем
            BDVictorin.newTableFact();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //возврат на форму меню при нажатии на кнопку
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
        //переход на общую таблицу счета при нажатии на кнопку
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
        //переход на таблицу победителей счета при нажатии на кнопку
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
        //переход на форму с вопросами по теме Рыбки при нажатии на кнопку
        FishButton.setOnAction(e->{
            FishButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопросы про рыбок");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Рыбки");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Чкрвячки при нажатии на кнопку
        WormButton.setOnAction(e->{
            WormButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы про червячков");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Червячки");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Паукообразные при нажатии на кнопку
        SpiderButton.setOnAction(e->{
            SpiderButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы про паучкообразных");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Паучкообразные");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Деревья при нажатии на кнопку
        TreeButton.setOnAction(e->{
            TreeButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы про деревья");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Деревья");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Птички при нажатии на кнопку
        BrdButton.setOnAction(e->{
            BrdButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы про птичек");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Птички");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Географические открытия при нажатии на кнопку
        TravelButton.setOnAction(e->{
            TravelButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы про географическтие открытия");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Географические открытия");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Изобретения 20 века при нажатии на кнопку
        DiviseButton.setOnAction(e->{
            DiviseButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы про изобретения 20 века");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Изобретения 20 века");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме А где город при нажатии на кнопку
        WhereTownButton.setOnAction(e->{
            WhereTownButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы про города в разных странах");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("А где город?");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Звездочки при нажатии на кнопку
        AstronomyButton.setOnAction(e->{
            AstronomyButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы про звезды");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Звездочки");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Излучение при нажатии на кнопку
        XlghtButton.setOnAction(e->{
            XlghtButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы про сильное излучение");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Излучение");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Галактика при нажатии на кнопку
        GalaksyButton.setOnAction(e->{
            GalaksyButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы про галактики");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Галактики");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Анотомия при нажатии на кнопку
        AnothomyButton.setOnAction(e->{
            AnothomyButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы по анотомии");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Анотомия");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Химия при нажатии на кнопку
        ChemicalButton.setOnAction(e->{
            ChemicalButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы по химии");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Химия");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме География при нажатии на кнопку
        GeografyButton.setOnAction(e->{
            GeografyButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы по география");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("География");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //переход на форму с вопросами по теме Обществознание при нажатии на кнопку
        PeopleButton.setOnAction(e->{
            PeopleButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Windows/Queston.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.setTitle("Вопроы по обществознание");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            try {
                BDVictorin.readDBQueston("Обществознание");
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}


