package client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/api")
public class API {

    @GET
    @Path("echo")
    @Produces("text/plain")
    public String echo(@PathParam("echo") String echo) {
        return echo;
    }

}
