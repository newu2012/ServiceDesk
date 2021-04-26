package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    public SimpleIntegerProperty id;
    public SimpleStringProperty title;
    public SimpleStringProperty creator; // DELETE
    public SimpleIntegerProperty creatorId;
    public SimpleObjectProperty<TicketStatus> status;
    public SimpleStringProperty category; // -> categoryId
    public SimpleObjectProperty<Date> creationDate;
    public SimpleObjectProperty<Date> changeDate;
    public SimpleIntegerProperty softwareId; // -> softwareId
    public SimpleIntegerProperty moduleId;
    public SimpleStringProperty helper; // -> helperId
    public SimpleStringProperty description; // -> helperId

    public static ArrayList<Ticket> tickets = new ArrayList<Ticket>(); // Список обращений всей системы
    public static Ticket currentTicket; // Активное просматриваемое активным пользователем обращение
    public static int nextId = 0;

    /**
     * WIP
     * TODO Переделать согласно БД + нужным для таблицы полям
     * Создание обращения (тикета). Обращение - основная сущность системы
     * @param title Тема обращения, не менее 10 символов
     * @param creator ФИО создателя обращения (нужно будет убрать, потом брать ссылкой через ID)
     * @param creatorId ID создателя обращения
     * @param status Статус обращения (отдельный файл статусов)
     * @param category Категория обращения (отдельный файл категорий)
     * @param creationDate Дата создания, ставится автоматически при создании обращения
     * @param changeDate Дата последнего изменения/комментирования/смены статуса обращения
     * @param softwareId ID ПО, по которому создаётся обращение
     * @param moduleId ID модуля ПО, по которому создаётся обращение
     * @param helper Разработчик, назначенный на работу с обращением
     */
    public Ticket(
                  String title,
                  String creator,
                  Integer creatorId,
                  TicketStatus status,
                  String category,
                  Date creationDate,
                  Date changeDate,
                  Integer softwareId,
                  Integer moduleId,
                  String helper,
                  String description) {
        this.id = new SimpleIntegerProperty(nextId++);
        this.title = new SimpleStringProperty(title);
        this.creator = new SimpleStringProperty(creator);
        this.creatorId = new SimpleIntegerProperty(creatorId);
        this.status = new SimpleObjectProperty<TicketStatus>(status);
        this.category = new SimpleStringProperty(category);
        this.creationDate = new SimpleObjectProperty<Date>(creationDate);
        this.changeDate = new SimpleObjectProperty<Date>(changeDate);
        this.softwareId = new SimpleIntegerProperty(softwareId);
        this.moduleId = new SimpleIntegerProperty(moduleId);
        this.helper = new SimpleStringProperty(helper);
        this.description = new SimpleStringProperty(description);
    }

    /**
     * WIP
     * Основной метод создания обращения, используется в GUI.
     * @param title Название обращения, минимум 10 символов
     * @param category Категория обращения, на выбор одна из 3 кнопок
     * @param softwareId Название ПО, выбирается пользователем
     * @param moduleId Название модуля ПО, выбирается пользователем
     * @param description Полное текстовое описание обращения
     */
    public static void AddTicket(
        String title,
        String category,
        Integer softwareId,
        Integer moduleId,
        String description) {
            tickets.add(new Ticket(
                    title,
                    User.currentUser.getFullName(),
                    User.currentUser.getId(),
                    TicketStatus.OPEN,
                    category,
                    new Date(),
                    null,
                    softwareId,
                    moduleId,
                    null,
                    description
            ));
    }

    @Override
    public String toString() {
        return this.getTitle() + " - " + this.getCategory() + " - " + this.getDescription();
    }

    public int getId() {
        return id.get();
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getCreator() {
        return creator.get();
    }

    public void setCreator(String creator) {
        this.creator.set(creator);
    }

    public int getCreatorId() {
        return creatorId.get();
    }

    public void setCreatorId(int creatorId) {
        this.creatorId.set(creatorId);
    }

    public TicketStatus getStatus() {
        return status.get();
    }

    public void setStatus(TicketStatus status) {
        this.status.set(status);
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public Date getCreationDate() {
        return creationDate.get();
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate.set(creationDate);
    }

    public Date getChangeDate() {
        return null == changeDate ? null : changeDate.get();
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate.set(changeDate);
    }

    public Integer getSoftware() {
        return softwareId.get();
    }

    public void setSoftware(Integer softwareId) {
        this.softwareId.set(softwareId);
    }

    public Integer getModuleId() {
        return moduleId.get();
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId.set(moduleId);
    }

    public String getHelper() {
        return helper.get();
    }

    public void setHelper(String helper) {
        this.helper.set(helper);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
