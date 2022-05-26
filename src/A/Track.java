package A;

public class Track {
    private int id;
    private String artist;
    private String title;
    private int length;
    private int remaining;
    private int priority;

    public Track(int id, String artist, String title, int length, int priority) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.length = length;
        this.priority = priority;
        this.remaining = length;
    }

    public int getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public int getPriority() {
        return priority;
    }
}
