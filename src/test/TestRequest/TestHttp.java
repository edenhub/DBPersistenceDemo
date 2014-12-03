package TestRequest;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by adam on 2014/12/3.
 */
public class TestHttp {

    @Test
    public void test(){
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://weishi.baidu.com/index/freedownload");
        Response response = webTarget.request().get();

        System.out.println(response.hasEntity());
        File file = response.readEntity(File.class);
        assert file!= null;
        System.out.println(file.getName()+"\n"+file.length());
        response.close();


    }
}
