package persistenceDemo.Client.App;

import persistenceDemo.PesistenceInterface.ActionBean;
import persistenceDemo.PesistenceInterface.FormBean;
import persistenceDemo.PesistenceInterface.IAction;

/**
 * Created by lab on 2014/12/3.
 */
public class MyAction implements IAction{
    @Override
    public boolean doLogi(ActionBean bean, FormBean formBean) {
        System.out.println("日志记录 ---- 》 收到的数据 ： "+formBean);
        if (formBean.getAge()>100){
            System.out.println("数据错误，不执行数据库操作");
            return false;
        }
        System.out.println("写数据到数据库...");
        return true;
    }
}
