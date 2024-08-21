import java.util.List;

public class Movie {
    private String title;
    private String genre;
    private List<Show> shows;

    public Movie(String title, String genre, List<Show> shows) {
        this.title = title;
        this.genre = genre;
        this.shows = shows;
    }

    public String getTitle() {
        return title;
    }

    public List<Show> getShows() {
        return shows;
    }
}
