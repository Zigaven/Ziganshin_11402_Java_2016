package Task010.TestClasses;

import Task010.classes.Imax;
import Task010.interfaces.Cinema;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class ImaxTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    Cinema imax = (Imax) ac.getBean("imax1");
    @Test
    public void arrayWithFilmShouldToShowFilmsAndReturnNull(){
        imax.showFilms();
        Assert.assertEquals(null,imax.showFilms());
    }

    @Test
    public void arrayWithFilmShouldToInviteVisitorAndReturnNull(){
        imax.inviteVisitors();
        Assert.assertEquals(null,imax.inviteVisitors());
    }

    @Test
    public void arrayWithFilmShouldToSellTicketsAndReturnNull(){
        imax.inviteVisitors();
        Assert.assertEquals(null,imax.sellTickets());
    }

    @Test
    public void cinemaShouldTakeMoney(){
        imax.takeMoney();
        Assert.assertEquals("Imax take money from people",output.toString());
    }
}
