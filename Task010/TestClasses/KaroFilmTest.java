package Task010.TestClasses;

import Task010.classes.KaroFilm;
import Task010.interfaces.Cinema;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class KaroFilmTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    Cinema karo = (KaroFilm) ac.getBean("karo1");

    @Test
    public void arrayWithFilmShouldToShowFilmsAndReturnNull(){
        karo.showFilms();
        Assert.assertEquals(null,karo.showFilms());
    }

    @Test
    public void arrayWithFilmShouldToInviteVisitorAndReturnNull(){
        karo.inviteVisitors();
        Assert.assertEquals(null,karo.inviteVisitors());
    }

    @Test
    public void arrayWithFilmShouldToSellTicketsAndReturnNull(){
        karo.inviteVisitors();
        Assert.assertEquals(null,karo.sellTickets());
    }

    @Test
    public void cinemaShouldTakeMoney(){
        karo.takeMoney();
        Assert.assertEquals("Karo take money from people",output.toString());
    }

}
