package Task013;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ruslanzigansin on 25.03.16.
 */
@Aspect
public class ReallyEmail {
    @Around("execution(* *..*.sendEmail(String))")
    public Object checkIt(ProceedingJoinPoint jp) throws Throwable {
        Pattern pattern = Pattern.compile("^[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        String email = (String) jp.getArgs()[0];
        Matcher matcher = pattern.matcher(email);
        if (!matcher.find()) {
            System.out.println(
                    "Man, this is not correct email! Recheck!");
            return null;
        }
        return jp.proceed();
    }
}
