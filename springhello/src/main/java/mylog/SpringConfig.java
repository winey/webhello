package mylog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 5. 20
 * Time: 오후 5:20
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class SpringConfig {

    @Bean
    public Client client() {
        Client client = new Client();
        client.setLog(log());
        return client;

    }
    @Bean
    public Log log() {
        return new PrettyLog();
    }
}
