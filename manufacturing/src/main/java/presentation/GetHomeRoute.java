package presentation;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class GetHomeRoute implements Route {

    private TemplateEngine templateEngine;

    public GetHomeRoute(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();
        attributeMap.put("name","Peter");
        return templateEngine.render(new ModelAndView(attributeMap , "index.ftl"));
        //return "<h1>Hello World</h1>";
    }

}
