package A;

public class Playlist {
    private Track currentTrack;
    private int size;
    private TrackList[] trackList;

    public Playlist() {
        this.trackList = new TrackList[6];
        for (int i = 0; i < trackList.length; i++) {
            trackList[i] = new TrackList();
        }
        this.currentTrack = null;
        this.size = 0;
    }

    public void add(int id, String artist, String title, int length, int priority) {
        Track track = new Track(id, artist, title, length, priority);
        trackList[priority].addLast(track);
        System.out.println(trackList[priority]);
        this.size++;
    }

    public int remove(int id) {
        int totalRemoved = 0;
        for (TrackList tracks : trackList) {
            for (int i = 0; i < tracks.getSize(); i++) {
                if (tracks.getByIndex(i).getId() == id) {
                    totalRemoved += tracks.removeById(id, true);
                    break;
                }
            }
        }
        return totalRemoved;
    }

    public void play(int length) {
        boolean hasStopped = false;
        if (this.currentTrack == null) {
            this.setCurrentTrack();
        }
        for (TrackList tracks : trackList) {
            for (int i = 0; i < tracks.getSize(); i++) {
                if (tracks.getByIndex(i) == this.currentTrack) {
                    if (length < this.currentTrack.getRemaining()) {
                        this.currentTrack.setRemaining(this.currentTrack.getRemaining() - length);
                        hasStopped = true;
                        break;
                    } else {
                        System.out.println("new");
                        length -= this.currentTrack.getRemaining();
                        this.setCurrentTrack();

                    }
                }
            }
            if (hasStopped) {
                break;
            }
        }
    }
    public void skip() {
        remove(this.currentTrack.getId());
        this.setCurrentTrack();
    }

    public String peek() {
        return trackToString(this.currentTrack) + ":" + this.currentTrack.getRemaining();
    }

    public String list() {
        String result = "";
        for (TrackList tracks : trackList) {
            for (int i = 0; i < tracks.getSize(); i++) {
                result += trackToString(tracks.getByIndex(i)) + "\n";
            }
        }
        try {
            return result.substring(0, result.length() - 1);
        } catch (Exception e) {
            return result;
        }

    }
    public String history() {
        return "";
    }
    private Track setCurrentTrack() {
        if (this.currentTrack == null) {
            for (TrackList tracks : trackList) {
                if (tracks.getSize() > 0) {
                    this.currentTrack = tracks.getByIndex(0);
                    return this.currentTrack;
                }
            }
        }
        else {
            boolean isNewCurrentTrack = false;
            for (TrackList tracks : trackList) {
                for (int i = 0; i < tracks.getSize(); i++) {
                    if (isNewCurrentTrack) {
                        System.out.println("found it");
                        this.currentTrack = tracks.getByIndex(i);
                        return this.currentTrack;
                    }
                    if (tracks.getByIndex(i) == this.currentTrack) {
                        System.out.println("found it");
                        isNewCurrentTrack = true;
                    }
                }
            }
        }
        return null;
    }
    private String trackToString(Track track) {
        return track.getId() + ":" + track.getArtist() + ":" + track.getTitle() + ":" + track.getLength() + ":" + track.getPriority();
    }
}
