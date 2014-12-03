package Jersey;

import Begin.MyResource;
import Template.MyTemplate;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;

/**
 * Created by adam on 2014/12/3.
 */
public class MyApplicationConfig extends ResourceConfig {
    public static final String TFile = "Test";

    public MyApplicationConfig(){
        packages(true,new String[]{"Begin","Template","persistenceDemo/Client/Service"});
//        super(new Class<?>[]{MyTemplate.class, MyResource.class});
        register(LoggingFilter.class);
        register(FreemarkerMvcFeature.class);
    }
}
