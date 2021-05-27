package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    public SimpleIntegerProperty id;
    public SimpleStringProperty title;
    public SimpleIntegerProperty creatorId;
    public SimpleObjectProperty<TicketStatus> status;
    public SimpleIntegerProperty categoryId;
    public SimpleObjectProperty<Date> creationDate;
    public SimpleObjectProperty<Date> changeDate;
    public SimpleIntegerProperty softwareId;
    public SimpleIntegerProperty moduleId;
    public SimpleIntegerProperty helperId;
    public SimpleStringProperty description;

    public static ArrayList<Ticket> tickets = new ArrayList<Ticket>(); // Список обращений всей системы
    public static Ticket currentTicket; // Активное просматриваемое активным пользователем обращение
    public static int nextId = 0;

    /**
     * WIP
     * TODO Переделать согласно БД + нужным для таблицы полям
     * Создание обращения (тикета). Обращение - основная сущность системы
     * @param title Тема обращения, не менее 10 символов
     * @param creatorId ID создателя обращения
     * @param status Статус обращения (отдельный файл статусов)
     * @param categoryId Категория обращения (отдельный файл категорий)
     * @param creationDate Дата создания, ставится автоматически при создании обращения
     * @param changeDate Дата последнего изменения/комментирования/смены статуса обращения
     * @param softwareId ID ПО, по которому создаётся обращение
     * @param moduleId ID модуля ПО, по которому создаётся обращение
     * @param helperId Разработчик, назначенный на работу с обращением
     */
    public Ticket(
                  String title,
                  Integer creatorId,
                  TicketStatus status,
                  Integer categoryId,
                  Date creationDate,
                  Date changeDate,
                  Integer softwareId,
                  Integer moduleId,
                  Integer helperId,
                  String description) {
        this.id = new SimpleIntegerProperty(nextId++);
        this.title = new SimpleStringProperty(title);
        this.creatorId = new SimpleIntegerProperty(creatorId);
        this.status = new SimpleObjectProperty<TicketStatus>(status);
        this.categoryId = new SimpleIntegerProperty(categoryId);
        this.creationDate = new SimpleObjectProperty<Date>(creationDate);
        this.changeDate = new SimpleObjectProperty<Date>(changeDate);
        this.softwareId = new SimpleIntegerProperty(softwareId);
        this.moduleId = new SimpleIntegerProperty(moduleId);
        this.helperId = new SimpleIntegerProperty(helperId);
        this.description = new SimpleStringProperty(description);
    }

    /**
     * WIP
     * Основной метод создания обращения, используется в GUI.
     * @param title Название обращения, минимум 10 символов
     * @param categoryId Категория обращения, на выбор одна из кнопок
     * @param softwareId Название ПО, выбирается пользователем
     * @param moduleId Название модуля ПО, выбирается пользователем
     * @param description Полное текстовое описание обращения
     */
    public static void AddTicket(
        String title,
        Integer categoryId,
        Integer softwareId,
        Integer moduleId,
        String description) {
            tickets.add(new Ticket(
                    title,
                    User.currentUser.getId(),
                    TicketStatus.OPEN,
                    categoryId,
                    new Date(),
                    null,
                    softwareId,
                    moduleId,
                    -1,
                    description
            ));
    }

    @Override
    public String toString() {
        return this.getTitle() + " - " + this.getCategoryId() + " - " + this.getDescription();
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

    public int getCategoryId() {
        return categoryId.get();
    }

    public void setCategoryId(int category) {
        this.categoryId.set(category);
    }

    public Date getCreationDate() {
        return creationDate.get();
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate.set(creationDate);
    }

    public Date getChangeDate() {
        return null == changeDate ? Date.from(Instant.ofEpochSecond(0)) : changeDate.get();
    } // TODO Пустая строка при null

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

    public Integer getHelperId() {
        return helperId.get();
    }

    public void setHelperId(Integer helperId) {
        this.helperId.set(helperId);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
