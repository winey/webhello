package myboard.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 14
 * Time: 오전 10:56
 * To change this template use File | Settings | File Templates.
 */
public class EncodingFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        chain.doFilter(req, resp);
    }

    public void destroy() {
    }

}
