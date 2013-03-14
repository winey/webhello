package myboard.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 14
 * Time: 오전 11:43
 * To change this template use File | Settings | File Templates.
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper (HttpServletRequest req) {
        super(req);
    }

    @Override
    public Object getAttribute(String s) {
        System.out.println("get [" + s + "] = [" + super.getAttribute(s) + "]");
        return super.getAttribute(s);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAttribute(String s, Object o) {
        //To change body of implemented methods use File | Settings | File Templates.
        //System.out.println("set-s = [" + s + "], o = [" + o + "]");
        System.out.println("set [" + s + "] = [" + o + "]");
        super.setAttribute(s,o);
    }

}
