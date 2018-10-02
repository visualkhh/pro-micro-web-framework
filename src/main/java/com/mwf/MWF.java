package com.mwf;

import com.mwf.config.Config;
import com.mwf.config.anno.Configuration;
import com.mwf.config.anno.Controller;
import com.mwf.config.component.ComponentManager;
import net.sf.corn.cps.CPScanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MWF {
    private final Class index;
//    private List<ServerConfig> configs;
    private Config config;
    public MWF(Class klss) {
        this.index = klss;
    }

    public void start() throws IllegalAccessException, InstantiationException, IOException, InterruptedException {
        //config
        List<Class<?>> configClass = CPScanner.scanClasses(new net.sf.corn.cps.ClassFilter().classOnly().interfaceClass(Config.class).packageName(index.getPackage().getName() + "*").annotation(Configuration.class));
        for (Class<?> clazz : configClass) {
            config = (Config) clazz.newInstance();
            break;
        }

        //controller sacan
        List<Class<?>> controllerClass = CPScanner.scanClasses(new net.sf.corn.cps.ClassFilter().packageName(index.getPackage().getName() + "*").annotation(Controller.class));
        List<Object> controllers = new ArrayList<>();
        for (Class<?> clazz : controllerClass) {
            controllers.add(clazz.newInstance());
        }
        ComponentManager.getInstance().setController(controllers);


        config.getServer().start();

    }
}
