package Task012;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ruslanzigansin on 25.03.16.
 */
@Aspect
public class Check {
    @Around("execution(* *..*.sendSql(String))")
    public Object checkIt(ProceedingJoinPoint jp) throws Throwable {
        Pattern pattern = Pattern.compile("(DROP|DELETE|ALTER|CREATE|UPDATE)+");
        String sql = (String) jp.getArgs()[0];
        Matcher matcher = pattern.matcher(sql);
        if (matcher.find()) {
            System.out.println(
                    "Man, this is sql injection! RUN!");
            return null;
        }
        return jp.proceed();
    }
}
