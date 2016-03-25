package Task007.classes;

import Task007.interfaces.Genre;
import Task007.interfaces.iFilm;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class Horror implements Genre {
    private String name;

    public Horror(String name) {
        this.name = name;
    }

    @Override
    public void choosePegi() {
        System.out.print("Choose rating is R because genre: " + name + "\n");
    }

    @Override
    public void chooseFilm(iFilm film) {
        System.out.print("Choose this " + film.getName() + " with genre: " + name + "\n");
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
        return "Horror{" +
                "name='" + name + '\'' +
                '}';
    }
}
