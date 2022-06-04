package A;


/**
 * The class Simulator simulates a music playlist. It contains all the methods given in the
 * assignment alongside some private helper methods.
 * @author ugpsy
 * @version 1.0
 */
public class Simulator {
    private Track currentTrack; // The current track on the playlist which is on the top of the priority queue.
    private final TrackList[] trackListArray; // An array that will contain 6 track lists with each of them containing tracks
    // with a common priority from 0 to 5.
    private final TrackList playedTracks; // A list of all the previously played songs.

    /**
     * Constructor for the class.
     * Fills the trackListArray with 6 track lists.
     * Sets the current track as null initially.
     */
    public Simulator() {
        this.playedTracks = new TrackList();
        this.trackListArray = new TrackList[6];
        for (int i = 0; i < trackListArray.length; i++) {
            trackListArray[i] = new TrackList();
        }
        this.currentTrack = null;
    }

    /**
     * A.1.2.1 Adds a new track to the priority queue in accordance with its priority.
     *
     * @param id the id of the track.
     * @param artist the artist that created track.
     * @param title the title of the track.
     * @param length the length of the track.
     * @param priority the priority of the track (0-5)
     */
    public void add(int id, String artist, String title, int length, int priority) {
        Track track = new Track(id, artist, title, length, priority); // Create a new track object with the given attributes.
        trackListArray[priority].addLast(track); // Add the track object to the track list at index n
        // in the trackListArray when the track has priority n.
        this.setCurrentTrack(); // Set the new current track.
    }

    /**
     * A.1.2.2 Removes all instances or a single instance of a track
     * with the given id from the priority queue.
     *
     * @param id the id of the track.
     * @param allInstances determines whether all tracks with the given id will be removed.
     * @return amount of removed tracks. Return empty string if it's zero.
     */
    public String remove(int id, boolean allInstances) {
        int totalRemoved = 0;
        for (TrackList tracks : trackListArray) {
            for (int i = 0; i < tracks.getSize(); i++) {
                if (tracks.getByIndex(i).getId() == id) {
                    if (tracks.getByIndex(i) == this.currentTrack) {
                        this.currentTrack = null; // Sets the current track as null if ids match.
                    }
                    totalRemoved += tracks.removeById(id, allInstances); // Increments by the amount of tracks removed.
                    if (!allInstances) {
                        return null; // Stops the outer loop through track list array if we are not removing all tracks
                        // with the given id but only a single one.
                    }
                    break;
                }
            }
        }
        if (totalRemoved > 0) {
            return "Removed " + totalRemoved + " songs.\n";
        }
        return ""; // If no track is removed, returns an empty string.
    }

    /**
     * A.1.2.3 Simulates playing tracks on a music playlist.
     * @param length Determines how many seconds the playlist will resume.
     */
    public void play(int length) {
        for (TrackList tracks : trackListArray) {
            while(tracks.getSize() != 0) { // Find a track list that is not empty.
                if (length < this.currentTrack.getRemaining()) { // If the given playing length is shorter
                    // than the remaining duration of the current track,
                    // subtract the given length from the remaining portion
                    // of the current track.
                    this.currentTrack.setRemaining(this.currentTrack.getRemaining() - length);
                    return; // Stop the loop.
                }
                length -= this.currentTrack.getRemaining(); // If the given playing length is longer
                // than the remaining duration of the current track,
                // subtract  remaining portion of the current track
                // from the given length and transition to the next song.
                // Continue this until the if condition above is met.
                this.transitionNewTrack();
            }
        }

    }

    /**
     * A.1.2.4 Skips the current track on the playlist.
     */
    public void skip() {
        if (this.currentTrack == null) { // If the current track is null, do nothing.
            return;
        }
        this.remove(this.currentTrack.getId(), false); // Removes the current track from the priority queue
        // This time the parameter allInstances is set to false
        // because we only want to remove a single track from the playlist.
        this.currentTrack = null;
        this.setCurrentTrack(); // Set a new current track.
    }

    /**
     * A.1.2.5 Displays the attributes of the current track on the top of the priority queue.
     * @return the attributes of the current track on the top of the priority queue as a string.
     */
    public String peek() {
        if (this.currentTrack == null) { // If we have no current track, then set one
            this.setCurrentTrack();
            if (this.currentTrack == null) { // If we still have no current track, our playlist must be empty,
                // so return empty string.
                return "";
            }
        }
        // Used a helper method to join the attributes of a track into a single string.
        return this.trackToString(this.currentTrack) + ":" + this.currentTrack.getRemaining() + "\n";
    }

    /**
     * A.1.2.6 Displays the attributes of all the tracks in the priority queue.
     * @return all the tracks in the priority queue line by line.
     */
    public String list() {
        String result = "";
        for (TrackList tracks : trackListArray) { // Go through the priority queue to access every track.
            for (int i = 0; i < tracks.getSize(); i++) {
                result += trackToString(tracks.getByIndex(i)) + "\n"; // Convert the attributes into a string and separate
                // them by \n.
            }
        }
        return result;
    }

    /**
     * A.1.2.7 Displays the attributes of all the previously tracks.
     * Has the same working principle as the .list() method above, but here we go through the list of played tracks.
     * @return all the tracks that have been played.*
     */
    public String history() {
        String result = "";
        for (int i = 0; i < this.playedTracks.getSize(); i++) {
            result += trackToString(this.playedTracks.getByIndex(i)) + "\n";
        }
        return result;
    }

    // Helper Methods

    /**
     * Helps transition to the next track on the playlist.
     */
    private void transitionNewTrack() {
        this.playedTracks.addLast(this.currentTrack); // Add the current track to the list of played tracks.
        this.remove(this.currentTrack.getId(), false); // Remove the current track from the priority queue.
        this.currentTrack = null;
        this.setCurrentTrack(); // Set a new current track.
    }

    /**
     * Helps set the next track on the playlist as the new current track.
     */
    private void setCurrentTrack() {
        for (TrackList tracks : trackListArray) {
            if (tracks.getSize() > 0) { // Find a non-empty track list.
                this.currentTrack = tracks.getByIndex(0); // The first track on that track list is our new current track.
                return;
            }
        }
    }

    /**
     * Builds a string from the attributes of a track.
     * @return a track's attributes
     */
    private String trackToString(Track track) {
        return String.format("%05d", track.getId()) + ":" + track.getArtist() + ":" + track.getTitle() + ":" + track.getLength();
    }
}