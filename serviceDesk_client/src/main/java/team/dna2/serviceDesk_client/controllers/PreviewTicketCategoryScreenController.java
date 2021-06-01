package team.dna2.serviceDesk_client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Organization;
import team.dna2.serviceDesk_client.models.Software;

public class PreviewTicketCategoryScreenController {
    //region FXMLNodes
    @FXML
    private TextField PrevTypeNameField;
    @FXML
    private TextArea PrevTypeDescriptionArea;
    @FXML
    private Button СhangeCategoryButton;
    @FXML
    private Button SaveCategoryButton;
    //endregion




    public void СhangeCategoryButtonClicked(ActionEvent actionEvent) {
        //TODO ну ясен хрен тут еще что-то нужно

        System.out.println("PrevTypeName=" + PrevTypeNameField.getText());
        System.out.println("PrevTypeDescription=" + PrevTypeDescriptionArea.getText());

        ScreenManager.CloseSecondScreen();

    }

    public void SaveCategoryButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void PreviousScreenButtonClicked() {
        ScreenManager.TryShowPreviousScreen();
    }
}