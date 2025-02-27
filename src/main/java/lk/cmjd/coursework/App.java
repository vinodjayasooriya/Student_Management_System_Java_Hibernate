package lk.cmjd.coursework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        URL resource =  getClass().getResource("views/admin.fxml");
        assert resource != null;
        Parent root = FXMLLoader.load(resource);
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("This is java FX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}