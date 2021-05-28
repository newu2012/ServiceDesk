package team.dna2.serviceDesk_client;

import org.json.JSONArray;
import org.json.JSONObject;
import team.dna2.serviceDesk_client.controllers.ClientApplication;
import team.dna2.serviceDesk_client.models.License;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;

public class ServerManager {
    private static ClientApplication clientApplication;
    private static Client client;
    public static String baseUrl = "http://localhost:8080/";

    //region MainPaths TODO дописать
    public static String DeveloperLicences = "developer/licences/";
    //endregion

    public static void SetUpServerManager() {
        client = ClientBuilder.newClient();
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
        return target.request(MediaType.APPLICATION_JSON).get(String.class);
    }

    public static ArrayList<License> TryGetResponseMessage(String responseMessage) {
        // JSONObject obj =  new JSONObject(responseMessage);
        // JSONArray objects = obj.getJSONArray("");
        JSONArray arr = new JSONArray(responseMessage);

        ArrayList<License> newLicences = new ArrayList<>();

        for (int i = 0; i < arr.length(); i++) {
            JSONObject element = arr.getJSONObject(i);
            License license = new License(
                    element.getString("serialNumber"),
                    0L,
                    0L,
                    element.getLong("usersLimit"),
                    new Date(),
                    new Date(System.currentTimeMillis() + 100000000000L));
            newLicences.add(license);

            System.out.println(element);
        }

        return newLicences;
    }
    //endregion

    public static void FetchLicences() {
        License.licenses.addAll(TryGetResponseMessage(SetConnection(DeveloperLicences)));
    }
}
