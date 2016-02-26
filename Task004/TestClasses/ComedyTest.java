package Task004.TestClasses;

import Task004.Classes.Comedy;
import Task004.Classes.Film;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class ComedyTest extends OutputTest {

    @Test
    public void comedyShouldChoosePegi(){
        Comedy comedy = new Comedy("Comedy");
        comedy.choosePegi();
        Assert.assertEquals("Choose rating is M because genre: Comedy",output.toString());
    }

    @Test
    public void comedyShouldChooseFilm(){
        Comedy comedy = new Comedy("Comedy");
        Film film = new Film("Batman");
        comedy.chooseFilm(film);
        Assert.assertEquals("Choose this Batman with genre: Comedy",output.toString());
    }
}
