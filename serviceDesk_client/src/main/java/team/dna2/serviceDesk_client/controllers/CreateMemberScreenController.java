package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import team.dna2.serviceDesk_client.ScreenManager;

public class CreateMemberScreenController {
    //region FXMLNodes
    @FXML
    private TextField MemberEmailField;
    @FXML
    private TextField MemberSNameField;
    @FXML
    private TextField MemberFNameField;
    @FXML
    private ChoiceBox MemberChoiceBox;
    @FXML
    private TextField MemberPasswordField;
    @FXML
    private TextField MemberRPasswordField;
    @FXML
    private Button CreateMemberButton;
//endregion

    public void CreateMemberButtonClicked() {
        //TODO ну ясен хрен тут еще что-то нужно

        System.out.println("MemberEmail = " + MemberEmailField.getText());
        System.out.println("MemberSName = " + MemberSNameField.getText());
        System.out.println("MemberFName = " + MemberFNameField.getText());
        //TODO System.out.println("MemberChoice = " + MemberChoiceBox.getText());
        System.out.println("MemberPassword = " + MemberPasswordField.getText());
        System.out.println("MemberRPassword = " + MemberRPasswordField.getText());


        ScreenManager.CloseSecondScreen();
    }


    @FXML
    public void PreviousScreenButtonClicked() {
        ScreenManager.TryShowPreviousScreen();
    }

}