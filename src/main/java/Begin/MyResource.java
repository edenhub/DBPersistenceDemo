package Begin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by adam on 2014/12/3.
 */
@Path("/myResource")
public class MyResource {

    @GET
    @Produces("text/html")
    public String doGet(){
        return "<h1>Hello Begin</h1>";
    }
}
