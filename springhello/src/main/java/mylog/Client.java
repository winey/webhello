package mylog;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 4. 22
 * Time: 오후 5:22
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    private Log log;

    public void setLog(Log log) {
        this.log = log;
    }
    public void logic() {
        log.write("lalala");
    }
}
