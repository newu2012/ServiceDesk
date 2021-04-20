package team.dna2.serviceDesk_client.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import team.dna2.serviceDesk_client.models.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LoginScreenController {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    @FXML
    private Button LogInButton;
    @FXML
    private TextField Email;
    @FXML
    private PasswordField Password;
    @FXML
    private Button ForgotPasswordButton;
    @FXML
    private Image LogInScreenImage; // Надо обязательно добавлять картинку в target, чтобы она появлялась в приложении

    @FXML
    private void LogInClicked() throws IOException {
        CheckLogIn();
    }

    private void CheckLogIn() throws IOException, NullPointerException {
        var user = User.users.stream().filter(us -> Email.getText().equals(us.getEmail())).findAny().orElse(null);
        if (user != null && Password.getText().equals(user.getPassword())) {
            System.out.println("Successful Log In");
            LogInButton.setText("Вы успешно вошли в аккаунт");

            clientApplication.ChangeScene("MainScreen.fxml");
        }
        else
            LogInButton.setText("Ошибка входа");
    }

    public LoginScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();

    }
}
