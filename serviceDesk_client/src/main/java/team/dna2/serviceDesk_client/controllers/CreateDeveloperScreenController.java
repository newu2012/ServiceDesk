package team.dna2.serviceDesk_client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Organisation;
import team.dna2.serviceDesk_client.models.Software;

public class CreateDeveloperScreenController {
    //region FXMLNodes
    @FXML
    private TextField DeveloperEmailField;
    @FXML
    private TextField DeveloperSNameField;
    @FXML
    private TextField DeveloperFNameField;
    @FXML
    private TextField DeveloperPasswordField;
    @FXML
    private TextField DeveloperRPasswordField;
    @FXML
    private Button CreateDeveloperButton;
//endregion

    public void CreateDeveloperButtonClicked() {
        //TODO ну ясен хрен тут еще что-то нужно

        System.out.println("DeveloperEmail = " + DeveloperEmailField.getText());
        System.out.println("DeveloperSName = " + DeveloperSNameField.getText());
        System.out.println("DeveloperFName = " + DeveloperFNameField.getText());
        System.out.println("DeveloperPassword = " + DeveloperPasswordField.getText());
        System.out.println("DeveloperRPassword = " + DeveloperRPasswordField.getText());


        ScreenManager.CloseSecondScreen();
    }


    @FXML
    public void PreviousScreenButtonClicked() {
        ScreenManager.TryShowPreviousScreen();
    }

}