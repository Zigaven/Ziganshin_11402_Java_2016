package Task012;

import Task012.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 25.03.16.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Sender sender = ac.getBean(Task012.Sender.class);

        sender.sendSql("(DROP)");
        sender.sendSql("1");
        sender.sendSql("dfksdfjksj123.");
    }
}
