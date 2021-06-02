package sample.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Questons.BDVictorin;
import sample.Questons.Facts;

public class FactWindowController {

    private  static ArrayList<Facts> FactsLits = new ArrayList<>();

    @FXML
    private Button ReversButton;

    @FXML
    private Label Commentary;

    @FXML
    private ImageView Imagebox1;
    Image image = new Image("/sample/Arts/1.jpg");

    @FXML
    void initialize() {
        ReversButton.setOnAction(e->{//переход в главное меню
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
        FactsLits = BDVictorin.getFactsLits();//достали лист с фактами
        image = new Image(FactsLits.get(0).getFotoFact());//загрузили изображение
        Commentary.setText(FactsLits.get(0).getFactContent());//Добавили на экран факт
        Imagebox1.setImage(image);//Добавили изображение
    }
}
