package Task004.TestClasses;

import Task004.Classes.Film;
import Task004.Classes.UnderstudyActor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class StuntmanActor extends OutputTest {
    @Test
    public void someoneShouldPlayInFilm(){
        UnderstudyActor usa = new UnderstudyActor("WHO");
        Film film = new Film("God");
        usa.playInFilm(film);
        Assert.assertEquals("I'm playing in God", output.toString());
    }

    @Test
    public void someoneShouldToVoiceTheFilm(){
        UnderstudyActor usa = new UnderstudyActor("Bruce Wayne");
        Film film = new Film("Batman");
        usa.voiceInFilm(film);
        Assert.assertEquals("I'm voicing Batman", output.toString());
    }
}
