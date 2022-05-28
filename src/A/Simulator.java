package A;

public class Simulator {
    private Track currentTrack;
    private final TrackList[] trackList;
    private final TrackList playedTracks;

    public Simulator() {
        this.playedTracks = new TrackList();
        this.trackList = new TrackList[6];
        for (int i = 0; i < trackList.length; i++) {
            trackList[i] = new TrackList();
        }
        this.currentTrack = null;
    }

    public void add(int id, String artist, String title, int length, int priority) {
        Track track = new Track(id, artist, title, length, priority);
        trackList[priority].addLast(track);
        this.setCurrentTrack();
    }

    public String remove(int id, boolean allInstances) {
        int totalRemoved = 0;
        for (TrackList tracks : trackList) {
            for (int i = 0; i < tracks.getSize(); i++) {
                if (tracks.getByIndex(i).getId() == id) {
                    if (tracks.getByIndex(i) == this.currentTrack) {
                        this.currentTrack = null;
                    }
                    totalRemoved += tracks.removeById(id, allInstances);
                    if (!allInstances) {
                        return null;
                    }
                    break;
                }
            }
        }
        if (totalRemoved > 0) {
            return "Removed " + totalRemoved + " songs.\n";
        }
        return "";
    }

    public void play(int length) {
        for (TrackList tracks : trackList) {
            while(tracks.getSize() != 0) {
                if (length < this.currentTrack.getRemaining()) {
                    this.currentTrack.setRemaining(this.currentTrack.getRemaining() - length);
                    return;
                } else {
                    length -= this.currentTrack.getRemaining();
                    this.transitionNewTrack();
                }
            }
        }

    }
    public void skip() {
        if (this.currentTrack == null) {
            return;
        }
        this.remove(this.currentTrack.getId(), false);
        this.currentTrack = null;
        this.setCurrentTrack();
    }

    public String peek() {
        if (this.currentTrack == null) {
            this.setCurrentTrack();
            if (this.currentTrack == null) {
                return "";
            }
        }
        return this.trackToString(this.currentTrack) + ":" + this.currentTrack.getRemaining() + "\n";
    }

    public String list() {
        String result = "";
        for (TrackList tracks : trackList) {
            for (int i = 0; i < tracks.getSize(); i++) {
                result += trackToString(tracks.getByIndex(i)) + "\n";
            }
        }
        return result;
    }

    public String history() {
        String result = "";
        for (int i = 0; i < this.playedTracks.getSize(); i++) {
            result += trackToString(this.playedTracks.getByIndex(i)) + "\n";
        }
        return result;
    }

    // Helper Methods
    private void transitionNewTrack() {
        this.playedTracks.addLast(this.currentTrack);
        this.remove(this.currentTrack.getId(), false);
        this.currentTrack = null;
        this.setCurrentTrack();
    }

    private void setCurrentTrack() {
        for (TrackList tracks : trackList) {
            if (tracks.getSize() > 0) {
                this.currentTrack = tracks.getByIndex(0);
                return;
            }
        }
    }

    private String trackToString(Track track) {
        return String.format("%05d", track.getId()) + ":" + track.getArtist() + ":" + track.getTitle() + ":" + track.getLength() + ":" + track.getPriority();
    }
}
