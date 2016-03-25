package Task010.classes;

import Task010.interfaces.iActor;
import Task010.interfaces.iFilm;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class Actor implements iActor {
    private String name;
    private Film film;

    public Actor(String name, Film film) {
        this.name = name;
        this.film = film;
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
    public void playInFilm(iFilm film) {
        System.out.print("I'm playing in " + film.getName());
    }

    @Override
    public void voiceInFilm(iFilm film) {
        System.out.print("I'm voicing " + film.getName());
    }

    @Override
    public String toString() {
        return "";
    }
}
