package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.User;

import java.io.IOException;

/**
 * Контроллер экран входа в аккаунт
 */
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
    private Image LogInScreenImage;

    @FXML
    private void LogInButtonClicked() throws IOException {
        CheckLogIn();
    }

    /**
     * WIP
     * Проверяет возможность входа в аккаунт с указанными данными
     * @throws IOException Из-за поиска fxml
     * @throws NullPointerException Почему-то кидалась, сейчас точно не скажу
     */
    private void CheckLogIn() throws IOException, NullPointerException {
        var user = User.users.stream() // Есть пользователь с таким email
                .filter(us -> Email.getText().equals(us.getEmail()))
                .findAny()
                .orElse(null); // Иначе возвращает какой-то бред
        if (user != null && Password.getText().equals(user.getPassword())) { // Есть такой пользователь и пароль совпадает
            User.currentUser = user;
            System.out.println("Successful Log In");
            LogInButton.setText("Вы успешно вошли в аккаунт");

            ScreenManager.LogIn();
        }
        else
            LogInButton.setText("Ошибка входа");
    }

    public LoginScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }
}
