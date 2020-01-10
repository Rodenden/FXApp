package sample.mainWindow;


import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.deploy.util.FXLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Film;
import model.User;
import sample.Main;
import sample.util.Load;
import sample.util.LoadEnum;
import service.FilmService;
import service.UserService;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registerButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label infoLabel;

    @FXML
    void initialize() {
        Load load = new Load();
        registerButton.setOnAction(event -> {
            registerButton.getScene().getWindow().hide();
            load.loadWindow(LoadEnum.REGISTER);
        });

        loginButton.setOnAction(event -> {
            UserService service = new UserService();
            User user = null;
            try {
                user = service.getUserByLogin(loginField.getText());
            }catch (Exception ex){
                infoLabel.setText("Такого пользователя не существует");
            }

            if (user != null && user.getPassword().equals(String.valueOf(passwordField.getText().hashCode()))){
                Main.currentUser = user;
                loginButton.getScene().getWindow().hide();
                load.loadWindow(LoadEnum.ACCOUNT);
            } else infoLabel.setText("Неверный пароль");
        });
    }
}