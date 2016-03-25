package Task010.TestClasses;

import Task010.classes.Film;
import Task010.classes.KaroFilm;
import Task010.classes.Seller;
import Task010.classes.Viewer;
import Task010.interfaces.Cinema;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class SellerTest extends OutputTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
    Seller seller = (Seller) ac.getBean("seller1");
    @Test
    public void someoneShouldToSellTicketsToViewer() {
        Viewer viewer = (Viewer) ac.getBean("viewer1");
        seller.sellTicketToViewer(viewer);
        Assert.assertEquals("I'm selling ticket to Viewer", output.toString());
    }

    @Test
    public void someoneShouldChooseTheJob() {
        Cinema karo = (KaroFilm) ac.getBean("karo1");
        seller.chooseJob(karo);
        Assert.assertEquals("I'm choosing this job in Karo", output.toString());
    }

    @Test
    public void someoneShouldRecommendTheFilm() {
Film film = (Film) ac.getBean("film01");
        seller.recommendFilm(film);
        Assert.assertEquals("I'm recommend this Hangover", output.toString());
    }
}
