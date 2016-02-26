package Task004.TestClasses;

import Task004.Classes.Film;
import Task004.Classes.KaroFilm;
import Task004.Classes.Seller;
import Task004.Classes.Viewer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class SellerTest extends OutputTest {
    @Test
    public void someoneShouldToSellTicketsToViewer() {
        Seller seller = new Seller("people");
        Viewer viewer = new Viewer("man");
        seller.sellTicketToViewer(viewer);
        Assert.assertEquals("I'm selling ticket to man", output.toString());
    }

    @Test
    public void someoneShouldChooseTheJob() {
        Seller seller = new Seller("people");
        KaroFilm cinema = new KaroFilm("Karo", "Kazan");
        seller.chooseJob(cinema);
        Assert.assertEquals("I'm choosing this job in Karo", output.toString());
    }

    @Test
    public void someoneShouldRecommendTheFilm() {
        Seller seller = new Seller("people");
        Film film = new Film("DeadPool");
        seller.recommendFilm(film);
        Assert.assertEquals("I'm recommend this DeadPool", output.toString());
    }
}
