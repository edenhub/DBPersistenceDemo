package persistenceDemo.Client.Service;

import persistenceDemo.Client.App.ClientApp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by adam on 2014/12/4.
 */
@Path("clientApp")
public class ClientAppService {

    @GET
    @Produces("text/plain")
    public String testServerAdd(){
        System.out.println("================== > >> ClientApp ");
        ClientApp.testServerAdd();
        return "success";
    }
}
