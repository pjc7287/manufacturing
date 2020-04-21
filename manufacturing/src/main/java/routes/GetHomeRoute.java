package routes;

import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/". We will respond with a rendered HTML page
 */
public class GetHomeRoute implements Route {

    private TemplateEngine templateEngine;

    public GetHomeRoute(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){
        Session userSession = request.session();
        if(userSession.attribute("signedIn")=="true"){
            Map<String, Object> attributeMap = new HashMap<>();
            attributeMap.put("departmentName", userSession.attribute("departmentName"));
            attributeMap.put("firstName",userSession.attribute("firstName"));
            attributeMap.put("lastName",userSession.attribute("lastName"));
            attributeMap.put("employeeId",userSession.attribute("employeeId"));
            attributeMap.put("managerId",userSession.attribute("managerId"));
            attributeMap.put("roleName",userSession.attribute("roleName"));

            return templateEngine.render(new ModelAndView(attributeMap , "index.ftl"));
        }
        else{
            return templateEngine.render(new ModelAndView(new HashMap<String,Object>() , "signin.ftl"));
        }

    }

}
