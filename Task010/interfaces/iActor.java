package Task010.interfaces;

/**
 * Created by ruslanzigansin on 11.02.16.
 */
public interface iActor {
    String name = null;
    String surname = null;
    String country = null;
    iFilm film = null;
    Genre genre = null;

    public String getName();
    public void setName(String name);
    public void playInFilm(iFilm film);
    public void voiceInFilm(iFilm film);
}
