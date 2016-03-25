package Task010.TestClasses;

import Task010.classes.Film;
import Task010.classes.StuntmanActor;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class StuntmanActorTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    StuntmanActor sa = (StuntmanActor) ac.getBean("stuntman1");
    @Test
    public void someoneShouldPlayInFilm() {
        Film film = (Film) ac.getBean("film02");
        sa.playInFilm(film);
        Assert.assertEquals("I'm playing in Scream", output.toString());
    }

    @Test
    public void someoneShouldToVoiceTheFilm() {
        Film film = (Film) ac.getBean("film0");
        sa.voiceInFilm(film);
        Assert.assertEquals("I'm voicing Avatar", output.toString());
    }
}
