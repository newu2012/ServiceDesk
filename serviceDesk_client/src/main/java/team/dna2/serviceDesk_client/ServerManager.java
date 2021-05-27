package team.dna2.serviceDesk_client;

import org.jboss.resteasy.client.jaxrs.internal.ClientResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import team.dna2.serviceDesk_client.controllers.ClientApplication;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ServerManager {
    private static ClientApplication clientApplication;
    public static String baseUrl = "http://localhost:8080/";

    //region MainPaths TODO дописать
    public static String DeveloperLicences = "developer/licences/";
    //endregion


    //region MainMethods
    public ServerManager() {
        clientApplication = ClientApplication.GetClientApplicationInstance();
    }

    public static HttpURLConnection SetConnection(String url) {
        return SetConnection(url, "GET");
    }

    public static HttpURLConnection SetConnection(String url, String method) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(baseUrl + url);
            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            System.out.println(response);

            URL newUrl = new URL(baseUrl + url);
            HttpURLConnection con = (HttpURLConnection) newUrl.openConnection();
            con.setRequestMethod(method);
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();
            System.out.println("Response status code=" + status);
            return con;
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void TryGetResponseMessage(HttpURLConnection connection) {
        // TODO
    }
    //endregion
}
