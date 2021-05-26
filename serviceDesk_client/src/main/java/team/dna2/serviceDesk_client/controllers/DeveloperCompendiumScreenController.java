package team.dna2.serviceDesk_client.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.springframework.context.ApplicationContext;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.*;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DeveloperCompendiumScreenController implements Initializable {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    //region FXMLNodes
    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private Text Compendiums;
    @FXML private Text Statistics;
    @FXML private Text MyProfile;
    @FXML private Circle MyProfileCircle;

    @FXML private TableView<License> LicensesTable;
    @FXML private TableView<TicketCategory> TicketCategoryTable;
    @FXML private TableView<Software> SoftwareTable;
    @FXML private TableView<SoftwareModule> SoftwareModulesTable;
    @FXML private TableView<User> OwnersTable;
    @FXML private TableView<User> MembersTable;
    @FXML private TableView<User> DevelopersTable;
    //endregion

    //region Table lists
    public ObservableList<License> licenses = FXCollections
            .observableArrayList(License.licenses);
    public ObservableList<TicketCategory> ticketCategories = FXCollections
            .observableArrayList(TicketCategory.ticketCategories);
    public ObservableList<Software> software = FXCollections
            .observableArrayList(Software.software);
    // TODO Переделать softwareModules или саму таблицу, потому что мы раньше думали делать хранение модулей внутри ПО.
    public ObservableList<SoftwareModule> softwareModules = FXCollections
            .observableArrayList(SoftwareModule.softwareModules);
    public ObservableList<User> owners = FXCollections
            .observableArrayList(User.users.stream()
            .filter(u -> u.getRole().equals("Владелец ЛК Заказчика")).collect(Collectors.toList()));
    public ObservableList<User> members = FXCollections
            .observableArrayList(User.users.stream()
            .filter(u -> u.getRole().equals("Представитель Заказчика")).collect(Collectors.toList()));
    public ObservableList<User> developers = FXCollections
            .observableArrayList(User.users.stream()
            .filter(u -> u.getRole().equals("Разработчик")).collect(Collectors.toList()));
    //endregion

    //region LicensesColumns
    @FXML public TableColumn<License, Long> LicenseId;
    @FXML public TableColumn<License, Object> LicenseSerialNumber;
    @FXML public TableColumn<License, Object> LicenseOrganisation;
    @FXML public TableColumn<License, Object> LicenseSoftware;
    @FXML public TableColumn<License, Object> LicenseLimit;
    @FXML public TableColumn<License, String> LicenseStartDate;
    @FXML public TableColumn<License, String> LicenseEndDate;
    //endregion

    //region TicketCategoriesColumns
    //endregion

    //region SoftwareColumns
    //endregion

    //region LicensesColumns
    @FXML public TableColumn<License, Long> SoftwareModuleId;
    @FXML public TableColumn<License, Object> SoftwareModuleName;
    @FXML public TableColumn<License, Object> SoftwareModuleParentName;
    @FXML public TableColumn<License, Object> SoftwareModuleDescription;
    //endregion

    public DeveloperCompendiumScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MyProfileCircle.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/" + User.currentUser.getAvatarFileName()))));
        MyProfile.setText(User.currentUser.getFirstName() + " " + User.currentUser.getLastName());

        initTables();
    }

    public void initTables() {
        initLicensesTable();
        initSoftwareModulesTable();
    }

    public void initLicensesTable() {
        LicenseId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        LicenseSerialNumber.setCellValueFactory(new PropertyValueFactory<>("SerialNumber"));
        LicenseOrganisation.setCellValueFactory(new PropertyValueFactory<>("OrganisationId"));
        LicenseSoftware.setCellValueFactory(new PropertyValueFactory<>("SoftwareId"));
        LicenseLimit.setCellValueFactory(new PropertyValueFactory<>("Limit"));
        LicenseStartDate.setCellValueFactory(ticketStringCellDataFeatures ->
                new SimpleStringProperty(dateFormat.format(ticketStringCellDataFeatures
                        .getValue().getStartDate())));
        LicenseEndDate.setCellValueFactory(ticketStringCellDataFeatures ->
                new SimpleStringProperty(dateFormat.format(ticketStringCellDataFeatures
                        .getValue().getEndDate())));

        licenses = FXCollections.observableArrayList(License.licenses);
        LicensesTable.setItems(licenses);
    }

    public void initSoftwareModulesTable() {
        SoftwareModuleId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        SoftwareModuleName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        SoftwareModuleParentName.setCellValueFactory(new PropertyValueFactory<>("SoftwareId"));
        SoftwareModuleDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));

        softwareModules = FXCollections.observableArrayList(SoftwareModule.softwareModules);
        SoftwareModulesTable.setItems(softwareModules);
    }

    //region Add something to table
    public void AddLicenseButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateLicense();
    }

    public void AddTicketCategoryButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateTicketCategory();
    }

    public void AddCompSoftButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateSoftware();
    }

    public void AddModSoftButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateModSoftware();
    }

    public void AddOwnerButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateOwner();
    }

    public void AddMemberButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateMember();
    }

    public void AddDeveloperButtonClicked(ActionEvent actionEvent) {
        ScreenManager.CreateDeveloper();
    }
    //endregion

    //region DeveloperMenu
    /**
     * Переход на экран со списком обращений
     */
    @FXML
    public void TicketsClicked() {
        ScreenManager.OpenTickets();
    }

    /**
     * WIP
     * Переход на экран со списком справочников
     */
    @FXML
    public void CompendiumsClicked() {
        ScreenManager.OpenCompendiums();
    }

    /**
     * WIP
     * Переход на экран со статистикой
     */
    @FXML
    public void StatisticsClicked() {
        ScreenManager.OpenStatistics();
    }

    /**
     * WIP
     * Открытие экрана личного профиля
     */
    @FXML
    public void MyProfileClicked() {
        ScreenManager.OpenMyProfile();
    }

    /**
     * Переход на экран со списком обращений
     */
    @FXML
    public void LogoClicked() {
        ScreenManager.OpenTickets();
    }

    public void PreviousScreenButtonClicked(MouseEvent mouseEvent) {
        ScreenManager.TryShowPreviousScreen();
    }

    //endregion
}
