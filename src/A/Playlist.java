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
                    totalRemoved += tracks.remove(id);
                    break;
                }
            }
        }
        return totalRemoved;
    }

    public void play(int length) {
        boolean hasStopped = false;
        for (TrackList tracks : trackList) {
            for (int i = 0; i < tracks.getSize(); i++) {
                    this.currentTrack = tracks.getByIndex(i);
                    if (length < this.currentTrack.getLength()) {
                        this.currentTrack.setRemaining(this.currentTrack.getRemaining() - length);
                        hasStopped = true;
                        break;
                    }
                    else {
                        length -= this.currentTrack.getLength();
                    }
            }
            if (hasStopped) {
                break;
            }
        }
    }

    public void skip() {
        remove(this.currentTrack.getId());
        this.currentTrack = this.cur

    }

    public String peek() {
        return trackToString(this.currentTrack) + ":" + this.currentTrack.getRemaining();
    }

    public String list() {
        String result = "";
        for (TrackList tracks : trackList) {
            System.out.println(tracks.getSize());
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
    private String trackToString(Track track) {
        return track.getId() + ":" + track.getArtist() + ":" + track.getTitle() + ":" + track.getLength() + ":" + track.getPriority();
    }
}
