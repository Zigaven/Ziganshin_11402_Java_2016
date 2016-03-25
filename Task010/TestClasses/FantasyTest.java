package Task010.TestClasses;

import Task010.classes.KaroFilm;
import Task010.interfaces.Cinema;
import Task010.classes.Fantasy;
import Task010.classes.Film;
import Task010.interfaces.Genre;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class FantasyTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    Genre fantasy = (Fantasy) ac.getBean("fantasy1");
    @Test
    public void fantasyShouldChoosePegi(){
        fantasy.choosePegi();
        Assert.assertEquals("Choose rating M because genre: Fantasy",output.toString());
    }

    @Test
    public void fantasyShouldChooseFilm(){
        Film film = (Film) ac.getBean("film0");
        fantasy.chooseFilm(film);
        Assert.assertEquals("Choose this Avatar with genre: Fantasy",output.toString());
    }
}
