package mylog;

import org.springframework.util.StopWatch;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 5. 20
 * Time: 오후 6:04
 * To change this template use File | Settings | File Templates.
 */
public class LogTimeProxy implements Log {
    Log targetLog;

    public void setTargetLog(Log targetLog) {
        this.targetLog = targetLog;
    }

    @Override
    public void write(String s) {

        StopWatch watch = new StopWatch();
        watch.start();

        targetLog.write(s);

        watch.stop();
        System.out.println(watch.prettyPrint());

    }
}
