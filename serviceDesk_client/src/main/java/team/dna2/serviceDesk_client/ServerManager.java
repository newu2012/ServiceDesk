package team.dna2.serviceDesk_client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import team.dna2.serviceDesk_client.controllers.ClientApplication;
import team.dna2.serviceDesk_client.models.License;
import team.dna2.serviceDesk_client.models.Organization;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class ServerManager {
    private static ClientApplication clientApplication;
    private static Client client;
    private static ObjectMapper objectMapper;
    public static String baseUrl = "http://localhost:8888/";

    //region MainPaths TODO дописать
    public static String URLDeveloperLicences = "developer/licences/";
    public static String URLOrganizations = "organizations/";
    //endregion

    public static void SetUpServerManager() {
        client = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
    }

    //region MainMethods
    public ServerManager() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    public static String SetConnection(String url) {
        return SetConnection(url, "GET");
    }

    public static String SetConnection(String url, String method) {
        WebTarget target = client.target(baseUrl + url);
        return target.request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Basic ZGVuaXNAZG5hMi5ydTpkZW5pcw==")
                .get(String.class);
    }

    public static ArrayList<Organization> TryGetResponseMessage(String responseMessage) {
        ArrayList<Organization> newOrganizations = new ArrayList<>();

        try {
            // Если не массив
            // newOrganizations.add(objectMapper.readValue(responseMessage, Organization.class));
            newOrganizations = objectMapper.readValue(responseMessage, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return newOrganizations;
    }
    //endregion

    public static void FetchOrganizations() {
        Organization.organizations.addAll(TryGetResponseMessage(SetConnection(URLOrganizations)));
    }
}
