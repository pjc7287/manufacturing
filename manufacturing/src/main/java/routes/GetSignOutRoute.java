package routes;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;

public class GetSignOutRoute implements Route {

    public Object handle(Request request, Response response) {

        //Wipe all data form user session
        Session userSession = request.session();
        userSession.attribute("departmentName","");
        userSession.attribute("firstName","");
        userSession.attribute("lastName","");
        userSession.attribute("employeeId","");
        userSession.attribute("managerId","");
        userSession.attribute("roleName","");
        userSession.attribute("signedIn", "false");
        userSession.attribute("permissions", "worker");

        response.redirect("/");
        return null;
    }

}
