package Task004.Classes;

import Task004.Interfaces.*;

import java.util.ArrayList;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class KaroFilm implements Cinema {
    private String name;
    private String city;

    public KaroFilm(String name, String city) {
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
        System.out.print(name + " take money from KaroFilm");
    }

    @Override
    public String getName() {
        return name;
    }
}
