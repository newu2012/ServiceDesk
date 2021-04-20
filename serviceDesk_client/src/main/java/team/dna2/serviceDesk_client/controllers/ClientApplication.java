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
import team.dna2.serviceDesk_client.models.User;

import java.io.IOException;

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

        SetUpStandardUsers(); // Добавление пользователей по умолчанию

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

    /**
     * Пользователи по умолчанию
     * Пароли хранятся пока что прямо так, поэтому они "admin"
     * TODO приделать хэширование паролей на клиенте
     */
    public void SetUpStandardUsers() {
        User.users.add(new User("admin", "admin", "Админ Админович"));
        User.users.add(new User("newu2011@gmail.com", "admin", "Никита Кононенко"));
        User.users.add(new User("pasifficid@gmail.com", "admin", "Денис Ишмурат"));
        User.users.add(new User("skywalkersakhno@gmail.com", "admin", "Александр Сахно"));
        User.users.add(new User("anna.00kon@gmail.com", "admin", "Анна Конкина"));
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