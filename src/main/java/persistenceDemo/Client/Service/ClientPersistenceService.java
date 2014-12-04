package persistenceDemo.Client.Service;

import persistenceDemo.Client.App.LocalActionRepository;
import persistenceDemo.PesistenceInterface.FormBean;
import persistenceDemo.PesistenceInterface.IAction;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by lab on 2014/12/3.
 */

@Path("clientPersis")
public class ClientPersistenceService {

    @POST
    @Consumes("application/xml")
    public boolean persistence(FormBean formBean) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("======>收到服务端的调用 : "+formBean);
        String localActionId = formBean.getLocalActionId();
        assert localActionId.equals("001");
        LocalActionRepository repository = LocalActionRepository.getInstance();
        repository.dumpRepository();
        String actionName = repository.getActionName(localActionId);
        System.out.println(localActionId+" ： actionName : "+actionName);
        System.out.println("ClientPer : "+repository);
//        使用模板，可以增加其他逻辑
        IAction action = (IAction) Class.forName(actionName).newInstance();
//        ActionBeank可以由本地数据库直接获得
        return action.doLogi(null,formBean);
    }
}
