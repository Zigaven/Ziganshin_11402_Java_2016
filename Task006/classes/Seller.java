package Task006.classes;

import Task006.interfaces.Cinema;
import Task006.interfaces.iFilm;
import Task006.interfaces.iViewer;
import Task006.interfaces.iSeller;

import java.util.ArrayList;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class Seller implements iSeller {
    private String name;
    private iViewer viewer;

    public Seller(String name, iViewer viewer) {
        this.name = name;
        this.viewer = viewer;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void sellTicketToViewer(iViewer viewer) {
        System.out.print("I'm selling ticket to " + viewer.getName() + "\n");
    }

    @Override
    public void chooseJob(Cinema cinema) {
        System.out.print("I'm choosing this job in " + cinema.getName() + "\n");
    }

    @Override
    public void recommendFilm(iFilm film) {
        System.out.print("I'm recommend this " + film.getName() + "\n");
    }

    @Override
    public ArrayList<iFilm> sellTicket() {
        return null;
    }
}
