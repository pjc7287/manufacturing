package routes.inventory;

import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/". We will respond with a rendered HTML page
 */
public class GetNewPalletRoute implements Route {

    private TemplateEngine templateEngine;

    public GetNewPalletRoute(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){
        Session userSession = request.session();
        if(userSession.attribute("signedIn")=="true"){
            Map<String, Object> attributeMap = new HashMap<>();
            return templateEngine.render(new ModelAndView(attributeMap , "inventory/new_pallet.ftl"));
        }
        else{
            return templateEngine.render(new ModelAndView(new HashMap<String,Object>() , "signin.ftl"));
        }
    }

}
