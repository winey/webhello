package myboard.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 14
 * Time: 오전 10:57
 * To change this template use File | Settings | File Templates.
 */
public class RequestFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpReponse = (HttpServletResponse) resp;

        System.out.println(httpRequest.getRemoteAddr() + httpRequest.getRequestURI());



        RequestWrapper wrappedReq = new RequestWrapper (httpRequest);

        chain.doFilter(wrappedReq, httpReponse);
    }


    public void destroy() {
    }

}
