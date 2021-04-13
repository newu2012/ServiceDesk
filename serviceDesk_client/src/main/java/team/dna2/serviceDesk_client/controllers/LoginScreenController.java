package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LoginScreenController {
    private ApplicationContext context;

    @FXML
    private Button loginButton;

    @FXML
    private void buttonClicked() {
        if (loginButton.getText().equals("Вы успешно вошли в аккаунт!"))
            loginButton.setText("Наконец-то я сделал этот грёбанный контроллер");
        else
            loginButton.setText("Вы успешно вошли в аккаунт!");
    }

    public LoginScreenController() {
    };
}
