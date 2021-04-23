package team.dna2.serviceDesk_client;

import org.springframework.stereotype.Component;
import team.dna2.serviceDesk_client.controllers.ClientApplication;
import team.dna2.serviceDesk_client.models.User;

import java.io.IOException;

@Component
public class ScreenManager {
    private static ClientApplication clientApplication;
    private static String userRole;

    public ScreenManager() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    public static void InitToLogIn() throws IOException {
        clientApplication.ChangeScene("LoginScreen.fxml");
    }

    public static void LogIn() throws IOException {
        userRole = User.currentUser.getRole();
        switch (userRole) {
            case ("Разработчик"):
                clientApplication.ChangeScene("LoginScreen.fxml");
                break;
            default:
                clientApplication.ChangeScene("TicketsUserScreen.fxml");
        }
    }

    /**
     * WIP
     * Производит выход из аккаунта, позволяя сменить пользователя.
     * @throws IOException Нужен из-за смены сцены
     */
    public static void LogOut() throws IOException {
        clientApplication.ChangeScene("LoginScreen.fxml");
    }
}
