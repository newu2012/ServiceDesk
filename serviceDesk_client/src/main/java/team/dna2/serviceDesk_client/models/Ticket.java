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
    public SimpleStringProperty software; // -> softwareId
    public SimpleIntegerProperty moduleId;
    public SimpleStringProperty helper; // -> helperId

    public static ArrayList<Ticket> tickets = new ArrayList<Ticket>(); // Список обращений всей системы
    public static int nextId = 1;

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
     * @param software Название ПО, по которому создаётся обращение
     * @param moduleId Название модуля ПО, по которому создаётся обращение
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
                  String software,
                  Integer moduleId,
                  String helper) {
        this.id = new SimpleIntegerProperty(nextId++);
        this.title = new SimpleStringProperty(title);
        this.creator = new SimpleStringProperty(creator);
        this.creatorId = new SimpleIntegerProperty(creatorId);
        this.status = new SimpleObjectProperty<TicketStatus>(status);
        this.category = new SimpleStringProperty(category);
        this.creationDate = new SimpleObjectProperty<Date>(creationDate);
        this.changeDate = new SimpleObjectProperty<Date>(changeDate);
        this.software = new SimpleStringProperty(software);
        this.moduleId = new SimpleIntegerProperty(moduleId);
        this.helper = new SimpleStringProperty(helper);
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
        return changeDate.get();
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate.set(changeDate);
    }

    public String getSoftware() {
        return software.get();
    }

    public void setSoftware(String software) {
        this.software.set(software);
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
}
