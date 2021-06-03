package team.dna2.serviceDesk_client.controllers;

import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
import team.dna2.serviceDesk_client.models.*;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DeveloperShowTicketScreen_v2Controller implements Initializable {
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
    @FXML private Text TicketTitle;
    @FXML private Text CreatorFullName;
    @FXML private Text CreatorRole;
    @FXML private ImageView CreatorAvatar;
    @FXML private JFXTextArea TicketDescription;
    @FXML private ChoiceBox<TicketStatus> TicketStatuses;
    @FXML private Text TicketCategory;
    @FXML private Text TicketSoftware;
    @FXML private Text TicketModule;
    @FXML private Text TicketCreationDate;
    @FXML private Text TicketChangeDate;
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

    public DeveloperShowTicketScreen_v2Controller() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MyProfileCircle.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getAvatarFileName()))));
        MyProfile.setText(User.currentUser.getFirstName() + " " + User.currentUser.getLastName());

        //region FieldsSets
        var oStatuses = FXCollections.observableArrayList(TicketStatus.values());

        TicketTitle.setText(Ticket.currentTicket.getTitle());
        CreatorFullName.setText(User.users.get(Ticket.currentTicket.getCreatorId()).getFullName());
        CreatorRole.setText(User.users.get(Ticket.currentTicket.getCreatorId()).getRole());
        CreatorAvatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.users.get(Ticket.currentTicket.getCreatorId()).getAvatarFileName())));
        TicketDescription.setText(Ticket.currentTicket.getDescription());
        TicketStatuses.setItems(oStatuses);
        TicketStatuses.setValue(oStatuses.stream().filter(st -> st.getStatus().equals(Ticket.currentTicket.getStatus().toString())).findFirst().orElse(null));
        TicketCategory.setText(team.dna2.serviceDesk_client.models.Category.categories.get(Ticket.currentTicket.getCategoryId()).getName());
        TicketSoftware.setText(team.dna2.serviceDesk_client.models.Software.software.get(Ticket.currentTicket.getSoftware()).getName());
        TicketModule.setText(team.dna2.serviceDesk_client.models.Software.software.get(Ticket.currentTicket.getSoftware()).getSoftwareModuleById(Ticket.currentTicket.getModuleId()).getName());
        TicketCreationDate.setText(dateFormat.format(Ticket.currentTicket.getCreationDate()));

        TicketCreatorFullName.setText(CreatorFullName.getText());
        TicketCreatorRole.setText(CreatorRole.getText());
        TicketCreatorAvatar.setImage(CreatorAvatar.getImage());
        if (Ticket.currentTicket.getHelperId() == -1) {
            TicketHelperFullName.setItems(FXCollections.observableList(User.users
                    .stream().filter(user -> user.role.get().equals(Role.DEVELOPER.toString()))
                    .collect(Collectors.toList())));
        }
        //endregion

        TicketDescription.addEventHandler(KeyEvent.KEY_TYPED, keyEvent -> {
            int areaRows = TicketDescription.getText().length() / 50 + 1; // TODO Автоматическая выставка высоты от текста
            TicketDescription.setPrefHeight(areaRows * 12);
        });
    }

    @FXML
    public void SetTicketHelper() {
        Ticket.currentTicket.setHelperId(TicketHelperFullName.getValue().getId());

        TicketHelperFullName.setValue(User.users.get(Ticket.currentTicket.getHelperId()));
        TicketHelperRole.setText(User.users.get(Ticket.currentTicket.getHelperId()).getRole());
        TicketHelperAvatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.users.get(Ticket.currentTicket.getHelperId()).getAvatarFileName())));

        Ticket.currentTicket.setChangeDate(new Date());
        TicketChangeDate.setText(dateFormat.format(Ticket.currentTicket.getChangeDate()));
    }

    @FXML
    public void ChangeStatus() {
        Ticket.currentTicket.setStatus(TicketStatuses.getValue());
    }

    @FXML
    public void LogoClicked(MouseEvent mouseEvent) {
        ScreenManager.OpenTickets();
    }

    @FXML
    public void MyProfileClicked(MouseEvent mouseEvent) {
        ScreenManager.OpenMyProfile();
    }

    @FXML
    public void PreviousScreenButtonClicked(MouseEvent mouseEvent) {
        ScreenManager.TryShowPreviousScreen();
    }

    @FXML
    public void AuthorReopenButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void DeveloperRedTicketButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void TicketsClicked(MouseEvent mouseEvent) {
        ScreenManager.OpenTickets();
    }

    @FXML
    public void CompendiumsClicked(MouseEvent mouseEvent) {
        ScreenManager.OpenCompendiums();
    }

    @FXML
    public void StatisticsClicked(MouseEvent mouseEvent) {
        ScreenManager.OpenStatistics();
    }
}
