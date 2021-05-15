package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.springframework.context.ApplicationContext;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Ticket;
import team.dna2.serviceDesk_client.models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class MemberProfileScreenController implements Initializable {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    //region FXMLNodes
    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private Text MyProfile;
    @FXML private ImageView MyProfileImage;
    @FXML private Text MyOrganisation;
    @FXML private ImageView MyOrganisationImage;

    @FXML private Text FullName;
    @FXML private Text Role;
    @FXML private Text Email;
    @FXML private Text CreationDate;
    @FXML private ImageView Avatar;
    @FXML private Button ChangeProfileButton;
    @FXML private Button LogOutButton;
    //endregion

    public MemberProfileScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SetProfileInfo();
        ScreenManager.mainScreen.focusedProperty().addListener((obs, oldVal, newVal) -> SetProfileInfo());
        MyProfileImage.setImage(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getAvatarFileName())));
    }

    public void SetProfileInfo() {
        FullName.setText(User.currentUser.getFullName());
        Role.setText(User.currentUser.getRole());
        Email.setText(User.currentUser.getEmail());
        CreationDate.setText("29.04.2021"); // TODO Хранить у пользователя дату создания
        Avatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getAvatarFileName())));
    }

    @FXML
    public void ChangeProfile() {
        ScreenManager.ChangeProfile();
    }

    @FXML
    public void LogOut() {
        ScreenManager.LogOut();
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
     * Переход на экран со списком обращений
     */
    @FXML
    public void LogoClicked() {
        ScreenManager.OpenTickets();
    }
    //endregion
}
