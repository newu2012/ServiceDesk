package team.dna2.serviceDesk_client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Category;
import team.dna2.serviceDesk_client.models.Software;
import team.dna2.serviceDesk_client.models.SoftwareModule;
import team.dna2.serviceDesk_client.models.Ticket;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер для экрана создания обращения
 */
public class CreateTicketScreenController implements Initializable {
    private ClientApplication clientApplication;

    //region FXMLNodes
    @FXML private TextField TitleField;
    @FXML private ChoiceBox<Category> CategoryBox;
    @FXML private ChoiceBox<Software> SoftwareBox;
    @FXML private ChoiceBox<SoftwareModule> ModuleBox;
    @FXML private TextArea DescriptionTextArea;
    @FXML private Button CreateTicketButton;
    //endregion

    ObservableList<Category> oCategories = FXCollections.observableArrayList(Category.categories);
    ObservableList<Software> oSoftware = FXCollections.observableArrayList(Software.software);
    ObservableList<SoftwareModule> modules = FXCollections.observableArrayList();

    /**
     * WIP
     * При старте приложения заполняет элементы с выбором ПО и модулей ПО данными
     * TODO Переделать, потому что надо обновлять при каждом обновлении таблицы обращений
     * @param location Не используется
     * @param resources Не используется
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CategoryBox.setItems(oCategories);
        SoftwareBox.setItems(oSoftware);
        ModuleBox.setItems(modules);

        // TODO Раскоментить, если захотим сделать заранее выбор у боксов
        // CategoryBox.setValue(oCategories.get(0));
        // SoftwareBox.setValue(oSoftware.get(0));

        ModuleBox.setDisable(true);
    }

    public CreateTicketScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    /**
     * При выборе из выпадающего списка ПО. Добавляет модули ПО для выбранного ПО в список модулей ПО.
     */
    @FXML
    public void SoftwareBoxChanged() {
        int currentSoftware = SoftwareBox.getValue().getId();
        var newModules = oSoftware
                .stream().filter(software -> software.getId() == currentSoftware)
                .findFirst()
                .orElse(null).getSoftwareModules();
        modules = FXCollections.observableArrayList(newModules);
        ModuleBox.setItems(modules);
        ModuleBox.setDisable(false);
    }

    @FXML
    public void CreateTicketButtonClicked() {
        boolean validationError = false;

        if (TitleField.getPromptText().equals(TitleField.getText()) || TitleField.getText().length() < 8) {
            TitleField.getStyleClass().add("text-field-error");
            validationError = true;
        }
        else {
            TitleField.getStyleClass().clear();
            TitleField.getStyleClass().addAll("text-input", "create-object-TextField");
        }

        if (CategoryBox.getValue() == null) {
            CategoryBox.getStyleClass().add("choice-box-error");
            validationError = true;
        }
        else {
            CategoryBox.getStyleClass().clear();
            CategoryBox.getStyleClass().addAll("create-object-ChoiceBox", "choice-box");
        }

        if (SoftwareBox.getValue() == null) {
            SoftwareBox.getStyleClass().add("choice-box-error");
            validationError = true;
        }
        else {
            SoftwareBox.getStyleClass().clear();
            SoftwareBox.getStyleClass().addAll("create-object-ChoiceBox", "choice-box");
        }

        if (validationError)
            return;

        int moduleId = -1;

        if (ModuleBox.getValue() != null)
            moduleId = Software.software
                    .stream().filter(software -> software.softwareModules
                    .stream().filter(softwareModule -> softwareModule.getName().equals(ModuleBox.getValue().getName()))
                    .findFirst().get().getName().equals(ModuleBox.getValue().getName()))
                    .findFirst().get().getSoftwareModules()
                    .stream().filter(softwareModule -> softwareModule.getName().equals(ModuleBox.getValue().getName()))
                    .findFirst().get().getId();

        Ticket.AddTicket(
                TitleField.getText(),
                CategoryBox.getValue().getName(),
                SoftwareBox.getValue().getId(),
                moduleId,
                DescriptionTextArea.getText());

        System.out.println("SoftwareId=" + SoftwareBox.getValue().getId() + " ModuleId=" + moduleId);
        ScreenManager.CloseSecondScreen();
    }

    @FXML
    public void PreviousScreenButtonClicked() {
        ScreenManager.TryShowPreviousScreen();
    }
}