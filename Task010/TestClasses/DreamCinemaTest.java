package Task010.TestClasses;

import Task010.classes.DreamCinema;
import Task010.interfaces.Cinema;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class DreamCinemaTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    Cinema dream = (DreamCinema) ac.getBean("dream1");
    @Test
    public void arrayWithFilmShouldToShowFilmsAndReturnNull(){
        dream.showFilms();
        Assert.assertEquals(null,dream.showFilms());
    }

    @Test
    public void arrayWithFilmShouldToInviteVisitorAndReturnNull(){
        dream.inviteVisitors();
        Assert.assertEquals(null,dream.inviteVisitors());
    }

    @Test
    public void arrayWithFilmShouldToSellTicketsAndReturnNull(){
        dream.inviteVisitors();
        Assert.assertEquals(null,dream.sellTickets());
    }

    @Test
    public void cinemaShouldTakeMoney(){
        dream.takeMoney();
        Assert.assertEquals("Dream take money from DreamCinema",output.toString());
    }
}
