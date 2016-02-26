package Task004.Classes;

import Task004.Interfaces.Cinema;
import Task004.Interfaces.iFilm;
import Task004.Interfaces.iSeller;
import Task004.Interfaces.iViewer;

import java.util.ArrayList;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class Imax implements Cinema {
    private String name;
    private String city;

    public Imax(String name, String city) {
        this.name = name;
        this.city = city;
    }
    @Override
    public ArrayList<iFilm> showFilms() {
        return null;
    }

    @Override
    public ArrayList<iViewer> inviteVisitors() {
        return null;
    }

    @Override
    public ArrayList<iSeller> sellTickets() {
        return null;
    }

    @Override
    public void takeMoney() {
        System.out.print(name + " take money from Imax");
    }

    @Override
    public String getName() {
        return name;
    }
}
