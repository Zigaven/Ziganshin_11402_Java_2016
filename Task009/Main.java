package Task009;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class Main {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(Task009.ComplexMatrix2x2Test.class);
        for (Failure f : result.getFailures()) {
            System.out.println(f);
        }
        System.out.println("Good Test");
    }



    }

