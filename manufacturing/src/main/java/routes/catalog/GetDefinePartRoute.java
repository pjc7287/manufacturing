package routes.catalog;

import spark.*;

import java.util.HashMap;
import java.util.Map;
/**
 * This class is responsible for handling a GET request to "/catalog/new". We will respond with a rendered HTML page
 */
public class GetDefinePartRoute implements Route {

    private TemplateEngine templateEngine;

    public GetDefinePartRoute(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){
        Session userSession = request.session();
        if(userSession.attribute("signedIn")=="true"){
            Map<String, Object> attributeMap = new HashMap<>();
            return templateEngine.render(new ModelAndView(attributeMap , "catalog/define_part.ftl"));
        }
        else{
            return templateEngine.render(new ModelAndView(new HashMap<String,Object>() , "signin.ftl"));
        }

    }

}
