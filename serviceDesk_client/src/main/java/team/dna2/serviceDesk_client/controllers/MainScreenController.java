package team.dna2.serviceDesk_client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import team.dna2.serviceDesk_client.models.Ticket;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@Component
public class MainScreenController implements Initializable {
    private ClientApplication clientApplication;
    private ApplicationContext context;

    @FXML private Text Logo;
    @FXML private Text Tickets;
    @FXML private ImageView PlaceholderImage;

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

    private ObservableList<Ticket> tickets = FXCollections.observableArrayList(
            new Ticket(1, "Не Работает", "Никита", "Открыто", "Ошибка","19.04.2021", "","Service-Desk", "Никита"),
            new Ticket(2, "Работает", "Никита", "Проверено", "Задача","19.04.2021", "","Service-Desk", "Никита"),
            new Ticket(3, "Опять не работает", "Денис", "Открыто", "Ошибка","21.04.2021", "","Service-Desk", "Денис"),
            new Ticket(4, "Починил, проверяй", "Александр Великий", "Зарегистрировано", "Вопрос","22.04.2021", "","Service-Desk", "Саня"),
            new Ticket(5, "Ничего не починено", "Денис", "Открыто", "Ошибка","22.04.2021", "","Service-Desk", "Денис"),
            new Ticket(6, "КОГДА БУДЕТ КОД", "АНЯ", "Открыто", "Ошибка","19.04.2021", "","Service-Desk", "Аня"),
            new Ticket(7, "Ну всё, я пошла кодить сама...", "Аня", "Закрыто", "Задача","20.04.2021", "","Service-Desk", "Аня")
    );

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

        TicketsTable.setItems(tickets);
    }

    public void MainScreenController () {

    }

    public void AddTicket (Integer id,
                           String title,
                           String category,
                           String software) {
        tickets.add(new Ticket(
                id,
                title,
                "Авто Создатель",
                "Открыто",
                category,
                "Авто Дата создания",
                null,
                software,
                null
        ));
    }

    @FXML
    public void OpenPlaceholderImage() {
        // PlaceholderImage.setVisible(true);  Чисто тест
    }
}
