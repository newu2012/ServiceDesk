package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Organization;
import team.dna2.serviceDesk_client.models.Software;

public class CreateLicenseScreenController {
    //region FXMLNodes
    @FXML private TextField SerialNumberField;
    @FXML private ChoiceBox<Organization> OrganisationBox;
    @FXML private ChoiceBox<Software> SoftwareBox;
    @FXML private TextField UsersField;
    @FXML private DatePicker LicenseEndDate;
    @FXML private Button CreateLicenseButton;
    //endregion

    public void CreateLicenseButtonClicked() {
        // TODO SerialNumberField.getText() -> License.SerialNumber

        // TODO OrganisationBox.getValue() -> License.Organisation

        // TODO SoftwareBox.getValue() -> License.Software

        // TODO UsersField.getText() -> License.UsersMax

        // TODO LicenseEndDate.getValue() -> License.EndDate

        System.out.println("SerialNumber=" + SerialNumberField.getText());
        System.out.println("Organisation=" + (OrganisationBox.getValue() != null ? OrganisationBox.getValue().toString() : "null"));
        System.out.println("Software=" + (SoftwareBox.getValue() != null ? SoftwareBox.getValue().toString() : "null"));
        System.out.println("Users=" + UsersField.getText());
        System.out.println("LicenseEndDate=" + (LicenseEndDate.getValue() != null ? LicenseEndDate.getValue().toString() : "null"));

        ScreenManager.CloseSecondScreen();
    }

    @FXML
    public void PreviousScreenButtonClicked() {
        ScreenManager.TryShowPreviousScreen();
    }
}
