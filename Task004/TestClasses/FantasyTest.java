package Task004.TestClasses;

import Task004.Classes.Fantasy;
import Task004.Classes.Film;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class FantasyTest extends OutputTest {
    @Test
    public void fantasyShouldChoosePegi(){
        Fantasy fantasy = new Fantasy("Fantasy");
        fantasy.choosePegi();
        Assert.assertEquals("Choose rating is M because genre: Fantasy",output.toString());
    }

    @Test
    public void fantasyShouldChooseFilm(){
        Fantasy fantasy = new Fantasy("Fantasy");
        Film film = new Film("Avatar");
        fantasy.chooseFilm(film);
        Assert.assertEquals("Choose this Avatar with genre: Fantasy",output.toString());
    }
}
