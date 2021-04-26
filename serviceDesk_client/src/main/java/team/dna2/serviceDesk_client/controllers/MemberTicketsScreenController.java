package team.dna2.serviceDesk_client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;
import team.dna2.serviceDesk_client.ScreenManager;
import team.dna2.serviceDesk_client.models.Ticket;
import team.dna2.serviceDesk_client.models.User;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static team.dna2.serviceDesk_client.models.Ticket.tickets;

/**
 * Контроллер экрана со списком обращений
 */
@Component
public class MemberTicketsScreenController implements Initializable {
    private ClientApplication clientApplication;

    //region FXMLNodes
    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private Text MyProfile;
    @FXML private ImageView MyProfileImage;
    @FXML private Text MyOrganisation;
    @FXML private ImageView MyOrganisationImage;
    @FXML private Button CreateTicketButton;
    @FXML private Button RefreshTableButton;
    @FXML private Button ChangeCreatorFilterButton;
    @FXML private TableView<Ticket> TicketsTable;
    //endregion

    //region TableColumns
    @FXML public TableColumn<Ticket, Integer> id;
    @FXML public TableColumn<Ticket, String> title;
    @FXML public TableColumn<Ticket, String> creator;
    @FXML public TableColumn<Ticket, String> status;
    @FXML public TableColumn<Ticket, String> category;
    @FXML public TableColumn<Ticket, String> creationDate;
    @FXML public TableColumn<Ticket, String> changeDate;
    @FXML public TableColumn<Ticket, String> software;
    @FXML public TableColumn<Ticket, String> helper;
    //endregion

    public ObservableList<Ticket> oTickets = FXCollections.observableArrayList(Ticket.tickets);

    public static boolean showOnlyCurrentUserTickets = false;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy, HH:mm"); // Надо переводить потом дату в строку, но хз как в таблице хранить

    /**
     * WIP
     * Запускается при подготовке старта приложения.
     * Выполняются первичные настройки у столбцов таблицы обращений.
     * @param location По идее ссылка на fxml файл, но не используется
     * @param resources По идее путь до файла с ресурсами, но не используется
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        title.setCellValueFactory(new PropertyValueFactory<>("Title"));
        creator.setCellValueFactory(new PropertyValueFactory<>("Creator"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        category.setCellValueFactory(new PropertyValueFactory<>("Category"));
        creationDate.setCellValueFactory(new PropertyValueFactory<>("CreationDate"));
        changeDate.setCellValueFactory(new PropertyValueFactory<>("ChangeDate"));
        software.setCellValueFactory(new PropertyValueFactory<>("Software"));
        helper.setCellValueFactory(new PropertyValueFactory<>("Helper"));

        oTickets = FXCollections.observableArrayList(Ticket.tickets);
        TicketTableSetRowFactory();
        ScreenManager.mainScreen.focusedProperty().addListener((obs, oldVal, newVal) -> RefreshTicketTable());
        RefreshTicketTable();
    }

    /**
     * Используется для работы со сценами (переходами по экранам). Пока не разобрался как работает.
     */
    public MemberTicketsScreenController() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    /**
     * Чтобы при дабл-клике ЛКМ открывалось окно с просмотром обращения
     */
    public void TicketTableSetRowFactory() {
        TicketsTable.setRowFactory(ticketTableView -> {
            TableRow<Ticket> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Ticket rowData = row.getItem();
                    System.out.println(rowData);
                    Ticket.currentTicket = rowData;
                    ShowTicketUserScreen();
                }
            });
            return row;
        });
    }

    /**
     * Обновление таблицы обращений по желанию пользователя
     */
    @FXML
    public void RefreshTableButtonClicked() {
        RefreshTicketTable();
    }

    /**
     * Обновляет таблицу тикетов на GUI. Если пользователь просил показывать толко его обращения, то делаем так.
     * Переводим лист в читаемый javafx формат, потом показываем.
     */
    @FXML
    public void RefreshTicketTable() {
        if (showOnlyCurrentUserTickets)
            oTickets = FXCollections.observableArrayList(new ArrayList<Ticket> (tickets
                    .stream().filter(ticket -> ticket.getCreatorId() == User.currentUser.getId())
                    .collect(Collectors.toList())));
        else
            oTickets = FXCollections.observableArrayList(tickets);
        TicketsTable.setItems((oTickets));
    }

    /**
     * Изменение с просмотра всех обращений на обращения активного пользователя и обратно при повторном клике
     */
    @FXML
    public void ChangeCreatorFilterButtonClicked() {
        showOnlyCurrentUserTickets = !showOnlyCurrentUserTickets;
        System.out.println("OnlyCUTickets - " + showOnlyCurrentUserTickets);
        RefreshTicketTable();
    }

    /**
     * Запускает набор действий для создания нового окна с созданием обращения
     */
    @FXML
    public void CreateTicketButtonClicked() {
        ScreenManager.CreateTicket();
        RefreshTicketTable(); // Не будет лишним
    }

    /**
     * При двойном клике на ячейку таблицы открывает просмотр обращения
     */
    @FXML
    public void ShowTicketUserScreen() {
        ScreenManager.ShowTicket();
    }

    //region MemberMenu
    /**
     * Переход на экран со списком обращений
     */
    @FXML
    public void TicketsClicked() {
        ScreenManager.OpenTickets();
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
     * WIP
     * Открытие экрана профиля организации
     */
    @FXML
    public void MyOrganisationClicked() {
        ScreenManager.OpenOrganisation();
    }

    /**
     * Производит выход из аккаунта, позволяя сменить пользователя.
     */
    @FXML
    public void LogOutButtonClicked() {
        ScreenManager.LogOut(); // Метод временно назначен на логотип
    }
    //endregion
}
