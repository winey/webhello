package mylog;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 4. 22
 * Time: 오후 5:22
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Client implements BeanNameAware, InitializingBean {

    @Autowired
    private Log log;

    public Client () {
        System.out.println("생성자 log = " + log);
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public void logic() {
        log.write("lalala");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("my bean name = " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet log = " + log);

    }
}
