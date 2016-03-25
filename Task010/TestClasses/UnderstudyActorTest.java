package Task010.TestClasses;

import Task010.classes.Film;
import Task010.classes.Imax;
import Task010.classes.KaroFilm;
import Task010.classes.UnderstudyActor;
import Task010.interfaces.Cinema;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class UnderstudyActorTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    UnderstudyActor ua = (UnderstudyActor) ac.getBean("understudy1");
    @Test
    public void someoneShouldPlayInFilm(){
            Film film = (Film) ac.getBean("film02");
            ua.playInFilm(film);
            Assert.assertEquals("I'm playing in Scream", output.toString());
        }

    @Test
    public void someoneShouldToVoiceTheFilm(){
        Film film = (Film) ac.getBean("film01");
        ua.voiceInFilm(film);
        Assert.assertEquals("I'm voicing Hangover", output.toString());
    }
}
