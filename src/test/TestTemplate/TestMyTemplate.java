package TestTemplate;

import org.junit.After;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by adam on 2014/12/3.
 */
public class TestMyTemplate {
    private Client client = ClientBuilder.newClient();
    private static final String BASE_URL = "http://localhost:8080/db/webapi";
    private WebTarget webTarget;

    @After
    public void after(){
        System.out.println("Done ... ");
    }

    @Test
    public void testTest(){
        webTarget = client.target(BASE_URL).path("myTemplate").path("test");
        Response response = webTarget.request().get();
        System.out.println(response.readEntity(String.class));
    }

    @Test
    public void testHello(){
        webTarget = client.target(BASE_URL).path("myTemplate").path("hello");
        Response response = webTarget.request().get();
        System.out.println(response.readEntity(String.class));
    }

}
