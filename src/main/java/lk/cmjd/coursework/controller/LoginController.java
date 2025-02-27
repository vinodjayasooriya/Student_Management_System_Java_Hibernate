package lk.cmjd.coursework.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.cmjd.coursework.dto.UserDto;
import lk.cmjd.coursework.service.ServiceFactory;
import lk.cmjd.coursework.service.custom.CourseService;
import lk.cmjd.coursework.service.custom.LoginService;

import java.io.IOException;

public class LoginController {
    private LoginService loginService = (LoginService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LOGIN);

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void login(ActionEvent event) {
       String output = loginService.Login(new UserDto(txtEmail.getText(),txtPassword.getText()));
       if(output.equals("Admin") || output.equals("faculty")){
           System.out.println("Successfully Login");

           displayForm(event,"DashBoard View","/lk/cmjd/coursework/views/admin.fxml");
       }

       else if(output.equals("Student")){
           displayForm(event,"Student View","/lk/cmjd/coursework/views/student.fxml");
        }
       else{
           System.out.println("Login Error");
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Alert Box");
           alert.setHeaderText(null);
           alert.setContentText("Email or password didnt match");
           alert.showAndWait();
       }
    }

    private void displayForm(ActionEvent event,String title,String source) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(source)); // Change to your view file
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();

            // Close the current login window
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
