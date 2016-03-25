package Task007.interfaces;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ruslanzigansin on 11.02.16.
 */
@Component
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
