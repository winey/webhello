package mylog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 5. 20
 * Time: 오후 5:20
 * To change this template use File | Settings | File Templates.
 */
@Configuration
//<sop:aspectj-autoproxy />
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
    @Autowired
    Log log;

    @Bean
    public Client client() {
        Client client = new Client();
        client.setLog(log);
        //client.setLog(logTimeProxy(log));
        return client;

    }

    @Bean
    public Log log() {
        return new PrettyLog();
    }

    @Bean
    public ProfilingAspect profilingAspect() {
        return new ProfilingAspect();
    }

    @Bean
    public Log logTimeProxy(Log log) {
        LogTimeProxy logTimeProxy = new LogTimeProxy();
        logTimeProxy.setTargetLog(log);
        return logTimeProxy;
    }
}
