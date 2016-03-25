package Task006; /**
 * Created by ruslanzigansin on 24.03.16.
 */

import Task006.classes.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

        Actor a = (Actor) ac.getBean("stuntman");
        Actor actor = (Actor) ac.getBean("understudy");
        Film f = (Film) ac.getBean("film");
        Film f2 = (Film) ac.getBean("film1");
        Film f3 = (Film) ac.getBean("film2");
        DreamCinema dr = (DreamCinema) ac.getBean("dream");
        KaroFilm kf = (KaroFilm) ac.getBean("karo");
        Imax imax = (Imax) ac.getBean("imax");
        Comedy comedy = (Comedy) ac.getBean("comedy");
        Fantasy fantasy = (Fantasy) ac.getBean("fantasy");
        Horror horror = (Horror)ac.getBean("horror");
        Seller seller = (Seller) ac.getBean("seller");
        Viewer viewer = (Viewer) ac.getBean("viewer");

        System.out.println(a.getName());
        System.out.println(actor.getName());
        a.playInFilm(f);
        actor.voiceInFilm(f2);
        actor.setName("Tom Hardy");
        System.out.println(actor.getName());

        System.out.println(f.chooseGenre(comedy));
        System.out.println(f.chooseGenre(fantasy));
        System.out.println(f.releaseInCinema(dr));
        System.out.println(f.showFilm());
        f.choosePegi();
        System.out.println(f);

        fantasy.choosePegi();
        fantasy.chooseFilm(f2);
        fantasy.setName("WOW");
        System.out.println(fantasy);
        horror.chooseFilm(f2);
        horror.choosePegi();
        comedy.chooseFilm(f3);
        comedy.setName("AHAH");
        System.out.println(comedy);

        dr.inviteVisitors();
        dr.sellTickets();
        kf.showFilms();
        System.out.println(dr);
        System.out.println(kf);
        imax.takeMoney();

        seller.chooseJob(imax);
        seller.recommendFilm(f2);
        seller.sellTicket();
        seller.sellTicketToViewer(viewer);

        viewer.buyTicket(seller);
        viewer.chooseCinema(dr);
        viewer.comment(f);
        viewer.watchFilm(f2);



    }
}