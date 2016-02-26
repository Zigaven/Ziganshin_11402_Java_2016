package Task004.Classes;

import Task004.Interfaces.iActor;
import Task004.Interfaces.iFilm;

/**
 * Created by ruslanzigansin on 26.02.16.
 */
public class UnderstudyActor extends Viewer implements iActor {

    private String name;

    public UnderstudyActor(String name) {
        super(name);
        this.name = name;
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
