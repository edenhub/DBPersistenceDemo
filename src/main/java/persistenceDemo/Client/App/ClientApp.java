package persistenceDemo.Client.App;

import persistenceDemo.PesistenceInterface.IAction;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by lab on 2014/12/3.
 */
public class ClientApp {
    private static Client client = ClientBuilder.newClient();
    private static final String SERVER_URL = "http://localhost:8080/app/server";

    public static void testServerBase(){
        WebTarget webTarget = client.target(SERVER_URL).path("base");
        Response response = webTarget.request().get();

        String result = response.readEntity(String.class);
        System.out.println(result);
    }

    public static void testServerAdd(){
        String userId = "001",formId = "001",localActionId;

        localActionId = registAction(userId,formId,MyAction.class);
        WebTarget webTarget = client.target(SERVER_URL).path("add");
//
//        上面那段为动作，可以用户写配置文件，也可以我们提供界面触发
//                下面为模板，我们帮用户完成

        Form form = new Form();
        form.param("userId",userId).param("formId",formId)
            .param("clientUrl", "http://localhost:8080/webapi/")
            .param("localActionId", localActionId);

        Response response = webTarget.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        String result = response.readEntity(String.class);

        System.out.println(result);

    }

    public static String registAction(String userId,String formId,Class<? extends IAction> userAction){
        System.out.println("================>>写入到本地数据库");
        String localActionId = "001";
        LocalActionRepository localActionRepository = LocalActionRepository.getInstance();
        localActionRepository.registAction(localActionId,userAction.getName());
        localActionRepository.dumpRepository();
        System.out.println("Client : "+localActionRepository);
        return localActionId;
    }

    public static void main(String[] args){
        testServerAdd();
    }
}
