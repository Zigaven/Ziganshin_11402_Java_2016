package Task004.TestClasses;

import Task004.Classes.KaroFilm;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class KaroFilmTest extends OutputTest {

    @Test
    public void arrayWithFilmShouldToShowFilmsAndReturnNull(){
        KaroFilm film = new KaroFilm("Karo","Kazan");
        film.showFilms();
        Assert.assertEquals(null,film.showFilms());
    }

    @Test
    public void arrayWithFilmShouldToInviteVisitorAndReturnNull(){
        KaroFilm film = new KaroFilm("Karo","Kazan");
        film.inviteVisitors();
        Assert.assertEquals(null,film.inviteVisitors());
    }

    @Test
    public void arrayWithFilmShouldToSellTicketsAndReturnNull(){
        KaroFilm film = new KaroFilm("Karo","Kazan");
        film.inviteVisitors();
        Assert.assertEquals(null,film.sellTickets());
    }

    @Test
    public void cinemaShouldTakeMoney(){
        KaroFilm cinema = new KaroFilm("Karo","Kazan");
        cinema.takeMoney();
        Assert.assertEquals("Karo take money from KaroFilm",output.toString());
    }

}
