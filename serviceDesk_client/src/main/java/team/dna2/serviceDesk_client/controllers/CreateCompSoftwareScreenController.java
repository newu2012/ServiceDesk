package team.dna2.serviceDesk_client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Organisation;
import team.dna2.serviceDesk_client.models.Software;

public class CreateCompSoftwareScreenController {
    //region FXMLNodes
    @FXML
    private TextField CopmSoftwareNameField;
    @FXML
    private TextArea CopmSoftwareArea;
    @FXML
    private Button CreateCopmSoftwareTypeButton;
//endregion

    public void CreateCompSoftwareButtonClicked() {
        //TODO ну ясен хрен тут еще что-то нужно

        System.out.println("CopmSoftwareName=" + CopmSoftwareNameField.getText());
        System.out.println("CopmSoftware=" + CopmSoftwareArea.getText());

        ScreenManager.CloseSecondScreen();
    }


    @FXML
    public void PreviousScreenButtonClicked() {
        ScreenManager.TryShowPreviousScreen();
    }
}