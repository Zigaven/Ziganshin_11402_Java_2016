package Task007.classes;

import Task007.interfaces.Cinema;
import Task007.interfaces.iFilm;
import Task007.interfaces.iSeller;
import Task007.interfaces.iViewer;
import org.springframework.stereotype.Component;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
@Component("view")
public class Viewer implements iViewer {
    private String name;
    private Cinema cinema;

    public Viewer() {

    }

    public Viewer(String name, Cinema cinema) {
        this.name = name;
        this.cinema = cinema;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void watchFilm(iFilm film) {
        System.out.print("I'm watching " + film.getName() + "\n");
    }

    @Override
    public void comment(iFilm film) {
        System.out.print("I'm commenting " + film.getName() + "\n");
    }

    @Override
    public void buyTicket(iSeller seller) {
        System.out.print("I'm buying ticket from " + seller.getName() + "\n");
    }

    @Override
    public void chooseCinema(Cinema cinema) {
        System.out.print("I'm choosing this " + cinema.getName() + "\n");
    }
}
