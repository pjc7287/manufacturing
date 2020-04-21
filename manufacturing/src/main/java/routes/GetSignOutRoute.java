package routes;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;

public class GetSignOutRoute implements Route {

    public Object handle(Request request, Response response) {

        Session userSession = request.session();
        userSession.attribute("signedIn", "false");
        userSession.attribute("permissions", "worker");

        response.redirect("/");
        return null;
    }

}
