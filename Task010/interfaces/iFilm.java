package Task010.interfaces;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ruslanzigansin on 11.02.16.
 */
public interface iFilm {
    String name = null;
    String country = null;
    Date date = null;
    Genre genre = null;

    ArrayList<iActor> showFilm();
    Cinema releaseInCinema(Cinema cinema);
    Genre chooseGenre(Genre genre);
    String getName();
}
