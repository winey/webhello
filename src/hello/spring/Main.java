package hello.spring;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 4. 22
 * Time: 오후 5:22
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        client.biz(new PrettyLog());

    }

}
