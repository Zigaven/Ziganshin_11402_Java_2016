package Task010.TestClasses;

import Task010.classes.Film;
import Task010.classes.Horror;
import Task010.interfaces.Genre;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class HorrorTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    Genre horror = (Horror) ac.getBean("horror1");
    @Test
    public void horrorShouldChoosePegi(){
        horror.choosePegi();
        Assert.assertEquals("Choose rating is M because genre: Horror",output.toString());
    }

    @Test
    public void horrorShouldChooseFilm(){
        Film film = (Film) ac.getBean("film02");
        horror.chooseFilm(film);
        Assert.assertEquals("Choose this Scream with genre: Horror",output.toString());
    }
}
