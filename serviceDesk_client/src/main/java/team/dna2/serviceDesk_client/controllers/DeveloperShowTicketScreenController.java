package team.dna2.serviceDesk_client.controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.springframework.context.ApplicationContext;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Role;
import team.dna2.serviceDesk_client.models.Ticket;
import team.dna2.serviceDesk_client.models.TicketStatus;
import team.dna2.serviceDesk_client.models.User;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DeveloperShowTicketScreenController implements Initializable {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    //region FXMLNodes
    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private Text Compendiums;
    @FXML private Text Statistics;
    @FXML private Text MyProfile;
    @FXML private Circle MyProfileCircle;
    //endregion
    //region FXMLTicketInfo
    @FXML private Text Title;
    @FXML private Text CreatorFullName;
    @FXML private Text CreatorRole;
    @FXML private ImageView CreatorAvatar;
    @FXML private JFXTextArea Description;
    @FXML private ChoiceBox<TicketStatus> Status;
    @FXML private Text Category;
    @FXML private Text Software;
    @FXML private Text Module;
    @FXML private Text CreationDate;
    @FXML private Text ChangeDate;
    @FXML private VBox TicketInfo;

    @FXML private Text TicketCreatorFullName;
    @FXML private Text TicketCreatorRole;
    @FXML private ImageView TicketCreatorAvatar;
    @FXML private Pane TicketHelperPane;
    @FXML private ChoiceBox<User> TicketHelperFullName;
    @FXML private Text TicketHelperRole;
    @FXML private ImageView TicketHelperAvatar;
    //endregion

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public DeveloperShowTicketScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MyProfileCircle.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getAvatarFileName()))));

        //region FieldsSets
        var oStatuses = FXCollections.observableArrayList(TicketStatus.values());

        Title.setText(Ticket.currentTicket.getTitle());
        CreatorFullName.setText(User.users.get(Ticket.currentTicket.getCreatorId()).getFullName());
        CreatorRole.setText(User.users.get(Ticket.currentTicket.getCreatorId()).getRole());
        CreatorAvatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.users.get(Ticket.currentTicket.getCreatorId()).getAvatarFileName())));
        Description.setText(Ticket.currentTicket.getDescription());
        Status.setItems(oStatuses);
        Status.setValue(oStatuses.stream().filter(st -> st.getStatus().equals(Ticket.currentTicket.getStatus().toString())).findFirst().orElse(null));
        Category.setText(Ticket.currentTicket.getCategory());
        Software.setText(team.dna2.serviceDesk_client.models.Software.software.get(Ticket.currentTicket.getSoftware()).getName());
        Module.setText(team.dna2.serviceDesk_client.models.Software.software.get(Ticket.currentTicket.getSoftware()).getSoftwareModuleById(Ticket.currentTicket.getModuleId()).getName());
        CreationDate.setText(dateFormat.format(Ticket.currentTicket.getCreationDate()));

        TicketCreatorFullName.setText(CreatorFullName.getText());
        TicketCreatorRole.setText(CreatorRole.getText());
        TicketCreatorAvatar.setImage(CreatorAvatar.getImage());
        if (Ticket.currentTicket.getHelperId() == -1) {
            TicketHelperFullName.setItems(FXCollections.observableList(User.users
                    .stream().filter(user -> user.role.get().equals(Role.DEVELOPER.toString()))
                    .collect(Collectors.toList())));
        }
        //endregion

        Description.addEventHandler(KeyEvent.KEY_TYPED, keyEvent -> {
            int areaRows = Description.getText().length() / 50 + 1; // TODO Автоматическая выставка высоты от текста
            Description.setPrefHeight(areaRows * 12);
        });
    }

    public void SetTicketHelper() {
        Ticket.currentTicket.setHelperId(TicketHelperFullName.getValue().getId());

        TicketHelperFullName.setValue(User.users.get(Ticket.currentTicket.getHelperId()));
        TicketHelperRole.setText(User.users.get(Ticket.currentTicket.getHelperId()).getRole());
        TicketHelperAvatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.users.get(Ticket.currentTicket.getHelperId()).getAvatarFileName())));

        Ticket.currentTicket.setChangeDate(new Date());
        ChangeDate.setText(dateFormat.format(Ticket.currentTicket.getChangeDate()));
    }

    @FXML
    public void ChangeStatus() {
        Ticket.currentTicket.setStatus(Status.getValue());
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
    //endregion
}
