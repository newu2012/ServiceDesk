package team.dna2.serviceDesk_client.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    public Long id;
    public String title;
    public Long creatorId;
    public User user;
    public TicketStatus ticketStatus;
    public Long categoryId;
    public Category ticketCategory;
    public Date creationDate;
    public Date changeDate;
    public Date completedDate;
    public Software software;
    public Long softwareId;
    public SoftwareModule softwareModule;
    public Long moduleId;
    public Long helperId;
    public String description;
    public Developer developer;
    public String ticketText;
    public Organization organization;

    public static ArrayList<Ticket> tickets = new ArrayList<>(); // Список обращений всей системы
    public static Ticket currentTicket; // Активное просматриваемое активным пользователем обращение
    public static Long nextId = 0L;

    /**
     * WIP
     * TODO Переделать согласно БД + нужным для таблицы полям
     * Создание обращения (тикета). Обращение - основная сущность системы
     * @param title Тема обращения, не менее 10 символов
     * @param creatorId ID создателя обращения
     * @param ticketStatus Статус обращения (отдельный файл статусов)
     * @param categoryId Категория обращения (отдельный файл категорий)
     * @param creationDate Дата создания, ставится автоматически при создании обращения
     * @param changeDate Дата последнего изменения/комментирования/смены статуса обращения
     * @param softwareId ID ПО, по которому создаётся обращение
     * @param moduleId ID модуля ПО, по которому создаётся обращение
     * @param helperId Разработчик, назначенный на работу с обращением
     */
    public Ticket(
                  String title,
                  Long creatorId,
                  TicketStatus ticketStatus,
                  Long categoryId,
                  Date creationDate,
                  Date changeDate,
                  Long softwareId,
                  Long moduleId,
                  Long helperId,
                  String description) {
        this.id = nextId++;
        this.title = title;
        this.creatorId = creatorId;
        this.ticketStatus = ticketStatus;
        this.categoryId = categoryId;
        this.creationDate = creationDate;
        this.changeDate = changeDate;
        this.softwareId = softwareId;
        this.moduleId = moduleId;
        this.helperId = helperId;
        this.description = description;
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
        Long categoryId,
        Long softwareId,
        Long moduleId,
        String description) {
            tickets.add(new Ticket(
                    title,
                    User.currentUser.getId(),
                    TicketStatus.ticketStatuses.get(0),
                    categoryId,
                    new Date(),
                    null,
                    softwareId,
                    moduleId,
                    -1L,
                    description
            ));
    }

    @Override
    public String toString() {
        return this.getTitle() + " - " + this.getCategoryId() + " - " + this.getDescription();
    }

    public Date getChangeDate() {
        return null == changeDate ? Date.from(Instant.ofEpochSecond(0)) : changeDate;
    } // TODO Пустая строка при null
}
