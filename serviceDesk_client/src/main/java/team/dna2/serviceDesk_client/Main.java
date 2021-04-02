package team.dna2.serviceDesk_client;


import javafx.application.Application;
import team.dna2.serviceDesk_client.controllers.ClientApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		Application.launch(ClientApplication.class, args);
	}

}
