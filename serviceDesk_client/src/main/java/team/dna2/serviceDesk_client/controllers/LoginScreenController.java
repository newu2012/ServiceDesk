package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
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

    private Map<String, String> credentials = new HashMap<>();

    @FXML
    private void LogInClicked() throws IOException {
        CheckLogIn();
    }

    private void CheckLogIn() throws IOException, NullPointerException {
        var userPassword = credentials.get(Email.getText());
        if (userPassword != null && userPassword.equals(Password.getText())) {
            System.out.println("Successful Log In");
            LogInButton.setText("Вы успешно вошли в аккаунт");

            clientApplication.ChangeScene("MainScreen.fxml");
        }
        else
            LogInButton.setText("Ошибка входа");
    }

    public LoginScreenController(ClientApplication clientApplication) {
        this.clientApplication = clientApplication;

        credentials.put("admin", "admin");
        credentials.put("newu2011@gmail.com", "admin");
        credentials.put("pasifficid@gmail.com", "admin");
        credentials.put("skywalkersakhno@gmail.com", "admin");
        credentials.put("anna.00kon@gmail.com", "admin");
    }
}
