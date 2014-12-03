package Template;

import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adam on 2014/12/3.
 */

@Path("myTemplate")
public class MyTemplate {

    @GET
    @Path("test")
    @Produces("text/html")
    public String doTest(){
        return "<h1>Test my template</h1>";
    }

    @GET
    @Path("hello")
    @Produces("text/html")
    public Viewable doHello(){
        final Map<String,Object> map = new HashMap<>();
        map.put("user","adam");

        return new Viewable("/hello.ftl",map);
    }
}
