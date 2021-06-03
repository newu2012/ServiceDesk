package team.dna2.serviceDesk_client.controllers;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.TextField;
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
import team.dna2.serviceDesk_client.models.*;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class MemberShowTicketScreen_v2Controller //implements Initializable
{

    private ClientApplication clientApplication;
    private ApplicationContext context;

    //region FXMLNodes
    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private Text MyProfile;
    @FXML private Circle MyProfileCircle;
    @FXML private Text MyOrganisation;
    @FXML private Circle MyOrganisationCircle;
    //endregion
    //region FXMLTicketInfo
    @FXML private Text TicketTitle;
    @FXML private Text CreatorFullName;
    @FXML private Text CreatorRole;
    @FXML private ImageView CreatorAvatar;
    @FXML private JFXTextArea TicketDescription;
    @FXML private Text TicketStatus;
    @FXML private Text TicketCategory;
    @FXML private Text TicketSoftware;
    @FXML private Text TicketModule;
    @FXML private Text TicketCreationDate;
    @FXML private Text TicketChangeDate;
    @FXML private VBox TicketInfo;

    @FXML private Text TicketCreatorFullName;
    @FXML private Text TicketCreatorRole;
    @FXML private ImageView TicketCreatorAvatar;
 //   @FXML private Pane TicketHelperPane;
    @FXML private Text TicketHelperFullName;
    @FXML private Text TicketHelperRole;
    @FXML private ImageView TicketHelperAvatar;
    //endregion

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    //@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MyProfileCircle.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getAvatarFileName()))));
        MyOrganisationCircle.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getOrgAvatarFileName()))));
        MyProfile.setText(User.currentUser.getFirstName() + " " + User.currentUser.getLastName());

        //region FieldsSets
        TicketTitle.setText(Ticket.currentTicket.getTitle());
        CreatorFullName.setText(User.users.get(Ticket.currentTicket.getCreatorId()).getFullName());
        CreatorRole.setText(User.users.get(Ticket.currentTicket.getCreatorId()).getRole());
        CreatorAvatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.users.get(Ticket.currentTicket.getCreatorId()).getAvatarFileName())));
        TicketDescription.setText(Ticket.currentTicket.getDescription());
        TicketStatus.setText(Ticket.currentTicket.getStatus().toString());
        TicketCategory.setText(team.dna2.serviceDesk_client.models.Category.categories.get(Ticket.currentTicket.getCategoryId()).getName());
        TicketSoftware.setText(team.dna2.serviceDesk_client.models.Software.software.get(Ticket.currentTicket.getSoftware()).getName());
        TicketModule.setText(team.dna2.serviceDesk_client.models.Software.software.get(Ticket.currentTicket.getSoftware()).getSoftwareModuleById(Ticket.currentTicket.getModuleId()).getName());
        TicketCreationDate.setText(dateFormat.format(Ticket.currentTicket.getCreationDate()));

        TicketCreatorFullName.setText(CreatorFullName.getText());
        TicketCreatorRole.setText(CreatorRole.getText());
        TicketCreatorAvatar.setImage(CreatorAvatar.getImage());

//        if (Ticket.currentTicket.getHelperId() == -1)
//            TicketHelperPane.setVisible(false);
//        else {
            TicketHelperFullName.setText(User.users.get(Ticket.currentTicket.getHelperId()).getFullName());
            TicketHelperRole.setText(User.users.get(Ticket.currentTicket.getHelperId()).getRole());
            TicketHelperAvatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.users.get(Ticket.currentTicket.getHelperId()).getAvatarFileName())));

            Ticket.currentTicket.setChangeDate(new Date());
            TicketChangeDate.setText(dateFormat.format(Ticket.currentTicket.getChangeDate()));
//        }
        //endregion

        TicketDescription.addEventHandler(KeyEvent.KEY_TYPED, keyEvent -> {
            int areaRows = TicketDescription.getText().length() / 50 + 1; // TODO Автоматическая выставка высоты от текста
            TicketDescription.setPrefHeight(areaRows * 12);
        });
    }






    public void LogoClicked(MouseEvent mouseEvent) {
    }

    public void MyProfileClicked(MouseEvent mouseEvent) {
    }

    public void MyOrganisationClicked(MouseEvent mouseEvent) {
    }

    public void PreviousScreenButtonClicked(MouseEvent mouseEvent) {
        ScreenManager.TryShowPreviousScreen();
    }


    public void AuthorReopenButtonClicked(ActionEvent actionEvent) {
    }

    public void DeveloperRedTicketButtonClicked(ActionEvent actionEvent) {
    }
}

