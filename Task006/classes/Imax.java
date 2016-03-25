package Task006.classes;

import Task006.interfaces.Cinema;
import Task006.interfaces.iFilm;
import Task006.interfaces.iSeller;
import Task006.interfaces.iViewer;

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
        System.out.print(name + " take money from people" + "\n");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Imax{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
