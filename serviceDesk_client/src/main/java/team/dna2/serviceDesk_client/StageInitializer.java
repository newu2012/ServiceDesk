package team.dna2.serviceDesk_client;

import javafx.stage.Stage;
import team.dna2.serviceDesk_client.controllers.ClientApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<ClientApplication.StageReadyEvent> {

    @Override
    public void onApplicationEvent(ClientApplication.StageReadyEvent event) {
        Stage stage = event.getStage();
    }
}
