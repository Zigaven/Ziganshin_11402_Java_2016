package Task004.Classes;

import Task004.Interfaces.iActor;
import Task004.Interfaces.iFilm;
import Task004.Interfaces.iViewer;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class StuntmanActor extends Viewer implements iActor {
    private String name;

    public StuntmanActor(String name) {
        super(name);
        this.name = name;
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
