package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import team.dna2.serviceDesk_client.ScreenManager;

public class CreateTicketCategoryScreenController {
    //region FXMLNodes
    @FXML
    private TextField TypeNameField;
    @FXML
    private TextArea TypeDescriptionArea;
    @FXML
    private Button CreateTicketCategoryButton;
    //endregion

    public void CreateTicketCategoryButtonClicked() {
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