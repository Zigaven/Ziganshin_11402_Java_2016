package Task004.TestClasses;

import Task004.Classes.Film;
import Task004.Classes.Horror;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class HorrorTest extends OutputTest {

    @Test
    public void comedyShouldChoosePegi(){
        Horror horror = new Horror("Horror");
        horror.choosePegi();
        Assert.assertEquals("Choose rating is M because genre: Horror",output.toString());
    }

    @Test
    public void comedyShouldChooseFilm(){
        Horror horror = new Horror("Horror");
        Film film = new Film("Dracula");
        horror.chooseFilm(film);
        Assert.assertEquals("Choose this Dracula with genre: Horror",output.toString());
    }
}
