package persistenceDemo.Server.DB;

import persistenceDemo.PesistenceInterface.ActionBean;

import java.util.*;

/**
 * Created by lab on 2014/12/3.
 */
public class DBInCache {

    private static Set<ActionBean> dbInCache = Collections.synchronizedSet(new HashSet<ActionBean>(200));
    private static DBInCache instance = new DBInCache();

    private DBInCache(){}

    public static DBInCache getInstance(){
        return instance;
    }


    public boolean isExit(ActionBean bean){
        Iterator<ActionBean> iter = dbInCache.iterator();
        ActionBean temp = null;
        while(iter.hasNext()){
            temp = iter.next();

            if (bean.equals(temp)){
                return true;
            }
        }

        return false;
    }

    public boolean addBean(ActionBean bean){
        dbInCache.add(bean);

        return true;
    }

    public boolean updateBean(ActionBean bean){
        if (!isExit(bean))
            return false;
        else{
            dbInCache.add(bean);
            return false;
        }
    }

    public boolean deleteBean(ActionBean bean){
        if (!isExit(bean))
            return false;
        else {
            dbInCache.remove(bean);
            return true;
        }
    }

    public ActionBean findBean(String userId,String formId,String clientUri){
        ActionBean QBean = new ActionBean(userId,formId,clientUri);
        Iterator<ActionBean> iter = dbInCache.iterator();
        ActionBean temp = null;
        while(iter.hasNext()){

            temp = iter.next();
            assert temp!= null;
            assert QBean!=null;
            if (QBean.equals(temp)){
                System.out.println("Find : "+temp);
                return temp;
            }
        }

        return null;
    }

    public static void dumpDB(){
        System.out.println(dbInCache.size());
        Iterator<ActionBean> iter = dbInCache.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
    }
}
