package Task010.classes;

import Task010.interfaces.Cinema;
import Task010.interfaces.iActor;
import Task010.interfaces.iFilm;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class UnderstudyActor extends Viewer implements iActor {

    private String name;

    public UnderstudyActor(String name, Cinema cinema) {
        super(name, cinema);
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
    public String getName() {
        return null;
    }
}
