package team.dna2.serviceDesk_client.controllers;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.springframework.context.ApplicationContext;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Software;
import team.dna2.serviceDesk_client.models.SoftwareModule;
import team.dna2.serviceDesk_client.models.Ticket;
import team.dna2.serviceDesk_client.models.User;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class MemberShowTicketScreenController implements Initializable {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    //region FXMLNodes
    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private Text MyProfile;
    @FXML private ImageView MyProfileImage;
    @FXML private Text MyOrganisation;
    @FXML private ImageView MyOrganisationImage;
    //endregion
    //region FXMLTicketInfo
    @FXML private Text Title;
    @FXML private Text CreatorFullName;
    @FXML private Text CreatorRole;
    @FXML private ImageView CreatorAvatar;
    @FXML private JFXTextArea Description;
    @FXML private Text Status;
    @FXML private Text Category;
    @FXML private Text Software;
    @FXML private Text Module;
    @FXML private Text CreationDate;
    @FXML private Text ChangeDate;
    @FXML private VBox UsersInfo;

    @FXML private Text TicketCreatorFullName;
    @FXML private Text TicketCreatorRole;
    @FXML private ImageView TicketCreatorAvatar;
    @FXML private Pane TicketHelperPane;
    @FXML private Text TicketHelperFullName;
    @FXML private Text TicketHelperRole;
    @FXML private ImageView TicketHelperAvatar;
    //endregion

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public MemberShowTicketScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //region FieldsSets
        Title.setText(Ticket.currentTicket.getTitle());
        CreatorFullName.setText(User.users.get(Ticket.currentTicket.getCreatorId()).getFullName());
        CreatorRole.setText(User.users.get(Ticket.currentTicket.getCreatorId()).getRole());
        CreatorAvatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.users.get(Ticket.currentTicket.getCreatorId()).getAvatarFileName())));
        Description.setText(Ticket.currentTicket.getDescription());
        Status.setText(Ticket.currentTicket.getStatus().toString());
        Category.setText(Ticket.currentTicket.getCategory());
        Software.setText(team.dna2.serviceDesk_client.models.Software.software.get(Ticket.currentTicket.getSoftware()).getName());
        Module.setText(team.dna2.serviceDesk_client.models.Software.software.get(Ticket.currentTicket.getSoftware()).getSoftwareModuleById(Ticket.currentTicket.getModuleId()).getName());
        CreationDate.setText(dateFormat.format(Ticket.currentTicket.getCreationDate()));

        TicketCreatorFullName.setText(CreatorFullName.getText());
        TicketCreatorRole.setText(CreatorRole.getText());
        TicketCreatorAvatar.setImage(CreatorAvatar.getImage());
        if (Ticket.currentTicket.getHelperId() == -1)
            TicketHelperPane.setVisible(false);
        else {
            TicketHelperFullName.setText(User.users.get(Ticket.currentTicket.getHelperId()).getFullName());
            TicketHelperRole.setText(User.users.get(Ticket.currentTicket.getHelperId()).getRole());
            TicketHelperAvatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.users.get(Ticket.currentTicket.getHelperId()).getAvatarFileName())));

            Ticket.currentTicket.setChangeDate(new Date());
            ChangeDate.setText(dateFormat.format(Ticket.currentTicket.getChangeDate()));
        }
        //endregion

        Description.addEventHandler(KeyEvent.KEY_TYPED, keyEvent -> {
            int areaRows = Description.getText().length() / 50 + 1; // TODO Автоматическая выставка высоты от текста
            Description.setPrefHeight(areaRows * 12);
        });
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

