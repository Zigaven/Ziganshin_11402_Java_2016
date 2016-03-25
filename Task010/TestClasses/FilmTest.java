package Task010.TestClasses;

import Task010.interfaces.Cinema;
import Task010.classes.Comedy;
import Task010.classes.Fantasy;
import Task010.classes.Film;
import Task010.classes.Imax;
import Task010.interfaces.Genre;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class FilmTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    @Test
    public void arrayWithActorShouldBeNullAndShowFilm(){
        Film film = (Film) ac.getBean("film02");
        film.showFilm();
        Assert.assertEquals(null,film.showFilm());
    }

    @Test
    public void filmShouldToReleaseInCinema(){
        Film film = (Film) ac.getBean("film01");
        Cinema imax = (Imax) ac.getBean("imax1");
        film.releaseInCinema(imax);
        Assert.assertEquals(imax,film.releaseInCinema(imax));
    }

    @Test
    public void filmShouldToChoosePegi(){
        Film film = (Film) ac.getBean("film0");
        film.choosePegi();
        Assert.assertEquals("I'm choosing rating is R",output.toString());
    }

    @Test
    public void filmShouldToChooseGenre(){
        Film film = (Film) ac.getBean("film02");
        Genre comedy = (Comedy) ac.getBean("comedy1");
        film.chooseGenre(comedy);
        Assert.assertEquals(comedy,film.chooseGenre(comedy));
    }
}
