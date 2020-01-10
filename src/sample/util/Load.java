package sample.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Load {
    public void loadWindow(LoadEnum loadEnum){
        String resource = null;
        if (loadEnum != null){
            switch (loadEnum){
                case MAIN: resource = "/sample/mainWindow/main.fxml"; break;
                //case FILMS: resource = "/sample/filmsWindow/films.fxml"; break;
                case ACCOUNT: resource = "/sample/accountWindow/account.fxml"; break;
                case REGISTER: resource = "/sample/registerWindow/register.fxml"; break;
            }
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(resource));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
