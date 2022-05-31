package A;

/**
 * Models a music track with the following attributes:
 * Its id, artist, title, length, remaining duration and priority.
 * @author ugpsy
 * @version 1.0
 */
public class Track {
    private int id;
    private String artist;
    private String title;
    private int length;
    private int remaining;
    private int priority;

    /**
     * Constructor for the class Track.
     */
    public Track(int id, String artist, String title, int length, int priority) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.length = length;
        this.priority = priority;
        this.remaining = length;
    }

    /**
     * Getter method for the track's id.
     * @return track's id.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter method for the artist who has created the track.
     * @return the name of the artist.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Getter method for the track's title.
     * @return the title of the track.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter method for the track's length.
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * Getter method for the track's remaining duration.
     * @return remaining duration.
     */
    public int getRemaining() {
        return remaining;
    }

    /**
     * Setter method for the track's remaining duration.
     * @param remaining remaining duration of the track in seconds.
     */
    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    /**
     * Getter method for the track's priority.
     * @return track's priority
     */
    public int getPriority() {
        return priority;
    }
}
