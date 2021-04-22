package team.dna2.serviceDesk_client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import team.dna2.serviceDesk_client.models.Category;
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
    @FXML private ChoiceBox<Category> CategoryBox;
    @FXML private ChoiceBox<Software> SoftwareBox;
    @FXML private ChoiceBox<SoftwareModule> ModuleBox;
    @FXML private TextArea DescriptionTextArea;
    @FXML private Button CreateTicketButton;

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

        if (CategoryBox.getValue() == null)
            throw new IllegalStateException(); // TODO Внешняя валидация

        if (SoftwareBox.getValue() == null)
            throw new IllegalStateException(); // TODO Внешняя валидация

        int moduleId = 0;
        if (ModuleBox.getValue() != null)
            moduleId = Software.software
                    .stream().filter(software -> software.softwareModules
                    .stream().filter(softwareModule -> softwareModule.getName().equals(ModuleBox.getValue().getName()))
                    .findFirst().get().getName().equals(ModuleBox.getValue().getName()))
                    .findFirst().get().getSoftwareModules()
                    .stream().filter(softwareModule -> softwareModule.getName().equals(ModuleBox.getValue().getName()))
                    .findFirst().get().getId();

        MainScreenController.AddTicket(
                TitleField.getText(),
                CategoryBox.getValue().getName(),
                SoftwareBox.getValue().getName(),
                moduleId);

        System.out.println("SoftwareId=" + SoftwareBox.getValue().getId() + " ModuleId=" + moduleId);

        Stage stage = (Stage) CreateTicketButton.getScene().getWindow();
        stage.close(); // Закрытие этого окна
    }
}