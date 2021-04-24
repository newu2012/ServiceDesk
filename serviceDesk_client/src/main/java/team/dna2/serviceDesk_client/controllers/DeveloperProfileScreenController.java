package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.springframework.context.ApplicationContext;
import team.dna2.serviceDesk_client.ScreenManager;

public class DeveloperProfileScreenController {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    //region FXMLNodes
    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private Text Compendiums;
    @FXML private Text Statistics;
    @FXML private Text MyProfile;
    @FXML private ImageView MyProfileImage;
    //endregion

    public DeveloperProfileScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    //region DeveloperMenu
    /**
     * Переход на экран со списком обращений
     */
    @FXML
    public void TicketsClicked() {
        ScreenManager.OpenTickets();
    }

    /**
     * WIP
     * Переход на экран со списком справочников
     */
    @FXML
    public void CompendiumsClicked() {
        ScreenManager.OpenCompendiums();
    }

    /**
     * WIP
     * Переход на экран со статистикой
     */
    @FXML
    public void StatisticsClicked() {
        ScreenManager.OpenStatistics();
    }

    /**
     * WIP
     * Открытие экрана личного профиля
     */
    @FXML
    public void MyProfileClicked() {
        ScreenManager.OpenMyProfile();
    }

    /**
     * Производит выход из аккаунта, позволяя сменить пользователя.
     */
    @FXML
    public void LogOutButtonClicked() {
        ScreenManager.LogOut(); // Метод временно назначен на логотип
    }
    //endregion
}
