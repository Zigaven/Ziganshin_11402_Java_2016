package Task004.TestClasses;

import Task004.Classes.Comedy;
import Task004.Classes.Film;
import Task004.Classes.Imax;
import Task004.Interfaces.Genre;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class FilmTest extends OutputTest {

    @Test
    public void arrayWithActorShouldBeNullAndShowFilm(){
        Film film = new Film("film");
        film.showFilm();
        Assert.assertEquals(null,film.showFilm());
    }

    @Test
    public void filmShouldToReleaseInCinema(){
        Film film = new Film("Inception");
        Imax cinema = new Imax("Imax","Kazan");
        film.releaseInCinema(cinema);
        Assert.assertEquals(cinema,film.releaseInCinema(cinema));
    }

    @Test
    public void filmShouldToChoosePegi(){
        Film film = new Film("Fish");
        film.choosePegi();
        Assert.assertEquals("I'm choosing rating is R",output.toString());
    }

    @Test
    public void filmShouldToChooseGenre(){
        Film film = new Film("AntMan");
        Comedy comedy = new Comedy("Comedy");
        film.chooseGenre(comedy);
        Assert.assertEquals(comedy,film.chooseGenre(comedy));
    }
}
