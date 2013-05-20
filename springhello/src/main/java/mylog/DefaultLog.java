package mylog;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 4. 22
 * Time: 오후 5:28
 * To change this template use File | Settings | File Templates.
 */
@Component
public class DefaultLog implements Log {
    
    public void write(String s) {

        System.out.println("s = " + s);

    }
}
