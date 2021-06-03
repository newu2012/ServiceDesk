package team.dna2.serviceDesk_client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import team.dna2.serviceDesk_client.controllers.ClientApplication;
import team.dna2.serviceDesk_client.models.License;
import team.dna2.serviceDesk_client.models.Organization;
import team.dna2.serviceDesk_client.models.Ticket;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

public class ServerManager {
    private static ClientApplication clientApplication;
    private static Client client;
    private static ObjectMapper objectMapper;
    public static String baseUrl = "http://localhost:8888/";

    //region MainPaths TODO дописать
    public static String URLLicences = "developer/licences/";
    public static String URLOrganizations = "organizations/";
    public static String URLTickets = "tickets/?userId=3";
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
    //endregion

    //region get requests
    public static ArrayList<Organization> TryGetOrganizations(String responseMessage) {
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

    public static ArrayList<License> TryGetLicenses(String responseMessage) {
        ArrayList<License> newLicenses = new ArrayList<>();

        try {
            // Если не массив
            // newOrganizations.add(objectMapper.readValue(responseMessage, Organization.class));
            newLicenses = objectMapper.readValue(responseMessage, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return newLicenses;
    }

    public static ArrayList<Ticket> TryGetTickets(String responseMessage) {
        ArrayList<Ticket> newTickets = new ArrayList<>();

        try {
            // Если не массив
            // newOrganizations.add(objectMapper.readValue(responseMessage, Organization.class));
            newTickets = objectMapper.readValue(responseMessage, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return newTickets;
    }
    //endregion

    //region Fetches
    public static void FetchAll() {
        FetchOrganizations();
        FetchLicenses();
        FetchTickets();
    }

    public static void FetchOrganizations() {
        Organization.organizations.addAll(TryGetOrganizations(SetConnection(URLOrganizations)));
    }

    public static void FetchLicenses() {
        License.licenses.addAll(TryGetLicenses(SetConnection(URLLicences)));
    }

    public static void FetchTickets() {
        Ticket.tickets.addAll(TryGetTickets(SetConnection(URLTickets)));
    }
    //endregion
}
