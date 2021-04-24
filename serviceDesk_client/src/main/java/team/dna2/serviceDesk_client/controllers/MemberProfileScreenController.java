package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.springframework.context.ApplicationContext;
import team.dna2.serviceDesk_client.ScreenManager;

public class MemberProfileScreenController {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private Text MyProfile;
    @FXML private ImageView MyProfileImage;
    @FXML private Text MyOrganisation;
    @FXML private ImageView MyOrganisationImage;

    public MemberProfileScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    //region MemberMenu
    /**
     * Переход на экран со списком обращений
     */
    @FXML
    public void TicketsClicked() {
        ScreenManager.OpenTickets();
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
     * WIP
     * Открытие экрана профиля организации
     */
    @FXML
    public void MyOrganisationClicked() {
        ScreenManager.OpenOrganisation();
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
