package Task004.TestClasses;

import Task004.Classes.DreamCinema;
import Task004.Classes.Film;
import Task004.Classes.Seller;
import Task004.Classes.Viewer;
import Task004.Interfaces.Cinema;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class VeiwerTest extends OutputTest {

    @Test
    public void someoneShouldWatchTheFilm() {
        Viewer viewer = new Viewer("Man");
        Film film = new Film("It");
         viewer.watchFilm(film);
        Assert.assertEquals("I'm watching It",output.toString());
    }

    @Test
    public void someoneShouldCommentTheFilm() {
        Viewer viewer = new Viewer("Man");
        Film film = new Film("It");
        viewer.watchFilm(film);
        Assert.assertEquals("I'm commenting It",output.toString());
    }

    @Test
    public void someoneShouldToBuyTheTicket() {
        Viewer viewer = new Viewer("Man");
        Seller seller = new Seller("someone");
        viewer.buyTicket(seller);
        Assert.assertEquals("I'm buying ticket from someone",output.toString());
    }

    @Test
    public void someoneShouldToChooseTheCinema() {
        Viewer viewer = new Viewer("Man");
        DreamCinema cinema = new DreamCinema("Dream","Kazan");
        viewer.chooseCinema(cinema);
        Assert.assertEquals("I'm choosing this Dream",output.toString());
    }


}
