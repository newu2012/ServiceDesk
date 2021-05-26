package team.dna2.serviceDesk_client.controllers;

import javafx.event.ActionEvent;
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
import team.dna2.serviceDesk_client.models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class DeveloperCompendiumScreenController implements Initializable {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    //region FXMLNodes
    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private Text Compendiums;
    @FXML private Text Statistics;
    @FXML private Text MyProfile;
    @FXML private Circle MyProfileCircle;

    @FXML private Text FullName;
    @FXML private Text Role;
    @FXML private Text Email;
    @FXML private Text CreationDate;
    @FXML private ImageView Avatar;
    @FXML private Button ChangeProfileButton;
    @FXML private Button LogOutButton;
    //endregion

    public DeveloperCompendiumScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MyProfileCircle.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getAvatarFileName()))));
        MyProfile.setText(User.currentUser.getFirstName() + " " + User.currentUser.getLastName());
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
     * Переход на экран со списком обращений
     */
    @FXML
    public void LogoClicked() {
        ScreenManager.OpenTickets();
    }

    public void PreviousScreenButtonClicked(MouseEvent mouseEvent) {
        ScreenManager.TryShowPreviousScreen();
    }

    public void AddLicenseButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateLicense();
    }

    public void AddTypeButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateType();
    }

    public void AddCompSoftButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateSoftware();
    }

    public void AddModSoftButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateModSoftware();
    }

    public void AddOwnerButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateOwner();
    }
    //endregion
}
