package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import team.dna2.serviceDesk_client.models.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер для экрана создания обращения
 */
public class ChangeProfileScreenController implements Initializable {
    private ClientApplication clientApplication;

    //region FXMLNodes
    @FXML private TextField FirstName;
    @FXML private TextField LastName;
    @FXML private TextField Patronymic;
    @FXML private PasswordField OldPassword;
    @FXML private PasswordField NewPassword;
    @FXML private ImageView Avatar;
    @FXML private Button AvatarUploadButton;
    @FXML private Button SaveProfileButton;
    //endregion

    public ChangeProfileScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] fullNameSplit = User.currentUser.getFullName().split(" ");
        LastName.setText(fullNameSplit[0]);
        FirstName.setText(fullNameSplit[1]);
        if (fullNameSplit.length > 2)
            Patronymic.setText(fullNameSplit[2]);
        Avatar.setImage(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getAvatarFileName())));
    }

    @FXML
    public void CreateTicketButtonClicked() {
        boolean validationError = false;

        // TODO Вынести в метод
        //region FullName
        if (FirstName.getText().length() == 0) {
            FirstName.getStyleClass().add("text-field-error");
            validationError = true;
        }
        else {
            FirstName.getStyleClass().clear();
            FirstName.getStyleClass().addAll("text-input", "text-field");
        }

        if (LastName.getText().length() == 0) {
            LastName.getStyleClass().add("text-field-error");
            validationError = true;
        }
        else {
            LastName.getStyleClass().clear();
            LastName.getStyleClass().addAll("text-input", "text-field");
        }
        //endregion
        // TODO Вынести в метод
        //region ChangePassword
        boolean changingPassword = OldPassword.getText().length() > 0 && NewPassword.getText().length() > 0;

        if (!OldPassword.getText().equals(User.currentUser.getPassword())
                && OldPassword.getText().length() > 0) {
            OldPassword.getStyleClass().add("text-field-error");
            validationError = true;
        }
        else {
            OldPassword.getStyleClass().clear();
            OldPassword.getStyleClass().addAll("text-input", "password-field");
        }
        //endregion

        if (validationError)
            return;

        System.out.println("LastName=" + LastName.getText() +
                " FirstName=" + FirstName.getText() +
                " Patronymic=" + Patronymic.getText());

        User.currentUser.setLastName(LastName.getText());
        User.currentUser.setFirstName(FirstName.getText());
        User.currentUser.setPatronymicName(Patronymic.getText());
        User.currentUser.setFullName(LastName.getText() + " " + FirstName.getText() + " " + Patronymic.getText());

        if (changingPassword)
            User.currentUser.setPassword(NewPassword.getText());

        Stage stage = (Stage) SaveProfileButton.getScene().getWindow();
        stage.close(); // Закрытие этого окна
    }
}