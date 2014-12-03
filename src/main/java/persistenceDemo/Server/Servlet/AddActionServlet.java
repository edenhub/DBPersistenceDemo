package persistenceDemo.Server.Servlet;

import persistenceDemo.PesistenceInterface.ActionBean;
import persistenceDemo.Server.DB.DBInCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lab on 2014/12/3.
 */
public class AddActionServlet extends HttpServlet {
    private DBInCache dbInCache = DBInCache.getInstance();

    @Override
//    新增注册
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActionBean bean = doHold(req,resp);
        boolean result = dbInCache.addBean(bean);
        testDump();
        doFlush(resp,result);
    }

    @Override
//    是否存在
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActionBean bean = doHold(req,resp);
        boolean result = dbInCache.isExit(bean);
        testDump();
        doFlush(resp,result);

    }

    private void doFlush(HttpServletResponse response,boolean result) throws IOException {
        PrintWriter out = response.getWriter();
        out.write(String.valueOf(result));
        out.flush();
    }

    protected ActionBean doHold(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String userId = request.getParameter("userId");
        String formId = request.getParameter("formId");
        //Demo中不考虑
        String clientUrl = request.getParameter("clientUrl");
        //用于当用户逻辑重复时是否要覆盖
        String localActionId = request.getParameter("localActionId");
        ActionBean actionBean = new ActionBean(userId,formId,clientUrl,localActionId);
        System.out.println("Do hold : "+actionBean);

        return actionBean;
    }

    private void testDump(){
        dbInCache.dumpDB();
    }
}
