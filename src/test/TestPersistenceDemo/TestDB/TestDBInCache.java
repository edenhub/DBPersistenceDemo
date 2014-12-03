package TestPersistenceDemo.TestDB;

import org.junit.Test;
import persistenceDemo.PesistenceInterface.ActionBean;
import persistenceDemo.Server.DB.DBInCache;

/**
 * Created by lab on 2014/12/3.
 */
public class TestDBInCache {



    @Test
    public void test(){
        ActionBean bean1 = new ActionBean("001","001","localhost","001");
        ActionBean bean2 = new ActionBean("002","002","localhost","002");
        ActionBean bean3WithoutActionId = new ActionBean("001","001","localhost");

        DBInCache dbInCache = DBInCache.getInstance();

        assert dbInCache.isExit(bean1)==false;
        dbInCache.addBean(bean1);
        dbInCache.dumpDB();
        System.out.println("========");
        dbInCache.addBean(bean2);
        dbInCache.dumpDB();
        System.out.println("========");
        assert dbInCache.isExit(bean3WithoutActionId) == true;
        ActionBean result = dbInCache.findBean(bean3WithoutActionId.getUserId(),
                bean3WithoutActionId.getFormId(),bean3WithoutActionId.getClientUrl());
        System.out.println(result);
        System.out.println("=======");
        dbInCache.deleteBean(bean1);
        dbInCache.dumpDB();
    }
}
