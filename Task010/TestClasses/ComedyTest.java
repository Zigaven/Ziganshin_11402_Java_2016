package Task010.TestClasses;

import Task010.classes.Comedy;
import Task010.classes.Film;
import Task010.classes.Imax;
import Task010.interfaces.Cinema;
import Task010.interfaces.Genre;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class ComedyTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    Genre comedy = (Comedy)ac.getBean("comedy1");

    @Test
    public void comedyShouldChoosePegi(){
        comedy.choosePegi();
        Assert.assertEquals("Choose rating is M because genre: Comedy",output.toString());
    }

    @Test
    public void comedyShouldChooseFilm(){
        Film film = (Film) ac.getBean("film01");
        comedy.chooseFilm(film);
        Assert.assertEquals("Choose this Hangover with genre: Comedy",output.toString());
    }
}
