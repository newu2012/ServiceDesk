package team.dna2.serviceDesk_client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import team.dna2.serviceDesk_client.models.Software;
import team.dna2.serviceDesk_client.models.SoftwareModule;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер для экрана создания обращения
 */
public class CreateTicketScreenController implements Initializable {
    private ClientApplication clientApplication;

    @FXML private TextField TitleField;
    @FXML private ToggleGroup category;
    @FXML private RadioButton QuestionRadioButton;
    @FXML private RadioButton ErrorRadioButton;
    @FXML private RadioButton FeatureRadioButton;
    @FXML private ChoiceBox<Software> SoftwareBox;
    @FXML private ChoiceBox<SoftwareModule> ModuleBox;
    @FXML private TextArea DescriptionTextArea;
    @FXML private Button CreateTicketButton;

    ObservableList<Software> oSoftware = FXCollections.observableArrayList(Software.software);
    ObservableList<SoftwareModule> modules = FXCollections.observableArrayList(); // TODO в отдельный файл

    /**
     * WIP
     * При старте приложения заполняет элементы с выбором ПО и модулей ПО данными
     * TODO Переделать, потому что надо вынести их в отдельный файл и обновлять при каждом обновлении таблицы обращений
     * @param location Не используется
     * @param resources Не используется
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SoftwareBox.setItems(oSoftware);
        ModuleBox.setItems(modules);
        ModuleBox.setDisable(true);
    }

    public void CreateTicketScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    /**
     * При выборе из выпадающего списка ПО. Добавляет модули ПО для выбранного ПО в список модулей ПО.
     */
    @FXML
    public void SoftwareBoxChanged() {
        String currentSoftware = SoftwareBox.getValue().getName();
        var newModules = oSoftware
                .stream().filter(software -> software.getName().equals(currentSoftware))
                .findFirst()
                .orElse(null).getSoftwareModules();
        modules = FXCollections.observableArrayList(newModules);
        ModuleBox.setItems(modules);
        ModuleBox.setDisable(false);
    }

    @FXML
    public void CreateTicketButtonClicked() {
        if (TitleField.getPromptText().equals(TitleField.getText()) || TitleField.getText().length() < 10)
            throw new IllegalStateException(); // TODO Внешняя валидация

        if (SoftwareBox.getValue() == null)
            throw new IllegalStateException(); // TODO Внешняя валидация

        MainScreenController.AddTicket(
                TitleField.getText(),
                category.getSelectedToggle().toString().split("'")[1], // Костыль для выбора названия radioButton
                SoftwareBox.getValue().getName());

        Stage stage = (Stage) CreateTicketButton.getScene().getWindow();
        stage.close(); // Закрытие этого окна
    }
}