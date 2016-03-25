package Task007.classes;

import Task007.interfaces.iActor;
import Task007.interfaces.iFilm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by ruslanzigansin on 26.02.16.
 */

public class UnderstudyActor  implements iActor {

    private String name;
    private Film film;

    public UnderstudyActor() {

    }

    public UnderstudyActor(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void playInFilm(iFilm film) {
        System.out.print("I'm playing in " + film.getName() + "\n");
    }

    @Override
    public void voiceInFilm(iFilm film) {
        System.out.print("I'm voicing " + film.getName()+ "\n");
    }

    @Override
    public String getName() {
        return name;
    }

    public UnderstudyActor(String name, Film film) {
        this.name = name;
        this.film = film;
    }
}
