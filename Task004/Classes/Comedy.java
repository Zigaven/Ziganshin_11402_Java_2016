package Task004.Classes;

import Task004.Interfaces.Genre;
import Task004.Interfaces.iFilm;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class Comedy implements Genre {
    private String name;

    public Comedy(String name) {
        this.name = name;
    }

    @Override
    public void choosePegi() {
        System.out.print("Choose rating is M because genre: " + name);
    }


    @Override
    public void chooseFilm(iFilm film) {
        System.out.print("Choose this " + film.getName() + " with genre: " + name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
