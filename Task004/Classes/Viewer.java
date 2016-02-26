package Task004.Classes;

import Task004.Interfaces.Cinema;
import Task004.Interfaces.iFilm;
import Task004.Interfaces.iSeller;
import Task004.Interfaces.iViewer;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class Viewer implements iViewer {
    private String name;

    public Viewer(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void watchFilm(iFilm film) {
        System.out.print("I'm watching " + film.getName() );
    }

    @Override
    public void comment(iFilm film) {
        System.out.print("I'm commenting " + film.getName());
    }

    @Override
    public void buyTicket(iSeller seller) {
        System.out.print("I'm buying ticket from " + seller.getName());
    }

    @Override
    public void chooseCinema(Cinema cinema) {
        System.out.print("I'm choosing this " + cinema.getName());
    }
}
