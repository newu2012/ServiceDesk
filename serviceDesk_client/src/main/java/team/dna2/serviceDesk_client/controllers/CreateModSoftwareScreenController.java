package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import team.dna2.serviceDesk_client.ScreenManager;

public class CreateModSoftwareScreenController {
    //region FXMLNodes
    @FXML
    private TextField ModSoftwareNameField;
    @FXML
    private ChoiceBox ModSoftwareNameSoftChoiceBox;
    @FXML
    private TextArea ModSoftwareArea;
    @FXML
    private Button CreateModSoftwareButton;
    //endregion

    public void CreateModSoftwareButtonClicked() {
        //TODO ну ясен хрен тут еще что-то нужно

        System.out.println("ModSoftwareName = " + ModSoftwareNameField.getText());
        //TODO System.out.println("ModSoftwareName
        System.out.println("ModSoftware = " + ModSoftwareArea.getText());

        ScreenManager.CloseSecondScreen();
    }

    @FXML
    public void PreviousScreenButtonClicked() {
        ScreenManager.TryShowPreviousScreen();
    }

}