package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginScreenController {
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

        if (LogInButton.getText().equals("Вы успешно вошли в аккаунт!"))
            LogInButton.setText("Наконец-то я сделал этот грёбанный контроллер");
        else
            LogInButton.setText("Вы успешно вошли в аккаунт!");
    }

    private void CheckLogIn() throws IOException {
    }

    public LoginScreenController() {
    }
}
