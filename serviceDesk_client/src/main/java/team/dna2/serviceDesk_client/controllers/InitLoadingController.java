package team.dna2.serviceDesk_client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InitLoadingController implements Initializable {
    private static ClientApplication clientApplication;

    public void InitLoadingController() throws IOException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    public static void LoadLoginScreen() throws IOException{
        clientApplication.ChangeScene("LoginScreen.fxml");
    }
}
