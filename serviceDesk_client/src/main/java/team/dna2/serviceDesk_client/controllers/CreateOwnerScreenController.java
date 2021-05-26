package team.dna2.serviceDesk_client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Organisation;
import team.dna2.serviceDesk_client.models.Software;

public class CreateOwnerScreenController {
    //region FXMLNodes
    @FXML
    private TextField OwnerNameField;
    @FXML
    private TextField OwnerEmailField;
    @FXML
    private TextField OwnerSNameField;
    @FXML
    private TextField OwnerFNameField;
    @FXML
    private TextField OwnerPasswordField;
    @FXML
    private TextField OwnerRPasswordField;
    @FXML
    private Button CreateModSoftwareTypeButton;
//endregion

    public void CreateOwnerButtonClicked() {
        //TODO ну ясен хрен тут еще что-то нужно

        System.out.println("OwnerName = " + OwnerNameField.getText());
        System.out.println("OwnerEmail = " + OwnerEmailField.getText());
        System.out.println("OwnerSName = " + OwnerSNameField.getText());
        System.out.println("OwnerFName = " + OwnerFNameField.getText());
        System.out.println("OwnerPassword = " + OwnerPasswordField.getText());
        System.out.println("OwnerRPassword = " + OwnerRPasswordField.getText());


        ScreenManager.CloseSecondScreen();
    }


    @FXML
    public void PreviousScreenButtonClicked() {
        ScreenManager.TryShowPreviousScreen();
    }

}