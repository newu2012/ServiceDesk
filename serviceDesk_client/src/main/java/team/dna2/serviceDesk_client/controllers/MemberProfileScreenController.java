package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
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
    @FXML private Circle MyProfileCircle;
    @FXML private Text MyOrganisation;
    @FXML private Circle MyOrganisationCircle;

    @FXML private Text FullName;
    @FXML private Text Email;
    @FXML private Text CreationDate;
    @FXML private ImageView Avatar;
    @FXML private Button ChangeProfileButton;
    @FXML private Button LogOutButton;
    @FXML private ImageView OrgAvatar;
    //endregion

    public MemberProfileScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SetProfileInfo();
        ScreenManager.mainScreen.focusedProperty().addListener((obs, oldVal, newVal) -> SetProfileInfo());
        MyProfileCircle.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getAvatarFileName()))));
        MyOrganisationCircle.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getOrgAvatarFileName()))));
        MyProfile.setText(User.currentUser.getFirstName() + " " + User.currentUser.getLastName());
    }

    public void SetProfileInfo() {
        FullName.setText(User.currentUser.getFullName());
        Email.setText(User.currentUser.getEmail());
        CreationDate.setText("29.04.2021"); // TODO Хранить у пользователя дату создания
        Avatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getAvatarFileName())));
        OrgAvatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getOrgAvatarFileName())));
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

    public void PreviousScreenButtonClicked(MouseEvent mouseEvent) {
        ScreenManager.ShowPreviousScreen();
    }
    //endregion
}
