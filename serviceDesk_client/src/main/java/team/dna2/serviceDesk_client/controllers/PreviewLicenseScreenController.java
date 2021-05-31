package team.dna2.serviceDesk_client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Organisation;
import team.dna2.serviceDesk_client.models.Software;

public class PreviewLicenseScreenController {
    //region FXMLNodes
    @FXML private TextField PrevSerialNumberField;
    @FXML private ChoiceBox<Organisation> PrevOrganisationBox;
    @FXML private ChoiceBox<Software> PrevSoftwareBox;
    @FXML private TextField PrevUsersField;
    @FXML private DatePicker PrevLicenseEndDate;
    @FXML private Button ChangeLicenseButton;
    //endregion

    public void СhangeLicenseButtonClicked() {
        // TODO SerialNumberField.getText() -> License.SerialNumber

        // TODO OrganisationBox.getValue() -> License.Organisation

        // TODO SoftwareBox.getValue() -> License.Software

        // TODO UsersField.getText() -> License.UsersMax

        // TODO LicenseEndDate.getValue() -> License.EndDate

        //TODO LicenseLebel изменять Просмотр лицензии -> Редактор лицензии

        System.out.println("PrevSerialNumber=" + PrevSerialNumberField.getText());
        System.out.println("PrevOrganisation=" + (PrevOrganisationBox.getValue() != null ? PrevOrganisationBox.getValue().toString() : "null"));
        System.out.println("PrevSoftware=" + (PrevSoftwareBox.getValue() != null ? PrevSoftwareBox.getValue().toString() : "null"));
        System.out.println("PrevUsers=" + PrevUsersField.getText());
        System.out.println("PrevLicenseEndDate=" + (PrevLicenseEndDate.getValue() != null ? PrevLicenseEndDate.getValue().toString() : "null"));

        ScreenManager.CloseSecondScreen();
    }

    @FXML
    public void PreviousScreenButtonClicked() {
        ScreenManager.TryShowPreviousScreen();
    }

    public void SaveLicenseButtonClicked(ActionEvent actionEvent) {

        //TODO маэстро, прошу вас!

    }
}
