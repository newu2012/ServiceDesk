package team.dna2.serviceDesk_client;

import javafx.application.Application;
import team.dna2.serviceDesk_client.controllers.ClientApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Используется только для запуска метода main
 */
public class Main {

	/**
	 * WIP
	 * Используется только для запуска программы. TODO Надо как-то переделать
	 * @param args Не используется
	 */
	public static void main(String[] args) {
		Application.launch(ClientApplication.class, args);
	}

}
