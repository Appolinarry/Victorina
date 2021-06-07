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
    void initialize(){
        try {
            BDVictorin.connectionBDVictorin();//Подключение к баде занных
            BDVictorin.newTableVictorin();//если таблицы нет то создаем
            BDVictorin.newTableFact();//если таблицы нет то создаем
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ReversButton.setOnAction(e->{//возврат на предыдущую форму при нажатии на кнопку
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
        ResultButton.setOnAction(e->{//переход на общую таблицу счета при нажатии на кнопку
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
        Unicbutton.setOnAction(e->{//переход на общую таблицу счета при нажатии на кнопку
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
        FishButton.setOnAction(e->{//переход на форму с вопросами по теме Рыбки при нажатии на кнопку
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
        WormButton.setOnAction(e->{//переход на форму с вопросами по теме Чкрвячки при нажатии на кнопку
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
        SpiderButton.setOnAction(e->{//переход на форму с вопросами по теме Паукообразные при нажатии на кнопку
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
        TreeButton.setOnAction(e->{//переход на форму с вопросами по теме Деревья при нажатии на кнопку
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
        BrdButton.setOnAction(e->{//переход на форму с вопросами по теме Птички при нажатии на кнопку
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
        TravelButton.setOnAction(e->{//переход на форму с вопросами по теме Географические открытия при нажатии на кнопку
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
        DiviseButton.setOnAction(e->{//переход на форму с вопросами по теме Изобретения 20 века при нажатии на кнопку
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
        WhereTownButton.setOnAction(e->{//переход на форму с вопросами по теме А где город при нажатии на кнопку
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
        AstronomyButton.setOnAction(e->{//переход на форму с вопросами по теме Звездочки при нажатии на кнопку
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
        XlghtButton.setOnAction(e->{//переход на форму с вопросами по теме Излучение при нажатии на кнопку
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
        GalaksyButton.setOnAction(e->{//переход на форму с вопросами по теме Галактика при нажатии на кнопку
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
        AnothomyButton.setOnAction(e->{//переход на форму с вопросами по теме Анотомия при нажатии на кнопку
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
        ChemicalButton.setOnAction(e->{//переход на форму с вопросами по теме Химия при нажатии на кнопку
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
        GeografyButton.setOnAction(e->{//переход на форму с вопросами по теме География при нажатии на кнопку
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
        PeopleButton.setOnAction(e->{//переход на форму с вопросами по теме Обществознание при нажатии на кнопку
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


