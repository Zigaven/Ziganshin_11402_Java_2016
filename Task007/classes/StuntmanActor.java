package Task007.classes;

import Task007.interfaces.iActor;
import Task007.interfaces.iFilm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by ruslanzigansin on 15.02.16.
 */

public class StuntmanActor implements iActor {
    private String name;

    public StuntmanActor() {

    }

    public StuntmanActor(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void playInFilm(iFilm film) {
        System.out.println("I'm playing in " + film.getName()+ "\n");
    }

    @Override
    public void voiceInFilm(iFilm film) {
        System.out.println("I'm voicing " + film.getName()+ "\n");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "StuntmanActor{" +
                "name='" + name + '\'' +
                '}';
    }
}
