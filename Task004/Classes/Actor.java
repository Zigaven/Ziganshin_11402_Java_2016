package Task004.Classes;

import Task004.Interfaces.iFilm;
import Task004.Interfaces.iActor;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class Actor implements iActor {
    private String name;

    public Actor(String name) {
        this.name = name;
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

}
