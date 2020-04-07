package routes.heartbeat;

import assembly.AssemblyLine;
import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for handling a POST request to "/heartbeat"
 * This is a stub pending the Accounting teams desire to send us heartbeats, which has not been specified.
 */
public class PostHeartbeatRoute implements Route {

    private AssemblyLine assemblyLine;

    public PostHeartbeatRoute(AssemblyLine assemblyLine){
        this.assemblyLine = assemblyLine;
    }

    public Object handle(Request request, Response response){
        response.status(200);
        response.body("Heartbeat Received");
        assemblyLine.cycle();
        return "Heartbeat Received!";
    }

}
