package sample.registerWindow;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.User;
import sample.util.Load;
import sample.util.LoadEnum;
import service.UserService;

public class RegisterWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private DatePicker dateField;

    @FXML
    private Button registerButton;

    @FXML
    private Button authButton;

    @FXML
    private Label infoLabel;

    @FXML
    void initialize() {
        UserService service = new UserService();
        registerButton.setOnAction(event -> {
            LocalDate date = dateField.getValue();
            String name = nameField.getText();
            String login = loginField.getText();
            String password = String.valueOf(passwordField.getText().hashCode());
            User user = new User(login, password, name, date);
            try {
                service.newUser(user);
            }catch (org.hibernate.exception.ConstraintViolationException ex){
                infoLabel.setText("Такой пользователь уже есть");
            }
        });

        authButton.setOnAction(event -> {
            Load load = new Load();
            authButton.getScene().getWindow().hide();
            load.loadWindow(LoadEnum.MAIN);
        });


    }
}
