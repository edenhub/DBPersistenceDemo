package persistenceDemo.Client.App;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lab on 2014/12/3.
 */
public class LocalActionRepository {
    private  Map<String,String> actionRepository = new ConcurrentHashMap<>(100);
    private static LocalActionRepository instance = new LocalActionRepository();

    private LocalActionRepository(){}

    public static LocalActionRepository getInstance(){
        return instance;
    }

    public boolean registAction(String actionId,String actionName){
        actionRepository.put(actionId,actionName);

        return true;
    }

    public String getActionName(String actionId){
        dumpRepository();
        return actionRepository.get(actionId);
    }

    public  void dumpRepository(){
        System.out.println(actionRepository.size());
        for(Map.Entry<String,String> e : actionRepository.entrySet()){
            System.out.println(e.getKey()+" : "+e.getValue());
        }

        System.out.println("========================");
    }
}
