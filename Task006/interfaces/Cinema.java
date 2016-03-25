package Task006.interfaces;


import java.util.ArrayList;

/**
 * Created by ruslanzigansin on 11.02.16.
 */
public interface Cinema {
    String name = null;
    iFilm film = null;

    ArrayList<iFilm> showFilms();
    ArrayList<iViewer> inviteVisitors();
    ArrayList<iSeller> sellTickets();
    void takeMoney();
    String getName();
}
