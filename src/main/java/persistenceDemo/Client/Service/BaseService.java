package persistenceDemo.Client.Service;

import Jersey.MyApplicationConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by lab on 2014/12/3.
 */

@Path("persistence")
public class BaseService {

    @GET
    @Produces("text/html")
    public String test(){
        System.out.println(MyApplicationConfig.class.getName()+" : "+MyApplicationConfig.TFile);
        return "Done";
    }
}
