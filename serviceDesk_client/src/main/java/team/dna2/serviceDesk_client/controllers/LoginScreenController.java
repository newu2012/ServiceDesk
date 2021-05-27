package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.ServerManager;
import team.dna2.serviceDesk_client.models.User;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Контроллер экран входа в аккаунт
 */
@Component
public class LoginScreenController {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    //region FXMLNodes
    @FXML private Button LogInButton;
    @FXML private TextField Email;
    @FXML private PasswordField Password;
    @FXML private Button ForgotPasswordButton;
    @FXML private Image LogInScreenImage;
    //endregion

    @FXML
    private void LogInButtonClicked() throws Exception {
        CheckLogIn();
    }

    private void printSomeInfo () throws Exception{ // TODO Вынести отсюда нахер. Здесь должен быть только вызов методов ServerManager
        HttpURLConnection con = ServerManager.SetConnection("developer/licences/");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);
        in.close();
        System.out.println(content);
    }

    /**
     * WIP
     * Проверяет возможность входа в аккаунт с указанными данными
     * @throws NullPointerException Почему-то кидалась, сейчас точно не скажу
     */
    private void CheckLogIn() throws NullPointerException, Exception {
        try {
        printSomeInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        var user = User.users.stream() // Есть пользователь с таким email
                .filter(us -> Email.getText().equals(us.getEmail()))
                .findAny()
                .orElse(null); // Иначе возвращает какой-то бред
        if (user != null && Password.getText().equals(user.getPassword())) { // Есть такой пользователь и пароль совпадает
            User.currentUser = user;
            System.out.println("Successful Log In");
            LogInButton.setText("Вы успешно вошли в аккаунт");

            ScreenManager.OpenTickets();
        }
        else
            LogInButton.setText("Ошибка входа");
    }

    public LoginScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    public void ForgotPasswordLabelClicked(MouseEvent mouseEvent) {
        // TODO Реализовать сброс пароля
    }
}
