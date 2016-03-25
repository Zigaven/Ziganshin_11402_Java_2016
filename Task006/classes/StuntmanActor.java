package Task006.classes;

import Task006.interfaces.Cinema;
import Task006.interfaces.iViewer;
import Task006.interfaces.iActor;
import Task006.interfaces.iFilm;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class StuntmanActor extends Viewer implements iActor {
    private String name;

    public StuntmanActor(String name, Cinema cinema) {
        super(name, cinema);
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void playInFilm(iFilm film) {
        System.out.println("I'm playing in " + film.getName());
    }

    @Override
    public void voiceInFilm(iFilm film) {
        System.out.println("I'm voicing " + film.getName());
    }

    @Override
    public String getName() {
        return null;
    }


}
