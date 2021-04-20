package team.dna2.serviceDesk_client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.awt.event.InputEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateTicketScreenController implements Initializable {
    @FXML private TextField TitleField;
    @FXML private ToggleGroup category;
    @FXML private RadioButton QuestionRadioButton;
    @FXML private RadioButton ErrorRadioButton;
    @FXML private RadioButton FeatureRadioButton;
    @FXML private ChoiceBox<String> SoftwareBox;
    @FXML private ChoiceBox<String> ModuleBox;
    @FXML private TextArea DescriptionTextArea;
    @FXML private Button CreateTicketButton;

    ObservableList<String> software = FXCollections.observableArrayList("Service-Desk", "Other");
    ObservableList<String> modules = FXCollections.observableArrayList("Authentication", "Tickets", "Profile", "Other");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SoftwareBox.setItems(software);
        ModuleBox.setItems(modules);
    }

    public void CreateTicketScreenController() {

    }

    @FXML
    public void CreateTicketButtonClicked() {
        MainScreenController.AddTicket(++MainScreenController.ticketsCounter,
                TitleField.getText(),
                category.getSelectedToggle().toString().split("'")[1],
                SoftwareBox.getValue());

        Stage stage = (Stage) CreateTicketButton.getScene().getWindow();
        stage.close();
    }
}