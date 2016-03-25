package Task007;

import Task007.classes.*;
import Task007.interfaces.Cinema;
import Task007.interfaces.Genre;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Created by ruslanzigansin on 24.03.16.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        Actor actor = (Actor) ac.getBean("actorer");
        Film film = (Film) ac.getBean("film");
        Film film1 = (Film) ac.getBean("film1");
        Film film2 = (Film) ac.getBean("film2");
        actor.getName();
        actor.playInFilm(film);

        StuntmanActor a = (StuntmanActor) ac.getBean("sactor");
        UnderstudyActor ua = (UnderstudyActor) ac.getBean("uactor");
        ua.playInFilm(film1);
        ua.voiceInFilm(film1);
        a.playInFilm(film2);
        a.setName("Jack");
        System.out.println(a);

        Cinema dream = (DreamCinema) ac.getBean("dream");
        Cinema karo = (KaroFilm) ac.getBean("karo");
        Cinema imax = (Imax) ac.getBean("imax");

        Genre fantasy = (Fantasy) ac.getBean("fantasy");
        Genre comedy = (Comedy) ac.getBean("comedy");
        Genre horror = (Horror) ac.getBean("horror");

        System.out.println(actor.toString());
        Seller seller = (Seller) ac.getBean("sell");
        seller.recommendFilm(film1);
        seller.chooseJob(imax);

        Viewer viewer = (Viewer) ac.getBean("view");
        viewer.getName();
        viewer.comment(film);
        viewer.watchFilm(film1);

        dream.inviteVisitors();
        karo.sellTickets();
        imax.showFilms();

        fantasy.choosePegi();
        horror.chooseFilm(film2);
        comedy.getName();
        System.out.println(comedy);

    }
}
