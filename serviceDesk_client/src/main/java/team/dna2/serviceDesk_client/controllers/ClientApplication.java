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

@SpringBootApplication
public class ClientApplication extends Application {
    private Parent rootNode;
    private ConfigurableApplicationContext springContext;

    @Override
    public void init() throws Exception {
        System.out.println("Application inits");

        springContext = new SpringApplicationBuilder(Main.class)
                .sources(ClientApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
        springContext = SpringApplication.run(Main.class);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/LoginScreen.fxml"));
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

        stage.setScene(new Scene(rootNode, 600, 500));
        stage.setTitle("UDV Service-Desk");

        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("Application stops");
        springContext.close();
        Platform.exit();
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