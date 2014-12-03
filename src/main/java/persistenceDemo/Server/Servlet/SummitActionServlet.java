package persistenceDemo.Server.Servlet;

import persistenceDemo.PesistenceInterface.FormBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by lab on 2014/12/3.
 */
public class SummitActionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHold(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHold(req,resp);
    }

    protected void doHold(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
//        服务器可以根据表单中的隐藏域得到对应的localActionID
        String localActionId = "001";
        String field1 = request.getParameter("field1");
        String field2 = request.getParameter("field2");
        int age = Integer.parseInt(request.getParameter("age"));
        FormBean formBean = new FormBean(field1,field2,age);
        formBean.setLocalActionId(localActionId);

        Client client = ClientBuilder.newClient();
//        应该从数据库拿，这里省略
        WebTarget webTarget = client.target("http://localhost:8080/app/webapi/").path("clientPersis");
        Response resp = webTarget.request().post(Entity.entity(formBean, MediaType.APPLICATION_XML));
        Boolean result = resp.readEntity(Boolean.class);
        System.out.println("summit : "+result);
    }
}
