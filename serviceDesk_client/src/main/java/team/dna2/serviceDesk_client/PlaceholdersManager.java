package team.dna2.serviceDesk_client;

import team.dna2.serviceDesk_client.models.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class PlaceholdersManager {
    public static void SetUpPlaceholders() {
        SetUpPlaceholderUsers();
        SetUpPlaceholderCategories();
        SetUpPlaceholderSoftware();
        SetUpPlaceholderSoftwareModules();
        SetUpPlaceholderLicenses();
    }

    public static void SetUpPlaceholderTicketStatuses() {
        TicketStatus.ticketStatuses.add(new TicketStatus(0L,"Открыто", ""));
        TicketStatus.ticketStatuses.add(new TicketStatus(1L,"Зарегистрировано", ""));
        TicketStatus.ticketStatuses.add(new TicketStatus(2L,"В работе", ""));
        TicketStatus.ticketStatuses.add(new TicketStatus(3L,"Исправлено", ""));
        TicketStatus.ticketStatuses.add(new TicketStatus(4L,"Переоткрыто", ""));
    }

    /**
     * Пользователи по умолчанию
     * Пароли хранятся пока что прямо так, поэтому они "admin"
     * TODO приделать хэширование паролей на клиенте
     */
    public static void SetUpPlaceholderUsers() {
        User.users.add(new User("admin", "admin", "Админ Админович", Role.DEVELOPER.getRole()));
        User.users.add(new User("user", "user", "Юзер Юзерович", Role.MEMBER.getRole()));
        User.users.add(new User("owner", "owner", "Заказчик Заказчиков", Role.OWNER.getRole()));

        User.users.add(new User("admin@gmail.com", "admin", "Админ Админович", Role.DEVELOPER.getRole()));
        User.users.add(new User("misha@gmail.com", "misha", "Шестеров Михаил Андреевич", Role.MEMBER.getRole()));
        User.users.add(new User("ilya@gmail.com", "ilya", "Обабков Илья Николаевич", Role.OWNER.getRole()));

        User.users.add(new User("newu2011@gmail.com", "admin", "Кононенко Никита ", Role.MEMBER.getRole()));
        User.users.add(new User("pasifficid@gmail.com", "admin", "Ишмурат Денис ", Role.MEMBER.getRole()));
        User.users.add(new User("skywalkersakhno@gmail.com", "admin", "Сахно Александр ", Role.MEMBER.getRole()));
        User.users.add(new User("anna.00kon@gmail.com", "admin", "Конкина Анна", Role.MEMBER.getRole()));
    }

    public static void SetUpPlaceholderCategories() {
        Category.categories.add(new Category("Вопрос", "Если Вам что-то не понятно"));
        Category.categories.add(new Category("Ошибка", "Если Вам кажется,что что-то работает не так как нужно"));
        Category.categories.add(new Category("Предложение функционала", "Если Вам хочется увидеть что-то новое в приложении"));
    }

    public static void SetUpPlaceholderSoftware() {
        Software.software.add(new Software("Service-Desk", "Приложение для работы с обращениями пользователей"));
        Software.software.add(new Software("Other"));
    }

    public static void SetUpPlaceholderSoftwareModules() {
        ArrayList<SoftwareModule> serviceDeskModules = new ArrayList<SoftwareModule>();
        serviceDeskModules.add(new SoftwareModule(0L, "Вход в аккаунт", "Проблемы со входом или что-то ещё"));
        serviceDeskModules.add(new SoftwareModule(0L, "Обращения", "Невозможность создать обращение, отсутствие созданного обращения..."));
        serviceDeskModules.add(new SoftwareModule(0L, "Профиль пользователя", "Не меняется аватар..."));
        serviceDeskModules.add(new SoftwareModule(0L, "Профиль организации", "Не получается добавить коллег в организацию..."));

        Software.software.get(0).setSoftwareModules(serviceDeskModules); // Можно заменить имеющийся список
        Software.software.get(0).addSoftwareModule(new SoftwareModule(0L, "Другое...")); // Или просто добавить запись
    }

    public static void SetUpPlaceholderLicenses() {
        License.licenses.add(new License("AAA-111", 0L, 0L, 0L, new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis() + 1000000000)));
    }
}
