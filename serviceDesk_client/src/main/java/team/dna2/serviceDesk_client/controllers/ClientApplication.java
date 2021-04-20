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

@SpringBootApplication
public class ClientApplication extends Application {
    public static ClientApplication clientApplication;
    private Parent rootNode;
    private ConfigurableApplicationContext springContext;
    private Stage stage;
    private FXMLLoader fxmlLoader;

    @Override
    public void init() throws Exception {
        clientApplication = this;
        System.out.println("Application inits");

        springContext = new SpringApplicationBuilder(Main.class)
                .sources(ClientApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
        springContext = SpringApplication.run(Main.class);

        SetUpStandardUsers();

        fxmlLoader = new FXMLLoader(getClass().getResource("/views/LoginScreen.fxml"));
        fxmlLoader.setClassLoader(LoginScreenController.class.getClassLoader()); // Не используется, так как руками назначил контроллер
        fxmlLoader.setControllerFactory(springContext::getBean);

        LoginScreenController controller = new LoginScreenController(); // Вот эта
        fxmlLoader.setController(controller); // И эта строки наконец починили всё

        rootNode = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) {
        System.out.println("Application starts");

        springContext.publishEvent(new StageReadyEvent(stage));
        this.stage = stage;

        stage.setScene(new Scene(rootNode, 600, 500));
        stage.setTitle("UDV Service-Desk");
        stage.setResizable(false);
        rootNode.requestFocus();

        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("Application stops");
        springContext.close();
        Platform.exit();
    }

    public void SetUpStandardUsers() {
        User.users.add(new User("admin", "admin", "Админ Админович"));
        User.users.add(new User("newu2011@gmail.com", "admin", "Никита Кононенко"));
        User.users.add(new User("pasifficid@gmail.com", "admin", "Денис Ишмурат"));
        User.users.add(new User("skywalkersakhno@gmail.com", "admin", "Александр Сахно"));
        User.users.add(new User("anna.00kon@gmail.com", "admin", "Анна Конкина"));
    }

    public void ChangeScene(String fxmlUrl) throws IOException, NullPointerException {
        Parent pane = FXMLLoader.load(getClass().getResource("/views/" + fxmlUrl));

        if (stage.getHeight() <= 700) {
            stage.setHeight(768);
            stage.setWidth(1366);
            stage.centerOnScreen();
        }

        stage.getScene().setRoot(pane);
    }

    public static ClientApplication GetClientApplicationInstance() {
        return clientApplication;
    }


    public static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }
        public Stage getStage() {
            return ((Stage) getSource());
        }
    }
}