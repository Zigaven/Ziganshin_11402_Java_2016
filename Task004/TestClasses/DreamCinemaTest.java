package Task004.TestClasses;

import Task004.Classes.DreamCinema;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class DreamCinemaTest extends OutputTest {
    @Test
    public void arrayWithFilmShouldToShowFilmsAndReturnNull(){
        DreamCinema cinema = new DreamCinema("Dream","Kazan");
        cinema.showFilms();
        Assert.assertEquals(null,cinema.showFilms());
    }

    @Test
    public void arrayWithFilmShouldToInviteVisitorAndReturnNull(){
        DreamCinema cinema = new DreamCinema("Dream","Kazan");
        cinema.inviteVisitors();
        Assert.assertEquals(null,cinema.inviteVisitors());
    }

    @Test
    public void arrayWithFilmShouldToSellTicketsAndReturnNull(){
        DreamCinema cinema = new DreamCinema("Dream","Kazan");
        cinema.inviteVisitors();
        Assert.assertEquals(null,cinema.sellTickets());
    }

    @Test
    public void cinemaShouldTakeMoney(){
        DreamCinema cinema = new DreamCinema("Dream","Kazan");
        cinema.takeMoney();
        Assert.assertEquals("Dream take money from DreamCinema",output.toString());
    }
}
