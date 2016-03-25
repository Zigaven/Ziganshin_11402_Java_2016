package Task010.classes;

import Task010.interfaces.Genre;
import Task010.interfaces.iFilm;

/**
 * Created by ruslanzigansin on 15.02.16.
 */
public class Fantasy implements Genre {
    private String name;

    public Fantasy(String name) {
        this.name = name;
    }

    @Override
    public void choosePegi() {
        System.out.print("Choose rating M because genre: " + name);
    }

    @Override
    public void chooseFilm(iFilm film) {
        System.out.print("Choose this " + film.getName() + " with genre: " + name);
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
        return "Fantasy{" +
                "name='" + name + '\'' +
                '}';
    }
}
