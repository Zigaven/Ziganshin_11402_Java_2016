package Task006.classes;

import Task006.interfaces.Cinema;
import Task006.interfaces.iFilm;
import Task006.interfaces.iSeller;
import Task006.interfaces.iViewer;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class Viewer implements iViewer {
    private String name;
    private Cinema cinema;

    public Viewer(String name,Cinema cinema) {
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
        System.out.print("I'm commenting " + film.getName()+ "\n");
    }

    @Override
    public void buyTicket(iSeller seller) {
        System.out.print("I'm buying ticket from " + seller.getName()+ "\n");
    }

    @Override
    public void chooseCinema(Cinema cinema) {
        System.out.print("I'm choosing this " + cinema.getName()+ "\n");
    }
}
