package Task004.Interfaces;

/**
 * Created by ruslanzigansin on 11.02.16.
 */
public interface iViewer {
    String name = null;
    iFilm film = null;
    Cinema cinema = null;
    iSeller seller = null;

    String getName();
    void watchFilm(iFilm film);
    void comment(iFilm film);
    void buyTicket(iSeller seller);
    void chooseCinema(Cinema cinema);

}
