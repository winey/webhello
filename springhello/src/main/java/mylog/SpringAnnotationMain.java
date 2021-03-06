package mylog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 5. 2
 * Time: 오후 5:30
 * To change this template use File | Settings | File Templates.
 */
public class SpringAnnotationMain {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Client client = (Client)context.getBean("client");

        Log log = context.getBean("log", Log.class);
        System.out.println("log Class Name = " + log.getClass());

        client.logic();
    }
}
