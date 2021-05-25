package team.dna2.serviceDesk_client;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
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

    //region MainMethods
    /**
     * Чтобы переключать экраны
     */
    public ScreenManager() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    /**
     * При закрытии основного экрана, полностью закрывается приложение
     */
    public static void CloseApplicationOnMainScreenClosing() {
        ScreenManager.UpdateMainScreen();
        ScreenManager.mainScreen.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });
    }

    /**
     * Переключает основной экран на предыдущий или закрывает окно, если это дополнительное окно
     */
    public static void TryShowPreviousScreen() {
        if (mainScreen.isFocused())
            ShowPreviousScreen();
        else
            CloseSecondScreen();
    }

    /**
     * Закрытие дополнительного окна.
     */
    public static void CloseSecondScreen() {
        ((Stage) secondScreen).close();
    }
    //endregion

    //region Login
    /**
     * Переключение на экран входа в аккаунт при открытии приложения
     */
    public static void InitToLogIn() {
        UpdateCurrentAndPreviousScreens("LoginScreen.fxml");
    }
    //endregion

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
     * Создание лицензии в новом окне
     */
    public static void CreateLicense() {
        if (CheckForTwoWindows())
            return;

        OpenSecondWindow("CreateLicenseScreen.fxml", "Создание лицензии");
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



    /**
     * Сохранение основного окна, для дальнейшей работы с ним
     */
    public static void UpdateMainScreen() {
        mainScreen = Stage.getWindows().get(0);
    }

    /**
     * Сохранение дополнительного окна, для дальнейшей работы с ним
     */
    public static void UpdateSecondScreen() {
        secondScreen = Stage.getWindows().get(1);
    }

    /**
     * Переключает основной экран на предыдущий.
     */
    public static void ShowPreviousScreen() {
        clientApplication.ChangeScene(previousScreenUrl);
        currentScreenUrl = previousScreenUrl;
    }

    /**
     * Обновляет сведения об нынешнем и прошлом открытых экранах.
     * @param newCurrentStringUrl Полное название файла с экраном, на который нужно переключиться.
     */
    public static void UpdateCurrentAndPreviousScreens(String newCurrentStringUrl) {
        previousScreenUrl = currentScreenUrl;
        currentScreenUrl = newCurrentStringUrl;
        clientApplication.ChangeScene(newCurrentStringUrl);
    }

    /**
     * Проверка на наличие дополнительного окна
     * @return Существует ли открытое дополнительное окно
     */
    public static boolean CheckForTwoWindows() {
        if (Stage.getWindows().size() == 2) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Невозможно открыть более 1 дополнительного окна", ButtonType.CLOSE);
            alert.showAndWait();
            return true;
        }

        return false;
    }

    /**
     * Открыть второе окно и поставить его по центру экрана
     * @param fileName полное название файла экрана, который нужно открыть
     * @param title название экрана, которое отображается в верхней рамке приложения
     */
    public static void OpenSecondWindow(String fileName, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(ScreenManager.class.getResource("/views/" + fileName));

            Scene scene = new Scene(fxmlLoader.load(), 850, 680);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
            stage.requestFocus();

            UpdateSecondScreen();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    //endregion
}
