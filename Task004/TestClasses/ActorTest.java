package Task004.TestClasses;

import Task004.Classes.Actor;
import Task004.Classes.Film;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class ActorTest extends OutputTest {
    @Test
    public void someoneShouldPlayInFilm(){
        Actor actor = new Actor("Ellen Page");
        Film film = new Film("Inception");
        actor.playInFilm(film);
        Assert.assertEquals("I'm playing in Inception", output.toString());
    }

    @Test
    public void someoneShouldToVoiceTheFilm(){
        Actor actor = new Actor("Army Hammer");
        Film film = new Film("UNCLE");
        actor.voiceInFilm(film);
        Assert.assertEquals("I'm voicing UNCLE", output.toString());
    }
}
