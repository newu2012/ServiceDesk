package team.dna2.serviceDesk_client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import team.dna2.serviceDesk_client.models.Ticket;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@Component
public class MainScreenController implements Initializable {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private ImageView PlaceholderImage;

    @FXML private TableView<Ticket> TicketsTable;
    @FXML public TableColumn<Ticket, Integer> id;
    @FXML public TableColumn<Ticket, String> title;
    @FXML public TableColumn<Ticket, String> creator;
    @FXML public TableColumn<Ticket, String> status;
    @FXML public TableColumn<Ticket, String> creationDate;
    @FXML public TableColumn<Ticket, String> software;
    @FXML public TableColumn<Ticket, String> helper;

    private ObservableList<Ticket> tickets = FXCollections.observableArrayList(
            new Ticket(1, "Работает", "Я", "Открыто", "19.04.2021", "Service-Desk", "Я")
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        title.setCellValueFactory(new PropertyValueFactory<>("Title"));
        creator.setCellValueFactory(new PropertyValueFactory<>("Creator"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        creationDate.setCellValueFactory(new PropertyValueFactory<>("CreationDate"));
        software.setCellValueFactory(new PropertyValueFactory<>("Software"));
        helper.setCellValueFactory(new PropertyValueFactory<>("Helper"));

        TicketsTable.setItems(tickets);
    }

    public MainScreenController () {

    }


    @FXML
    public void OpenPlaceholderImage() {
        PlaceholderImage.setVisible(true);
    }
}
