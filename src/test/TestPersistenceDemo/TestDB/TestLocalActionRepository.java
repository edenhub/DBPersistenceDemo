package TestPersistenceDemo.TestDB;

import org.junit.Test;
import persistenceDemo.Client.App.LocalActionRepository;
import persistenceDemo.Client.App.MyAction;

/**
 * Created by adam on 2014/12/4.
 */
public class TestLocalActionRepository {

    @Test
    public void test01(){
        LocalActionRepository actionRepository = LocalActionRepository.getInstance();

        actionRepository.registAction("001", MyAction.class.getName());
        LocalActionRepository actionRepository1 = LocalActionRepository.getInstance();
        actionRepository1.dumpRepository();
        System.out.println(actionRepository1.getActionName("001"));
    }
}
