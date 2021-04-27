package team.dna2.serviceDesk_client.controllers;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.springframework.context.ApplicationContext;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Software;
import team.dna2.serviceDesk_client.models.SoftwareModule;
import team.dna2.serviceDesk_client.models.Ticket;

import java.net.URL;
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
    @FXML private JFXTextArea Description;
    @FXML private Text Status;
    @FXML private Text Category;
    @FXML private Text Software;
    @FXML private Text Module;
    @FXML private Text CreationDate;
    @FXML private Text ChangeDate;
    @FXML private VBox UsersInfo;
    //endregion

    public MemberShowTicketScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //region FieldsSets
        Title.setText(Ticket.currentTicket.getTitle());
        Description.setText(Ticket.currentTicket.getDescription());
        Status.setText(Ticket.currentTicket.getStatus().toString());
        Category.setText(Ticket.currentTicket.getCategory());
        Software.setText(team.dna2.serviceDesk_client.models.Software.software.get(Ticket.currentTicket.getSoftware()).getName());
        Module.setText(team.dna2.serviceDesk_client.models.Software.software.get(Ticket.currentTicket.getSoftware()).getSoftwareModuleById(Ticket.currentTicket.getModuleId()).getName());
        CreationDate.setText(Ticket.currentTicket.getCreationDate().toString());
        ChangeDate.setText(Ticket.currentTicket.getChangeDate().toString()); // TODO Переделать
        //endregion
        Description.addEventHandler(KeyEvent.KEY_TYPED, keyEvent -> {
            int areaRows = Description.getText().length() / 96 + 1; // TODO Автоматическая выставка высоты от текста
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
     * Производит выход из аккаунта, позволяя сменить пользователя.
     */
    @FXML
    public void LogOutButtonClicked() {
        ScreenManager.LogOut(); // Метод временно назначен на логотип
    }
    //endregion
}

