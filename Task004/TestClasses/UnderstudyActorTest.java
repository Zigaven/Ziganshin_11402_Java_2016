package Task004.TestClasses;

import Task004.Classes.Film;
import Task004.Classes.UnderstudyActor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class UnderstudyActorTest extends OutputTest {
        @Test
    public void someoneShouldPlayInFilm(){
            UnderstudyActor usa = new UnderstudyActor("he");
            Film film = new Film("she");
            usa.playInFilm(film);
            Assert.assertEquals("I'm playing in she", output.toString());
        }

    @Test
    public void someoneShouldToVoiceTheFilm(){
        UnderstudyActor usa = new UnderstudyActor("he");
        Film film = new Film("IT");
        usa.voiceInFilm(film);
        Assert.assertEquals("I'm voicing IT", output.toString());
    }
}
