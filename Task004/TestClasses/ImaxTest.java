package Task004.TestClasses;

import Task004.Classes.Imax;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class ImaxTest extends OutputTest {
    @Test
    public void arrayWithFilmShouldToShowFilmsAndReturnNull(){
        Imax film = new Imax("Imax","Kazan");
        film.showFilms();
        Assert.assertEquals(null,film.showFilms());
    }

    @Test
    public void arrayWithFilmShouldToInviteVisitorAndReturnNull(){
        Imax film = new Imax("Imax","Kazan");
        film.inviteVisitors();
        Assert.assertEquals(null,film.inviteVisitors());
    }

    @Test
    public void arrayWithFilmShouldToSellTicketsAndReturnNull(){
        Imax film = new Imax("Imax","Kazan");
        film.inviteVisitors();
        Assert.assertEquals(null,film.sellTickets());
    }

    @Test
    public void cinemaShouldTakeMoney(){
        Imax cinema = new Imax("Imax","Kazan");
        cinema.takeMoney();
        Assert.assertEquals("Imax take money from Imax",output.toString());
    }
}
