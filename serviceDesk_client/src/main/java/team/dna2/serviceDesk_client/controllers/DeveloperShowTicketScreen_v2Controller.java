package team.dna2.serviceDesk_client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import team.dna2.serviceDesk_client.ScreenManager;

public class DeveloperShowTicketScreen_v2Controller {

    @FXML
    public void LogoClicked(MouseEvent mouseEvent) {
    }

    @FXML
    public void MyProfileClicked(MouseEvent mouseEvent) {
    }

    @FXML
    public void MyOrganisationClicked(MouseEvent mouseEvent) {
    }

    @FXML
    public void PreviousScreenButtonClicked(MouseEvent mouseEvent) {
        ScreenManager.TryShowPreviousScreen();
    }

    @FXML
    public void AuthorReopenButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void DeveloperRedTicketButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void TicketsClicked(MouseEvent mouseEvent) {
        ScreenManager.OpenTickets();
    }

    @FXML
    public void CompendiumsClicked(MouseEvent mouseEvent) {
        ScreenManager.OpenCompendiums();
    }

    @FXML
    public void StatisticsClicked(MouseEvent mouseEvent) {
        ScreenManager.OpenStatistics();
    }
}
