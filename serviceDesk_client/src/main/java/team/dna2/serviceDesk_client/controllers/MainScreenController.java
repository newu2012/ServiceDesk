package team.dna2.serviceDesk_client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import team.dna2.serviceDesk_client.models.Ticket;
import team.dna2.serviceDesk_client.models.User;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import static team.dna2.serviceDesk_client.models.Ticket.tickets;

/**
 * Контроллер экрана со списком обращений
 */
@Component
public class MainScreenController implements Initializable {
    public static MainScreenController mainScreenController;
    private ClientApplication clientApplication;
    private ApplicationContext context;

    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private ImageView PlaceholderImage;
    @FXML private Button CreateTicketButton;
    @FXML private Button RefreshTableButton;
    @FXML private TableView<Ticket> TicketsTable;

    @FXML public TableColumn<Ticket, Integer> id;
    @FXML public TableColumn<Ticket, String> title;
    @FXML public TableColumn<Ticket, String> creator;
    @FXML public TableColumn<Ticket, String> status;
    @FXML public TableColumn<Ticket, String> category;
    @FXML public TableColumn<Ticket, String> creationDate;
    @FXML public TableColumn<Ticket, String> changeDate;
    @FXML public TableColumn<Ticket, String> software;
    @FXML public TableColumn<Ticket, String> helper;

    public ObservableList<Ticket> oTickets = FXCollections.observableArrayList(Ticket.tickets);
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

        MainScreenController();
        oTickets = FXCollections.observableArrayList(Ticket.tickets);
        RefreshTicketTable();
    }

    /**
     * Используется для работы со сценами (переходами по экранам). Пока не разобрался как работает.
     */
    public void MainScreenController() {
        mainScreenController = this;
        clientApplication = ClientApplication.GetClientApplicationInstance();

        // Используется для добавления начальных данных в таблицу при запуске. Запускается при каждом входе пользователя.
        // Может быть древним и не используемым
        // try {
        //     tickets.add(
        //             new Ticket( "Новое обращение", User.currentUser.getFullName(), User.currentUser.getId(), "Открыто", "Ошибка", dateFormat.parse("20:04:2021, 15:14"), null, "Service-Desk", null)
        //     );
        // } catch (ParseException e) {
        //     e.printStackTrace();
        // }
    }

    /**
     * WIP
     * Основной метод создания обращения, используется в GUI.
     * @param title Название обращения, минимум 10 символов
     * @param category Категория обращения, на выбор одна из 3 кнопок
     * @param software Название ПО, выбирается пользователем
     *                 надо ещё module, но пока не сделал
     */
    public static void AddTicket(
            String title,
            String category,
            String software) {
        tickets.add(new Ticket(
                title,
                User.currentUser.getFullName(),
                User.currentUser.getId(),
                "Открыто",
                category,
                new Date(),
                null,
                software,
                null
        ));

        mainScreenController.RefreshTicketTable();

        for (Ticket ticket : tickets) {
            System.out.println("Id - " + ticket.getId() + ", Category - " + ticket.getCategory() + ", Software - " + ticket.getSoftware());
        }
    }

    @FXML
    public void RefreshTableButtonClicked() {
        RefreshTicketTable();
    }

    /**
     * Обновляет таблицу тикетов на GUI. Сначала переводим лист в читаемый javafx формат, потом показываем.
     */
    public void RefreshTicketTable() {
        oTickets = FXCollections.observableArrayList(Ticket.tickets);
        TicketsTable.setItems((oTickets));
    }

    /**
     * Запускает набор действий для создания нового окна
     */
    @FXML
    public void CreateTicketButtonClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/views/CreateTicketScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 850, 680);
            Stage stage = new Stage();
            stage.setTitle("Создание обращения");
            stage.setScene(scene);
            stage.show();
            stage.requestFocus();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

        RefreshTicketTable(); // Не будет лишним
    }

    @FXML
    public void LogOutButtonClicked() throws IOException {
        LogOut(); // Метод временно назначен на логотип
    }

    /**
     * WIP
     * Производит выход из аккаунта, позволяя сменить пользователя.
     * @throws IOException Нужен из-за смены сцены
     */
    public void LogOut() throws IOException {
        clientApplication.ChangeScene("LoginScreen.fxml");
    }
}
