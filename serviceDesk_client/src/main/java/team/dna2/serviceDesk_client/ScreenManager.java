package team.dna2.serviceDesk_client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;
import team.dna2.serviceDesk_client.controllers.ClientApplication;
import team.dna2.serviceDesk_client.models.Role;
import team.dna2.serviceDesk_client.models.User;

import java.io.IOException;

@Component
public class ScreenManager {
    private static ClientApplication clientApplication;
    public static Window mainScreen;
    public static Window secondScreen;
    private static String userRole;

    /**
     * Чтобы переключать экраны
     */
    public ScreenManager() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    /**
     * Сохранение основного окна, для дальнейшей работы с ним
     */
    public static void UpdateMainScreen() {
        mainScreen = Stage.getWindows().get(0);
    }

    /**
     *
     */
    public static void UpdateSecondScreen() {
        secondScreen = Stage.getWindows().get(1);
    }

    /**
     * Переключение на экран входа в аккаунт при открытии приложения
     */
    public static void InitToLogIn() {
        clientApplication.ChangeScene("LoginScreen.fxml");
    }

    /**
     * WIP
     * Успешный вход в аккаунт
     */
    public static void LogIn() {
        UpdateMainScreen();
        userRole = User.currentUser.getRole();
        if (Role.DEVELOPER.getRole().equals(userRole))
            clientApplication.ChangeScene("DeveloperTicketsScreen.fxml");
        else
            clientApplication.ChangeScene("MemberTicketsScreen.fxml");
    }

    /**
     * Производит выход из аккаунта, позволяя сменить пользователя.
     */
    public static void LogOut() {
        clientApplication.ChangeScene("LoginScreen.fxml");
    }

    /**
     * Создание обращения в новом окне
     */
    public static void CreateTicket() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(ScreenManager.class.getResource("/views/CreateTicketScreen.fxml"));
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
     */
    public static void ShowTicket() {
        if (Role.DEVELOPER.getRole().equals(userRole))
            clientApplication.ChangeScene("DeveloperShowTicketScreen.fxml");
        else
            clientApplication.ChangeScene("MemberShowTicketScreen.fxml");
    }

    public static void OpenMyProfile() {
        if (Role.DEVELOPER.getRole().equals(userRole))
            clientApplication.ChangeScene("DeveloperProfile.fxml");
        else
            clientApplication.ChangeScene("MemberOrganisation.fxml");
    }

    public static void OpenMyOrganisation() {
        if (Role.OWNER.getRole().equals(userRole))
            clientApplication.ChangeScene("OwnerOrganisation.fxml");
        else if (Role.MEMBER.getRole().equals(userRole))
            clientApplication.ChangeScene("MemberOrganisation.fxml");
        else throw new NotImplementedException();
    }
}
