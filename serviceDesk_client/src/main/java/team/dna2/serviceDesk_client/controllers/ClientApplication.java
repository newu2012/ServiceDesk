package team.dna2.serviceDesk_client.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import team.dna2.serviceDesk_client.Main;
import team.dna2.serviceDesk_client.models.Category;
import team.dna2.serviceDesk_client.models.Software;
import team.dna2.serviceDesk_client.models.SoftwareModule;
import team.dna2.serviceDesk_client.models.User;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс, отвечающий за подготовку к запуску приложения, его запуск и закрытие.
 * Есть некоторые иные вещи, которые стоит вынести из файла
 * Вообще, тут лучше у Дениса узнавать
 */
@SpringBootApplication
public class ClientApplication extends Application {
    public static ClientApplication clientApplication;
    private Parent rootNode;
    private ConfigurableApplicationContext springContext;
    private Stage stage;
    private FXMLLoader fxmlLoader;

    /**
     * Тут происходит подготовка к запуску приложения.
     * Выполняется раньше всего вообще во всём приложении (сразу после Main.main)
     * @throws Exception Не помню зачем
     */
    @Override
    public void init() throws Exception {
        clientApplication = this;
        System.out.println("Application inits");

        springContext = new SpringApplicationBuilder(Main.class)
                .sources(ClientApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
        springContext = SpringApplication.run(Main.class);

        SetUpPlaceholders(); // Добавление данных по умолчанию (пользователи, софт, модули)

        fxmlLoader = new FXMLLoader(getClass().getResource("/views/InitLoading.fxml"));
        fxmlLoader.setClassLoader(InitLoadingController.class.getClassLoader()); // Не используется, так как руками назначил контроллер
        fxmlLoader.setControllerFactory(springContext::getBean);

        InitLoadingController controller = new InitLoadingController(); // Вот эта
        fxmlLoader.setController(controller); // И эта строки наконец починили всё

        rootNode = fxmlLoader.load();
    }

    /**
     * Запуск приложения, происходит после инициализации
     * @param stage Похоже, что начальный stage, не разбирался
     * @throws IOException Из-за нахождения файла по ссылке
     */
    @Override
    public void start(Stage stage) throws IOException{
        System.out.println("Application starts");

        springContext.publishEvent(new StageReadyEvent(stage));
        this.stage = stage;

        stage.setScene(new Scene(rootNode, 600, 500));
        stage.setTitle("UDV Service-Desk");
        stage.setResizable(false);
        rootNode.requestFocus();

        InitLoadingController.LoadLoginScreen();

        stage.show();
    }

    /**
     * Закрытие приложения
     */
    @Override
    public void stop() {
        System.out.println("Application stops");
        springContext.close();
        Platform.exit();
    }

    public void SetUpPlaceholders() {
        SetUpPlaceholderUsers();
        SetUpPlaceholderCategories();
        SetUpPlaceholderSoftware();
        SetUpPlaceholderSoftwareModules();
    }

    /**
     * Пользователи по умолчанию
     * Пароли хранятся пока что прямо так, поэтому они "admin"
     * TODO приделать хэширование паролей на клиенте
     */
    public void SetUpPlaceholderUsers() {
        User.users.add(new User("admin", "admin", "Админ Админович"));
        User.users.add(new User("newu2011@gmail.com", "admin", "Никита Кононенко"));
        User.users.add(new User("pasifficid@gmail.com", "admin", "Денис Ишмурат"));
        User.users.add(new User("skywalkersakhno@gmail.com", "admin", "Александр Сахно"));
        User.users.add(new User("anna.00kon@gmail.com", "admin", "Анна Конкина"));
    }

    public void SetUpPlaceholderCategories() {
        Category.categories.add(new Category("Вопрос", "Если Вам что-то не понятно"));
        Category.categories.add(new Category("Ошибка", "Если Вам кажется,что что-то работает не так как нужно"));
        Category.categories.add(new Category("Предложение функционала", "Если Вам хочется увидеть что-то новое в приложении"));
    }

    public void SetUpPlaceholderSoftware() {
        Software.software.add(new Software("Service-Desk", "Приложение для работы с обращениями пользователей"));
        Software.software.add(new Software("Other"));
    }

    public void SetUpPlaceholderSoftwareModules() {
        ArrayList<SoftwareModule> serviceDeskModules = new ArrayList<SoftwareModule>();
        serviceDeskModules.add(new SoftwareModule("Вход в аккаунт", "Проблемы со входом или что-то ещё"));
        serviceDeskModules.add(new SoftwareModule("Обращения", "Невозможность создать обращение, отсутствие созданного обращения..."));
        serviceDeskModules.add(new SoftwareModule("Профиль пользователя", "Не меняется аватар..."));
        serviceDeskModules.add(new SoftwareModule("Профиль организации", "Не получается добавить коллег в организацию..."));

        Software.software.get(0).setSoftwareModules(serviceDeskModules); // Можно заменить имеющийся список
        Software.software.get(0).addSoftwareModule(new SoftwareModule("Другое...")); // Или просто добавить запись
    }
    
    /**
     * Основной способ смены экрана (сцены)
     * @param fxmlUrl Название файла экрана типа "Screen.fxml"
     * @throws IOException Из-за работы с ссылкой на файл
     * @throws NullPointerException Не помню почему
     */
    public void ChangeScene(String fxmlUrl) throws IOException, NullPointerException {
        Parent pane = FXMLLoader.load(getClass().getResource("/views/" + fxmlUrl)); // Файлы лежат в папке views

        if (!fxmlUrl.equals("LoginScreen.fxml")) { // Если мы открываем не экран входа в аккаунт, то размер "большой"
            stage.setWidth(1366);
            stage.setHeight(768);
        }
        else { // Иначе небольшое окошко
            stage.setWidth(600);
            stage.setHeight(550);
        }

        stage.centerOnScreen();
        stage.getScene().setRoot(pane);
    }

    public static ClientApplication GetClientApplicationInstance() {
        return clientApplication;
    }

    /**
     * Хз что это, не использую.
     * Есть зачем-то при старте приложения
     */
    public static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }
        public Stage getStage() {
            return ((Stage) getSource());
        }
    }
}