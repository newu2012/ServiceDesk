package team.dna2.serviceDesk_client.controllers;

import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.springframework.context.ApplicationContext;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class MemberOrganisationScreenController implements Initializable {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    //region FXMLNodes
    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private Text MyProfile;
    @FXML private Circle MyProfileCircle;
    @FXML private Text MyOrganisation;
    @FXML private Circle MyOrganisationCircle;
    @FXML private Pane OrganisationMainPane;
    //endregion
    //region FXMLOrganisationInfo
    @FXML private JFXTabPane MainTabPane;
    //endregion

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MyProfileCircle.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getAvatarFileName()))));
        MyOrganisationCircle.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getOrgAvatarFileName()))));

        MainTabPane = new JFXTabPane();
        OrganisationMainPane.getChildren().add(MainTabPane);

        //region MainTabSets
        MainTabPane.setLayoutX(133);
        MainTabPane.setLayoutY(59);
        MainTabPane.setMinWidth(1100);
        MainTabPane.setMaxWidth(1100);
        MainTabPane.setMinHeight(580);
        MainTabPane.setMaxHeight(580);
        MainTabPane.setTabMinHeight(30);
        MainTabPane.setTabMaxHeight(30);
        //endregion

        var infoTab = new Tab();
        var membersTab = new Tab();
        var licensesTab = new Tab();

        infoTab.setText("Информация об организации");
        membersTab.setText("Список представителей заказчика");
        licensesTab.setText("Список лицензий");

        MainTabPane.getTabs().addAll(infoTab,membersTab, licensesTab);
    }

    public MemberOrganisationScreenController() {
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
     * Переход на экран со списком обращений
     */
    @FXML
    public void LogoClicked() {
        ScreenManager.OpenTickets();
    }
    //endregion
}
