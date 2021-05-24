package team.dna2.serviceDesk_client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.Window;
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
    public static String currentScreenUrl;
    public static String previousScreenUrl;
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
     * WIP
     * Сохранение дополнительного окна (создание обращения...) чтобы было открыто не больше одного
     */
    public static void UpdateSecondScreen() {
        secondScreen = Stage.getWindows().get(1);
    }

    public static void ShowPreviousScreen() {
        clientApplication.ChangeScene(previousScreenUrl);
        currentScreenUrl = previousScreenUrl;
    }

    public static void UpdateCurrentAndPreviousScreens(String newCurrentStringUrl) {
        previousScreenUrl = currentScreenUrl;
        currentScreenUrl = newCurrentStringUrl;
        clientApplication.ChangeScene(newCurrentStringUrl);
    }

    /**
     * Переключение на экран входа в аккаунт при открытии приложения
     */
    public static void InitToLogIn() {
        UpdateCurrentAndPreviousScreens("LoginScreen.fxml");
    }

    //region Tickets
    /**
     * Открытие списка обращений
     */
    public static void OpenTickets() {
        UpdateMainScreen();
        userRole = User.currentUser.getRole();
        if (Role.DEVELOPER.getRole().equals(userRole))
            UpdateCurrentAndPreviousScreens("DeveloperTicketsScreen_v2.fxml");
        else
            UpdateCurrentAndPreviousScreens("MemberTicketsScreen_v2.fxml");
    }

    /**
     * Производит выход из аккаунта, позволяя сменить пользователя.
     */
    public static void LogOut() {
        UpdateCurrentAndPreviousScreens("LoginScreen.fxml");
    }

    /**
     * Создание обращения в новом окне
     */
    public static void CreateTicket() {
        if (CheckForTwoWindows())
            return;

        OpenSecondWindow("CreateTicketScreen.fxml", "Создание обращения");
    }

    /**
     * Экран просмотра обращения
     */
    public static void ShowTicket() {

        if (Role.DEVELOPER.getRole().equals(userRole))
            UpdateCurrentAndPreviousScreens("DeveloperShowTicketScreen.fxml");
        else
            UpdateCurrentAndPreviousScreens("MemberShowTicketScreen.fxml");
    }
    //endregion

    //region ProfileAndOrganisation
    /**
     * WIP
     * Экран личного профиля
     */
    public static void OpenMyProfile() {
        if (Role.DEVELOPER.getRole().equals(userRole))
            UpdateCurrentAndPreviousScreens("DeveloperProfileScreen.fxml");
        else
            UpdateCurrentAndPreviousScreens("MemberProfileScreen.fxml");
    }

    /**
     * WIP
     * Открывает второе окно для изменения информации профиля
     */
    public static void ChangeProfile() {
        if (CheckForTwoWindows())
            return;

        OpenSecondWindow("ChangeProfileScreen.fxml", "Изменение профиля");
    }

    /**
     * WIP
     * Экран оранизации пользователя
     */
    public static void OpenOrganisation() {
        if (Role.OWNER.getRole().equals(userRole))
            UpdateCurrentAndPreviousScreens("OwnerOrganisationScreen.fxml");
        else if (Role.MEMBER.getRole().equals(userRole))
            UpdateCurrentAndPreviousScreens("MemberOrganisationScreen.fxml");
        else if (Role.DEVELOPER.getRole().equals(userRole))
            UpdateCurrentAndPreviousScreens("DeveloperOrganisationScreen.fxml");
    }
    //endregion

    //region DeveloperOnly
    /**
     * WIP
     * Экран просмотра справочников
     */
    public static void OpenCompendiums() {
        if (Role.DEVELOPER.getRole().equals(userRole))
            UpdateCurrentAndPreviousScreens("DeveloperCompendiumScreen.fxml");
    }

    /**
     * WIP
     * Экран просмотра статистики
     */
    public static void OpenStatistics() {
        if (Role.DEVELOPER.getRole().equals(userRole))
            UpdateCurrentAndPreviousScreens("DeveloperStatisticsScreen.fxml");
    }
    //endregion

    //region Utils
    public static boolean CheckForTwoWindows() {
        if (Stage.getWindows().size() == 2) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Невозможно открыть более 1 дополнительного окна", ButtonType.CLOSE);
            alert.showAndWait();
            return true;
        }

        return false;
    }

    public static void OpenSecondWindow(String fileName, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(ScreenManager.class.getResource("/views/" + fileName));
            Scene scene = new Scene(fxmlLoader.load(), 850, 680);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
            stage.requestFocus();
            secondScreen = stage.getOwner();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    //endregion
}
