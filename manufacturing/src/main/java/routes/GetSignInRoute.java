package routes;

import com.google.gson.Gson;
import routes.gson.HRResponse;
import spark.*;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class GetSignInRoute implements Route {

    private HttpClient httpClient;
    private Gson gson;

    public GetSignInRoute(Gson gson, HttpClient httpClient){
        this.gson = gson;
        this.httpClient = httpClient;
    }

    public Object handle(Request request, Response response){

        String token = request.queryParams("token");
        Session userSession = request.session();

        HttpRequest new_request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://ec2-3-82-117-119.compute-1.amazonaws.com/api/Token?token?="+token))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();
        HttpResponse<String> new_response = null;
        try {
            new_response = httpClient.send(new_request, HttpResponse.BodyHandlers.ofString());
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Exception in sending GET request to HR /Token API");
        }
        System.out.println(new_response.body());
        String json = new_response.body();
        HRResponse employeeInfo = gson.fromJson(json,HRResponse.class);
        if(employeeInfo.getRoleName().equals("CEO")){
            userSession.attribute("permissions","CEO");
        }
        else{
            userSession.attribute("permissions","worker");
        }
        userSession.attribute("signedIn", "true");
        response.redirect("/");
        return null;
    }
}
