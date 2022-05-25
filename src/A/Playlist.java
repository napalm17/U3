package A;

public class Playlist {
    private ArrayList trackList;

    public Playlist() {
        this.trackList = new ArrayList();
    }

    public void add(int id, String artist, String title, int length, int priority) {
        Track track = new Track(id, artist, title, length, priority);
        trackList.insert(track);
    }

    public int remove(int id) {
        return -1;
    }

    public void play(int length) {

    }

    public void skip() {

    }

    public String peek() {
        return "";
    }

    public String list() {
        return "";
    }

    public String history() {
        return "";
    }
}
