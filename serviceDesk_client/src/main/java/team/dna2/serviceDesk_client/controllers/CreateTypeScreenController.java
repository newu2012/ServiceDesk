package team.dna2.serviceDesk_client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Organisation;
import team.dna2.serviceDesk_client.models.Software;

public class CreateTypeScreenController {
    //region FXMLNodes
    @FXML
    private TextField TypeNameField;
    @FXML
    private TextArea TypeDescriptionArea;
    @FXML
    private Button CreateTypeButton;
//endregion

    public void CreateTypeButtonClicked() {
    //TODO ну ясен хрен тут еще что-то нужно

        System.out.println("TypeName=" + TypeNameField.getText());
        System.out.println("TypeDescription=" + TypeDescriptionArea.getText());

        ScreenManager.CloseSecondScreen();
    }


    @FXML
    public void PreviousScreenButtonClicked() {
        ScreenManager.TryShowPreviousScreen();
    }
}