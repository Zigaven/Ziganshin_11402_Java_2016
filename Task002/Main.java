package Task002;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by ruslanzigansin on 25.02.16.
 */
public class Main {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(Matrix2x2Test.class);
        for (Failure f : result.getFailures()) {
            System.out.println(f);
        }
        System.out.println("Good Test");

    }

}
