package Task004.Classes;

import Task004.Interfaces.Cinema;
import Task004.Interfaces.Genre;
import Task004.Interfaces.iActor;
import Task004.Interfaces.iFilm;

import java.util.ArrayList;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class Film implements iFilm,Genre {
    private String name;
    private Cinema cinema;
    private Genre genre;

    public Film(String name) {
        this.name = name;
    }

    @Override
    public ArrayList<iActor> showFilm() {
        return null;
    }

    @Override
    public Cinema releaseInCinema(Cinema cinema) {
        return cinema;
    }

    @Override
    public Genre chooseGenre(Genre genre) {
        return genre;
    }

    @Override
    public void choosePegi() {
        System.out.println("I'm choosing rating is R");
    }

    @Override
    public void chooseFilm(iFilm film) {

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
