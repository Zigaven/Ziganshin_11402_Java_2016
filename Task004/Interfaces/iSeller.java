package Task004.Interfaces;

import java.util.ArrayList;

/**
 * Created by ruslanzigansin on 11.02.16.
 */
public interface iSeller {
    String name = null;
    iFilm film = null;
    Cinema cinema = null;
    iViewer viewer = null;

    String getName();

    void sellTicketToViewer(iViewer viewer);

    void chooseJob(Cinema cinema);

    void recommendFilm(iFilm film);

    ArrayList<iFilm> sellTicket();
}
