package sample.dialogWindows;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;
import sample.util.Load;
import sample.util.LoadEnum;

import java.net.URL;
import java.util.ResourceBundle;

public class AvatarChangeDialogController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitButton;

    @FXML
    private Button myFilmsButton;

    @FXML
    private Label userInfoLabel;

    @FXML
    private ImageView avatarImage;

    @FXML
    private Button avatarChangeButton;

    @FXML
    private Button passwordChangeButton;

    @FXML
    void initialize() {
        Load load = new Load();
        if (Main.currentUser.getAvatarAddress() != null) {
            avatarImage.setImage(new Image(Main.currentUser.getAvatarAddress(), true));
        }
        String result = "Логин: "+ Main.currentUser.getLogin()+"\n"+
                        "Имя: "+Main.currentUser.getName()+"\n"+
                        "Дата рождения: "+Main.currentUser.getDate().toString();
        userInfoLabel.setText(result);


        exitButton.setOnAction(event -> {
            exitButton.getScene().getWindow().hide();
            load.loadWindow(LoadEnum.MAIN);
        });



    }
}
