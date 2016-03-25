package Task010.TestClasses;

import Task010.classes.DreamCinema;
import Task010.interfaces.Cinema;
import Task010.classes.Actor;
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
public class ActorTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    Actor actor = (Actor) ac.getBean("actor1");

    @Test
    public void someoneShouldPlayInFilm(){
        Film film = (Film) ac.getBean("film01");
        actor.playInFilm(film);
        Assert.assertEquals("I'm playing in Hangover", output.toString());
    }

    @Test
    public void someoneShouldToVoiceTheFilm(){
        Film film = (Film) ac.getBean("film0");
        actor.voiceInFilm(film);
        Assert.assertEquals("I'm voicing Avatar", output.toString());
    }
}
