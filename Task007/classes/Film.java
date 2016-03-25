package Task007.classes;

import Task007.interfaces.Cinema;
import Task007.interfaces.Genre;
import Task007.interfaces.iActor;
import Task007.interfaces.iFilm;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by ruslanzigansin on 15.02.16.
 */

public class Film implements iFilm, Genre {
    private String name;
    private Cinema cinema;
    private Genre genre;

    public Film(String name, Cinema cinema, Genre genre) {
        this.name = name;
        this.cinema = cinema;
        this.genre = genre;
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

    @Override
    public String toString() {
        return "";
    }
}
