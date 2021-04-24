package team.dna2.serviceDesk_client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.stereotype.Component;
import team.dna2.serviceDesk_client.controllers.ClientApplication;
import team.dna2.serviceDesk_client.models.User;

import java.io.IOException;

@Component
public class ScreenManager {
    private static ClientApplication clientApplication;
    public static Window mainScreen;
    private static String userRole;

    public ScreenManager() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    public static void UpdateMainScreen() {
        mainScreen = Stage.getWindows().get(0);
    }

    /**
     * Переключение на экран входа в аккаунт при открытии приложения
     * @throws IOException Нужен из-за смены сцены
     */
    public static void InitToLogIn() throws IOException {
        clientApplication.ChangeScene("LoginScreen.fxml");
    }

    /**
     * Успешный вход в аккаунт
     * @throws IOException Нужен из-за смены сцены
     */
    public static void LogIn() throws IOException {
        UpdateMainScreen();
        userRole = User.currentUser.getRole();
        switch (userRole) {
            case ("Разработчик"):
                clientApplication.ChangeScene("LoginScreen.fxml");
                break;
            default:
                clientApplication.ChangeScene("MemberTicketsScreen.fxml");
        }
    }

    /**
     * Производит выход из аккаунта, позволяя сменить пользователя.
     * @throws IOException Нужен из-за смены сцены
     */
    public static void LogOut() throws IOException {
        clientApplication.ChangeScene("LoginScreen.fxml");
    }

    /**
     * Создание обращения в новом окне
     */
    public static void CreateTicket() {
        String fxmlURL;
        switch (userRole) {
            default:
                fxmlURL = "/views/CreateTicketScreen.fxml";
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(ScreenManager.class.getResource(fxmlURL));
            Scene scene = new Scene(fxmlLoader.load(), 850, 680);
            Stage stage = new Stage();
            stage.setTitle("Создание обращения");
            stage.setScene(scene);
            stage.show();
            stage.requestFocus();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * WIP
     * Экран просмотра обращения
     * @throws IOException Нужен из-за смены сцены
     */
    public static void ShowTicket() throws IOException {
        switch (userRole) {
            case ("Разработчик"):
                clientApplication.ChangeScene("LoginScreen.fxml");
                break;
            default:
                clientApplication.ChangeScene("MemberTicketsScreen.fxml");
        }
    }
}
