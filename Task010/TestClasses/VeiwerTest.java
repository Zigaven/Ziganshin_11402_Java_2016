package Task010.TestClasses;

import Task010.classes.DreamCinema;
import Task010.classes.Film;
import Task010.classes.Seller;
import Task010.classes.Viewer;
import Task010.interfaces.Cinema;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class VeiwerTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    Viewer viewer = (Viewer) ac.getBean("viewer1");
    @Test
    public void someoneShouldWatchTheFilm() {
        Film film = (Film) ac.getBean("film0");
         viewer.watchFilm(film);
        Assert.assertEquals("I'm watching Avatar",output.toString());
    }

    @Test
    public void someoneShouldCommentTheFilm() {
        Film film = (Film) ac.getBean("film01");
        viewer.comment(film);
        Assert.assertEquals("I'm commenting Hangover",output.toString());
    }

    @Test
    public void someoneShouldToBuyTheTicket() {
        Seller seller = (Seller) ac.getBean("seller1");
        viewer.buyTicket(seller);
        Assert.assertEquals("I'm buying ticket from Seller",output.toString());
    }

    @Test
    public void someoneShouldToChooseTheCinema() {
        Cinema dream = (DreamCinema) ac.getBean("dream1");
        viewer.chooseCinema(dream);
        Assert.assertEquals("I'm choosing this Dream",output.toString());
    }


}
