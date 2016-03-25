package Task013;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 25.03.16.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Sender sender = ac.getBean(Sender.class);

        sender.sendEmail("rus123_@mail.ru");
        sender.sendEmail("13123....@fff");
        sender.sendEmail("dfksdfjksj@mail.");
    }
}
